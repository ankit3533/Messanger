package org.koushik.javabrains.messanger.service;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Map;

import org.eclipse.yasson.internal.serializer.CalendarTypeDeserializer;
import org.koushik.javabrains.messanger.database.DatabaseClass;
import org.koushik.javabrains.messanger.model.Message;

public class MessageService {
	
	Map<Long, Message> messages = DatabaseClass.getMessages();
	
	public MessageService(){
		messages.put(1L, new Message(1,"Hello","Ankit"));
		messages.put(2L, new Message(2,"Hello","Ankit"));
	}
	
	public List<Message> getAllMessages() {
		return new ArrayList<Message>(messages.values());

	}
	
	public List<Message> getAllMessagesForYear(int year) {
		List<Message> yearMessage = new ArrayList<Message>();
		Calendar cal = Calendar.getInstance();
		for(Message m:messages.values())
		{
			cal.setTime(m.getCreated());
			if(year==cal.get(Calendar.YEAR))
				yearMessage.add(m);
		}
		return yearMessage;

	}
	
	public List<Message> getAllMessagesPaginated(int start,int size) {
		List<Message> sortedMessage = new ArrayList<Message>(messages.values());
		if(start+size>sortedMessage.size()) return new ArrayList<Message>();
		return sortedMessage.subList(start, start+size);
	}
	

	public Message getMessage(long id) {
		return messages.get(id);

	}
	public Message addMessage(Message message) {
		message.setId(messages.size()+1);
		messages.put(message.getId(), message);
		return message;
	}
	public void deleteMessage(long id) {
		messages.remove(id);

	}
	public Message updateMessage(Message message) {
		if(message.getId()<=0)
			return null;
		messages.put(message.getId(),message);
		return message;

	}
	
}
