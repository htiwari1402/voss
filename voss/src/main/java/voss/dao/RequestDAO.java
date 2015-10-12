package voss.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.jdbc.core.RowMapper;

import voss.domain.Request;

public class RequestDAO extends DAO {

	  @SuppressWarnings("unchecked")
	public List<Request> getAllRequests(int id)
	  {
		  String SQL = "select * from requestmaster where userId = ?";
		  return this.jt.query(SQL,new Object[]{id},new  RowMapper()
			{

				@Override
				public Request  mapRow(ResultSet rs, int rn) throws SQLException 
				{
				    return new Request(rs.getInt("userId"),rs.getInt("requestingUserId"),rs.getString("requesttable")
				    										,rs.getString("requestIdName"),rs.getInt("activationFlag"),rs.getString("requestTableStatusName")
				    										,rs.getString("updatedRequestValue"),rs.getString("requestMasterName"),rs.getString("date"),
				    										rs.getInt("requestID"),rs.getString("requestIdValue"));
				}
		
			});
	  }
	  
	  @SuppressWarnings("unchecked")
	public void approveRequest(int requestID)
	  {
		  String SQL = "select * from requestmaster where requestID = ?";
		  List<Request> req = new ArrayList<Request>();
		  req = this.jt.query(SQL,new Object[]{requestID},new  RowMapper()
			{

				@Override
				public Request  mapRow(ResultSet rs, int rn) throws SQLException 
				{
				    return new Request(rs.getInt("userId"),rs.getInt("requestingUserId"),rs.getString("requesttable")
				    										,rs.getString("requestIdName"),rs.getInt("activationFlag"),rs.getString("requestTableStatusName")
				    										,rs.getString("updatedRequestValue"),rs.getString("requestMasterName"),rs.getString("date"),
				    										rs.getInt("requestID"),rs.getString("requestIdValue"));
				}
		
			});
		  Request r = new Request();
		  r = req.get(0);
		  String appSQL = "update "+r.getRequesttable()+"  set  "+r.getRequestTableStatusName()+ " = '"+r.getUpdatedRequestValue()
				  							+"' where "+r.getRequestIdName()+ " = "+r.getRequestIdValue();
		  System.out.println(appSQL);
		  this.jt.update(appSQL);
	  }
	  public void rejectRequest(int requestID)
	  {
		  String SQL = "delete from requestmaster where requestID = ?";
		  this.jt.update(SQL, new Object[]{requestID});
	  }
	  public void createRequest(Request r)
	  {
		  String sql =  "INSERT INTO requestmaster (userId, requestingUserId, requesttable, requestIdName,activationFlag, requestTableStatusName, updatedRequestValue, requestMasterName, date, requestIdValue) VALUES "
		  		+ " (?, ?, ?, ?, ?, ?, ?, ?, ?,? )";
		  this.jt.update(sql, new Object[]{r.getUserId(),r.getRequestingUserId(),r.getRequesttable(),r.getRequestIdName(),r.getActivationFlag()
				  ,r.getRequestTableStatusName(),r.getUpdatedRequestValue(),r.getRequestMasterName(),r.getDate(),r.getRequestIdValue()});
	  }
}
