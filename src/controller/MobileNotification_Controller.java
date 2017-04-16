/*
 * Datei erstellt am 16.12.2014 von Fabian Heuberger.
 *
 *
 */

package controller;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import models.MobileNotification;
import services.SMTP;

import org.apache.log4j.Logger;

import database.DBStatements_MobileNotification;

/**
 *
 * @author Fabian Heuberger
 * @version 1.0
 *
 */
@Path( "/MobileNotification" )
public class MobileNotification_Controller
{
	private static Logger log = Logger.getLogger( MobileNotification_Controller.class.getName() );

    private DBStatements_MobileNotification dbs_mn = new DBStatements_MobileNotification();

     
    @POST
    @Path( "/setSnoozeAndMessage" )
    @Consumes( {MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML } )
    @Produces( {MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML } )
    public void setSnoozeAndMessage (final MobileNotification mn)
    {

    	dbs_mn.updateMobileNotificationSetSnoozeTimeAndMessage(mn);
    	
    	log.debug( "updateMobileNotificationSetSnoozeTimeAndMessage war erfolgreich" );
    }
        
    @POST
    @Path( "/solveTask" )
    @Consumes( {MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML } )
    @Produces( {MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML } )
    public void solveTask (final MobileNotification mn)
    {

    	dbs_mn.updateMobileNotificationSetSolved(mn);
    	
    	log.debug( "updateMobileNotificationSetSolved war erfolgreich" );
    }
    
    
    @POST
    @Path( "/sendTestmail" )
    @Consumes( {MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML } )
    @Produces( {MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML } )
    public void sendTestMail( final MobileNotification mn )
    {
    	//System.out.println(mn.getID());
        SMTP.sendMail(mn);
    }
    
    @POST
    @Path( "/sendMail" )
    @Consumes( {MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML } )
    @Produces( {MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML } )
    public void sendMail( final MobileNotification mn )
    {	
        SMTP.sendMail(mn);
    }
    
    
   
}
