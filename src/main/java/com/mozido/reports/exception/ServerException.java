package com.mozido.reports.exception;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class ServerException extends Exception implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	private List<ValidationMessage> messages;
    private List<ErrorData> platformErrors;

    public ServerException() {
    }
    
    public ServerException(String... messages) {
    	List<ValidationMessage> messagesList = new ArrayList<ValidationMessage>();
		for(String message : messages){
			ValidationMessage vm = new ValidationMessage();
			vm.setMessage(message);
			messagesList.add(vm);
		}
		setMessages(messagesList);
    }

    public List<ValidationMessage> getMessages() {
        return messages;
    }

    public void setMessages(List<ValidationMessage> messages) {
        this.messages = messages;
    }

    public List<ErrorData> getPlatformErrors() {
        return platformErrors;
    }

    public void setPlatformErrors(List<ErrorData> platformErrors) {
        this.platformErrors = platformErrors;
    }
}
