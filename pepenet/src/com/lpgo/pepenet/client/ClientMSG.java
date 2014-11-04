package com.lpgo.pepenet.client;

public class ClientMSG
{
	ComClient comclient;
	JAVAClient client;
	//For Bidirectional Communication mode
	public ClientMSG ( String ip, int port, JAVAClient client, JAVAClient.platformCode pc )
	{
		if ( pc == JAVAClient.platformCode.HTML5 )
		{
			//Only available on the HTML project - ClientMSG class
			comclient = new GWTClient(ip, port, this);
		}
		else
		{
			//Only available on the JAVA-ANDROID project
			comclient = new WSClient ( ip, port, this, pc );
		}
		this.client = client; //To call the methods of the the upper level class
	}


	public void onMessage ( String message )
	{
//		System.out.println ( "Receiving message to Client from Server: " + message );
		
//		String [] values;
//		if ( message.contains ( "+" ) || message.contains ( " " ) )
//		{
//			values = message.split ( "\\s+" ); //splitter with the " " separator
//			switch ( values[0] )
//			{
//				case "POSITION": break;
//				default: break;
//			}
//
//		}
//		else
//		{
//		values = message.split ( "\\*" ); //splitter with the " " separator }
			//int ClientID = Integer.valueOf(values[0]); //Check of the ID (not required)			
		
			//Calls to the upper level class methods
			//TODO: Expand this switch to include any networking-related stuff like IP Lookups, etc.
//			if ( values[0].equals ( "POSITION" ) ) //POSITION player_id pos_x pos_y
//			{
//				//c.changePosition(Integer.valueOf(values[1]), Integer.valueOf(values[2]), Integer.valueOf(values[3]));
//			}
//		System.out.println ( "\n\n\nAbout to go from clientMsg to client.getMessage." );
//		client.getMessage ( values );
//		}
		client.getMessage ( message );
	}

	public boolean sendMessage ( String message )
	{		
		if ( comclient != null && comclient.isConnected (  ) )
		{
			//Only send message
//			System.out.println ( "Sending message from Client to Server: " + message );
			return ( comclient.sendMsg ( message ) );
		}	
		else
		{
//			System.out.println ( "ComClient was NULL. Not sending this message: " + message );
			return false;
		}
	}
	
	public int getId (  )
	{
		return ( comclient.getId (  ) );
	}
	
	//get name from client class
	
	//one method for each messages / actions that the client can do
	
	public void close (  )
	{
		comclient.close (  );
	}
}
//region NecTrash
//endregion NecTrash