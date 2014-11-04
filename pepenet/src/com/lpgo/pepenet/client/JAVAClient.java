package com.lpgo.pepenet.client;


/**
 * Main Desktop/Android/HTML5 class
 * 
 * @author JOSE LUIS CEBRIAN MARQUEZ
 *
 */

// TBE: The Big Explanation of: Pepe's Networking Stuff.
//
// First, understand that as far as the networking stuff goes, the whole Kit 'N' Kaboodle starts right HERE, in this class.
// JAVAClient creates a ClientMSG, which creates a WSClient (WebSocketClient), which in turn is based on the ComClient interface.
// Implementing this sorry mess is done by calling the JAVAClient constructor during the creation of the game, and passing
// the JAVAClient along to successive screens the same way the Game class is passed. From the moment Pepe's code is added to
// a LibGDX game in this fashion, the JAVAClient object and the Game object should be considered Siamese twins, ie. joined at
// the hip. This is why JAVAClient is created in the Game class.
//
// Further, usage of this setup means that when you need to send a message to the server, you do so like this:
//
// 		<Insert either "this" or the Game object name here>.<Insert JAVAClient object name here>.clientMSG.sendMessage
// 		(
//			"Put your unbelievably important message here or substitute a String variable for this String literal."
//		);
// And for the love of God, DO NOT FORGET TO PREFIX AND PARSE that message properly, including the message category!!!
//
// And when you get a message from the server, it should be classified in one or another of the server message categories,
// and thus handled in the switch statement in ClientMSG.onMessage (  ), which should either use the command itself as part
// of the networking stuff, like IP lookups, or else call the appropriately variant method in THIS class ( JAVAClient ),
// and from here, hand it off through the Game object reference to a class specifically built to serve the basic function
// of a traffic cop, directing traffic through a massive collection of switches. Yes, it's not pretty, but until someone
// with a better idea comes along, this is what we have to work with. As far as I am concerned, this whole mess is one big
// UGLYHACK:, but one with no currently available solutions, and thus, an exception to the rule that we don't ship
// UGLYHACK:s. Another exception is the fact that we still can't seem to get the appropriate Gradle setup working right.

public class JAVAClient // implements ApplicationListener
{
	public ClientMSG clientMSG;
	public int myID;
	public static enum platformCode { DESKTOP, ANDROID, HTML5 };
	public String ip;
	public int port;
	
	public JAVAClient( platformCode pc, String ip, int port )
	{
		super (  );
		this.ip = ip;
		this.port = port;
		
		//Here we must create the client connection to the server
//		clientMSG = new ClientMSG ( "127.0.0.1", 5080, this, pc ); //Change here the IP and Port for your Server IP and Port
		clientMSG = new ClientMSG ( ip, port, this, pc );
		myID = clientMSG.getId (  );
//		System.out.println ( "My RETRIEVED client ID is: " + myID );
	}

	public void getMessage ( String message )
	{
//		System.out.println ( "\n\n\n Now in client.getMessage." );
//		game.messages.add ( values );
	}
	
	public void dispose (  )
	{
		clientMSG.close (  );
	}
//region NecTrash
//	@Override
//	public void create (  )
//	{
//		
//	}
//
//	@Override
//	public void resize ( int width, int height )
//	{
//		
//	}
//
//	@Override
//	public void render (  )
//	{
//		
//	}
//
//	@Override
//	public void pause (  )
//	{
//		
//	}
//
//	@Override
//	public void resume (  )
//	{
//		
//	}
//
//	@Override
//	public void dispose (  )
//	{
//		
//	}
//endregion NecTrash
}
//region NecTrash
//==============================SNIP==============================================================
//{
//	private OrthographicCamera camera;
//	private SpriteBatch batch;
//	private Texture texture;
//	private Sprite sprite;
//	
//	static final int spWidth = 128;
//	static final int spHeight = 256;
//	private int x_card = 0, y_card = 0; //Used to send the coordinates of card position
//	private int last_x = 0, last_y = 0; //Used to store the last sent coordinates
//	Vector3 touch = new Vector3(); 
//	
//	ClientMSG clientMSG;
//	int myID;
//	public static enum platformCode {DESKTOP, ANDROID, HTML5};
//	
//	public JAVAClient(platformCode pC)
//	{
//		super();
//		
//		//Here we must create the client connection to the server
//		clientMSG = new ClientMSG("127.0.0.1", 8080, this, pC); //Change here the IP and Port for your Server IP and Port
//		myID = clientMSG.getId();
//	}
//	
//	
//	@Override
//	public void create() {		
//		float w = Gdx.graphics.getWidth();	//Save the Width and Height to use it after
//		float h = Gdx.graphics.getHeight();
//		
//		camera = new OrthographicCamera(w, h); //Create the camera and put his position on the real 0,0
//		camera.position.x = w/2;
//		camera.position.y = h/2;
//		camera.update(); //Is necessary to update the camera when you change his position!
//		
//		batch = new SpriteBatch(); 
//		
//		//LETS CREATE THE IMAGE THAT YOU CAN MOVE OVER THE SCREEN
//		texture = new Texture(Gdx.files.internal("data/cartajoker.png"));
//		
//		TextureRegion region = new TextureRegion(texture, 0, 0, spWidth, spHeight); //must have the same size of the image size
//		sprite = new Sprite(region);
//		sprite.setOrigin(0, 0);
//		sprite.setPosition(0, 0);
//
//	}
//
//	/**
//	 * Dispose method close the WebSocket and dispose all the graphic resources
//	 */
//	@Override
//	public void dispose() {
//		batch.dispose();
//		texture.dispose();
//		clientMSG.close();
//	}
//
//	@Override
//	public void render() {		
//		Gdx.gl.glClearColor(1, 0, 0, 1); //background color
//		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
//		
//		batch.setProjectionMatrix(camera.combined);
//		batch.begin();
//		sprite.draw(batch);
//		batch.end();
//
//		
//		if (Gdx.input.isTouched()) //The screen is touched or is clicked for the mouse
//		{
//			//We need to catch the input, translate his values to the X, Y system of the camera and move the main image
//			touch.set(Gdx.input.getX(), Gdx.input.getY(), 0);
//			camera.unproject(touch);
//			//The center of the card in the touch point
//			x_card = (int)touch.x;
//			y_card = (int)touch.y;
//								
//			if ((Math.abs(last_x - touch.x) >= 3) || (Math.abs(last_y - touch.y) >= 3))	//To avoid send packets with the same value
//			{
//				clientMSG.sendMessage("POSITION "+clientMSG.getId()+" "+(int)touch.x+" "+(int)touch.y);
//				last_x = (int)touch.x;
//				last_y = (int)touch.y;
//			}
//		}
//		
//		sprite.setPosition(x_card - (spWidth/2), y_card - (spHeight/2)); //The center of the card in the touch point
//
//		camera.update(); 
//	}
//
//	@Override
//	public void resize(int width, int height) {
//	}
//
//	@Override
//	public void pause() {
//	}
//
//	@Override
//	public void resume() {
//	}
//	
//	/*
//	* Method called by the ClientMSG (bidirectional) when server moves the card
//	*/
//	public void changePosition(int PlayerId, int x, int y)
//	{
//		x_card = x;
//		y_card = y;
//	}
//}
//endregion NecTrash

//region NecTrash
//endregion NecTrash
