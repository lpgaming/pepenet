package com.lpgo.pepenet.CustomMessageEvents;

import java.util.EventListener;

public interface PepenetMessageEventListener extends EventListener
{
	public void handleEvent ( PepenetMessageEvent event ); // Called when a new message is received
}
