function loadContent(divName)
{
  $.post(
		  '/',
		  '',
		  function(data)
		  {
			  $('#main').html(data);
			  $('#sf').tooltip({content : data});
		  }
  );	
}