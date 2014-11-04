package com.lpgo.pepenet.server;

public class ServerMSG
{
	WSServer wsserver;
	JAVAServer server;
	//For Bidirectional Communication mode	
	public ServerMSG(int port, JAVAServer server, JAVAServer.platformCode pC)
	{
		wsserver = new WSServer(port, this, pC);
		this.server = server; //To call the methods of the the upper level class
	}
	
	//Please, read Message codes in the ClientMSG comments.
	public void onMessage(String message)
	{
		System.out.println ( "Receiving message from Client to Server: " + message );

		String [] values;
		values = message.split ( "\\*" );
		
//		if ( message.contains ( "+" ) || message.contains ( " " ) )
//		{
//			values = message.split ( "\\s+" ); //splitter with the " " separator
//		} else { values = message.split ( "\\*" ); } //splitter with the " " separator }
		
		//int ClientID = Integer.valueOf(values[0]); //Check of the ID (not required)			
		
		//Calls to the upper level class methods
		//TODO: Expand this switch to include any networking-related stuff like IP Lookups, etc.
//		if (values[0].equals("POSITION")) //POSITION player_id pos_x pos_y
//		{
//			//s.changePosition(Integer.valueOf(values[1]), Integer.valueOf(values[2]), Integer.valueOf(values[3]));
//		}
		server.getMessage ( values );
	}
	
	//Please, read Message codes in the ClientMSG comments.
	public boolean sendMessageToClient(int clientID, String message)
	{
		System.out.println ( "Sending message from Server to Client: " + message );
		return (wsserver.sendToClient(clientID, message));
	}
	
	public void sendMessageToAll(String message)
	{
		System.out.println ( "Sending message from Server to ALL CLIENTS: " + message );
		wsserver.sendToAll(message);
	}
	
	//one method for each messages / actions that the server can do
	
	public void close()
	{
		wsserver.stop();
	}
}
//region NecTrash
//endregion NecTrash