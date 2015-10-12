package voss.domain;

public class Request {
			public int userId;
			public int requestingUserId;
			public String requesttable;
			public String requestIdName;
			public String requestIdValue;
			public int activationFlag;
			public String requestTableStatusName;
			public String updatedRequestValue;
			public String requestMasterName;
			public String date;
			public int requestID;
			
			public int getUserId() {
				return userId;
			}
			public void setUserId(int userId) {
				this.userId = userId;
			}
			public int getRequestingUserId() {
				return requestingUserId;
			}
			public void setRequestingUserId(int requestingUserId) {
				this.requestingUserId = requestingUserId;
			}
			public String getRequesttable() {
				return requesttable;
			}
			public void setRequesttable(String requesttable) {
				this.requesttable = requesttable;
			}
			public String getRequestIdName() {
				return requestIdName;
			}
			public void setRequestIdName(String requestIdName) {
				this.requestIdName = requestIdName;
			}
			public int getActivationFlag() {
				return activationFlag;
			}
			public void setActivationFlag(int activationFlag) {
				this.activationFlag = activationFlag;
			}
			public String getRequestTableStatusName() {
				return requestTableStatusName;
			}
			public void setRequestTableStatusName(String requestTableStatusName) {
				this.requestTableStatusName = requestTableStatusName;
			}
			public String getUpdatedRequestValue() {
				return updatedRequestValue;
			}
			public void setUpdatedRequestValue(String updatedRequestValue) {
				this.updatedRequestValue = updatedRequestValue;
			}
			public String getRequestMasterName() {
				return requestMasterName;
			}
			public void setRequestMasterName(String requestMasterName) {
				this.requestMasterName = requestMasterName;
			}
			public String getDate() {
				return date;
			}
			public void setDate(String date) {
				this.date = date;
			}
			public int getRequestID() {
				return requestID;
			}
			public void setRequestID(int requestID) {
				this.requestID = requestID;
			}
			public Request(int userId, int requestingUserId,
					String requesttable, String requestIdName,
					int activationFlag, String requestTableStatusName,
					String updatedRequestValue, String requestMasterName,
					String date, int requestID, String requestIdValue) {
				super();
				this.userId = userId;
				this.requestingUserId = requestingUserId;
				this.requesttable = requesttable;
				this.requestIdName = requestIdName;
				this.activationFlag = activationFlag;
				this.requestTableStatusName = requestTableStatusName;
				this.updatedRequestValue = updatedRequestValue;
				this.requestMasterName = requestMasterName;
				this.date = date;
				this.requestID = requestID;
				this.requestIdValue = requestIdValue;
			}
			
			public String getRequestIdValue() {
				return requestIdValue;
			}
			public void setRequestIdValue(String requestIdValue) {
				this.requestIdValue = requestIdValue;
			}
			public Request()
			{}
}
