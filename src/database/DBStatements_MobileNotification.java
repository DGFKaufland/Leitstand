/*
 * Datei erstellt am 09.12.2014 von Frank Bayer.
 *
 *
 */

package database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import org.apache.log4j.Logger;

import models.MobileNotification;

/**
 * Diese Klasse enthaelt alle Datenbankabfragen.
 *
 * @author Fabian Heuberger
 * @version 1.0
 */
public class DBStatements_MobileNotification extends DBVerbindung
{
	private static Logger log = Logger.getLogger( DBStatements_MobileNotification.class.getName() );
	
    /**
     * Parameterloser Konstruktor der Klasse.
     */
    public DBStatements_MobileNotification()
    {
        createConnectionFactory( null );
    }

    /**
     * Konstruktor der Klasse DBSatements.
     * 
     * @param config
     *            Konfiguration fuer die ConnectionFactory.
     */
    public DBStatements_MobileNotification( final String config )
    {
        createConnectionFactory( config );
    }

    /**
     * Update der Daten in die Tabelle MobileNotification
     */     
    public final void updateMobileNotificationSetSnoozeTimeAndMessage ( final MobileNotification mn )
    {
        Connection con = null;
        PreparedStatement stmt = null;
        String query = "UPDATE MobileNotification SET snooze_time = ?, message = ? WHERE id = ?";

        try
        {
            con = getCf().createConnection();
            stmt = con.prepareStatement( query );
            
            stmt.setInt( 1, mn.getSnooze_time());
            stmt.setString( 2, mn.getMessage());
            
            stmt.setInt(3, mn.getID());
                      
            stmt.execute();
        }
        catch ( SQLException e )
        {
        	log.error( "Fehler beim Updaten von MobileNotification Snooze in die Datenbank!", e );
            e.printStackTrace();
        }
        finally
        {
            close( con, stmt, null );
        }
    }   
    
    
    public final void updateMobileNotificationSetSolved ( final MobileNotification mn )
    {
        Connection con = null;
        PreparedStatement stmt = null;
        String query = "UPDATE MobileNotification SET state = ?, snooze_time = ?, message = ? WHERE id = ?";

        try
        {
            con = getCf().createConnection();
            stmt = con.prepareStatement( query );
            
            stmt.setInt( 1, mn.getState());
            stmt.setInt( 2, mn.getSnooze_time());
            stmt.setString( 3, mn.getMessage());
            
            stmt.setInt(4, mn.getID());
                      
            stmt.execute();
        }
        catch ( SQLException e )
        {
        	log.error( "Fehler beim Updaten von MobileNotification Solved in die Datenbank!", e );
            e.printStackTrace();
        }
        finally
        {
            close( con, stmt, null );
        }
    }   
    
    
    
}
