package com.lpgo.pepenet.CustomMessageEvents;

import java.util.ArrayList;
import java.util.List;

public class MessageEventSource
{
	// region Variables
	private List<PepenetMessageEventListener> listeners = new ArrayList<PepenetMessageEventListener> (  );
	// endregion

	synchronized void addListener ( PepenetMessageEventListener listener )
	{
		listeners.add ( listener );
	}
	
	synchronized void removeListener ( PepenetMessageEventListener listener )
	{
		listeners.remove ( listener );
	}
	
	public void fireMessageReceived ( int clientID, String message )
	{
		if ( listeners != null && !listeners.isEmpty (  ) )
		{
			PepenetMessageEvent messageEvent = new PepenetMessageEvent ( this, clientID, message );
			
			synchronized ( listeners )
			{
				for ( PepenetMessageEventListener pmel : listeners )
				{
					pmel.handleEvent ( messageEvent );
				}
			}
		}
	}
	
	// region GettersNSetters

	// endregion
}
