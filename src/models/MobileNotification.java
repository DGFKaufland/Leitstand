package models;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlRootElement;

/**
 * @author Fabian Heuberger
 * @version 1.0
 *
 */
@XmlRootElement
public class MobileNotification implements Serializable
{
    private static final long serialVersionUID = 1L;
    
    private int ID;
    private String body;
    private int fromContactId;
    private int state;
    private int snooze_time;
    private String message;
    private int toContactId;
    

    /**
     * Leerer Konstruktor der Klasse Sensoren.
     */
    public MobileNotification()
    {
    }


    public MobileNotification(final Integer ID, final String body, final Integer fromContactID, 
    		final Integer state, final Integer snooze_time, final String message, final Integer toContactID )
    {
        this.setID(ID);
        this.setBody(body);
        this.setFromContactId(fromContactID);
        this.setState(state);
        this.setSnooze_time(snooze_time);
        this.setMessage(message);
        this.setToContactId(toContactId);
        
    }


	public int getID() {
		return ID;
	}


	public void setID(int iD) {
		ID = iD;
	}


	public String getBody() {
		return body;
	}


	public void setBody(String body) {
		this.body = body;
	}


	public int getFromContactId() {
		return fromContactId;
	}


	public void setFromContactId(int fromContactId) {
		this.fromContactId = fromContactId;
	}


	public int getState() {
		return state;
	}


	public void setState(int state) {
		this.state = state;
	}


	public String getMessage() {
		return message;
	}


	public void setMessage(String message) {
		this.message = message;
	}


	public int getSnooze_time() {
		return snooze_time;
	}


	public void setSnooze_time(int snooze_time) {
		this.snooze_time = snooze_time;
	}


	public int getToContactId() {
		return toContactId;
	}


	public void setToContactId(int toContactId) {
		this.toContactId = toContactId;
	}



}
