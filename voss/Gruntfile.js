module.exports = function(grunt) {

  grunt
          .initConfig({
            pkg: grunt.file.readJSON('package.json'),
            "bower-install-simple": {
              options: {
                color: true,
                directory: "lib"
              },
              "prod": {
                options: {
                  production: true
                }
              },
              "dev": {
                options: {
                  production: false
                }
              }
            },
            concat: {
            	js: {
            	    src: 'src/main/resources/static/app/js/*.js',
            	    dest: 'src/main/resources/static/app/jsFinal/voss.js'
            	  }
            },
            uglify: {
              
            },
            jshint: {
              
            },
            csslint: {
              options: {
                csslintrc: '.csslintrc',
                force: true,
                formatters: [
                  {id: 'junit-xml', dest: 'build/reports/csslint/csslint_junit.xml'},
                  {id: 'text', dest: 'build/reports/csslint/csslint.txt'}
                ]
              },
              strict: {
                
              }
            },
            htmlmin: {
              
            },
            copy: {
              main: {
                files: [
                // includes files within path
                {
                  expand: true,
                  flatten: true
                }, ]
              },
              jslibs: {
                files: [
                   ]
              }
            },
            bgShell: {
              startSelenium: {
                cmd: "java -jar "
                        + (grunt.option("seleniumJar") || "selenium-server-standalone-2.42.2.jar"),
                bg: true,
                execOpts: {
                  cwd: grunt.option("seleniumPath")
                          || "node_modules/protractor/selenium/"
                }
              },
              stopSelenium: {
                cmd: "start /b http://localhost:4444/selenium-server/driver?cmd=shutDownSeleniumServer"
              }
            },
            protractor: {
              options: {
                configFile: grunt.option("configFile")
                        || "src/test/js/protractor.conf.js",
                keepAlive: true
              },
              all: {
                keepAlive: true
              }
            },
            wait: {
              test: {
                options: {
                  delay: 5000
                }
              }
            }
          });

  grunt.loadNpmTasks('grunt-bower-install-simple');
  grunt.loadNpmTasks('grunt-contrib-concat');
  grunt.loadNpmTasks('grunt-contrib-jshint');
  grunt.loadNpmTasks('grunt-contrib-csslint');
  grunt.loadNpmTasks('grunt-contrib-uglify');
  grunt.loadNpmTasks('grunt-contrib-htmlmin');
  grunt.loadNpmTasks('grunt-contrib-copy');
  grunt.loadNpmTasks('grunt-protractor-runner');
  grunt.loadNpmTasks('grunt-bg-shell');
  grunt.loadNpmTasks('grunt-wait');

  grunt.option("force", true);
  
  grunt
          .registerTask('build', ['concat', 'jshint','csslint', 'uglify', 'htmlmin',
              'copy']);
  grunt.registerTask('test', ['bgShell:startSelenium', 'wait:test',
      'protractor', 'bgShell:stopSelenium']);
};