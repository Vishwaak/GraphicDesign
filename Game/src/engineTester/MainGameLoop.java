package engineTester;

import org.lwjgl.opengl.Display;

import render.DisplayManager;
import render.Loader;
import render.RawModel;
import render.Render;
public class MainGameLoop {
	public static void main(String[] args) {
		
	DisplayManager.createDisplay();
	Loader loader = new Loader();
	Render render = new Render();
	float[] vertices = {
			//left bottom triangle
			-0.5f,0.5f,0f,
			-0.5f,-0.5f,0f,
			0.5f,-0.5f,0f,
			//right tringale
			0.5f,-0.5f,0f,
			0.5f,0.5f,0f,
			-0.5f,0.5f,0f
			
	};
	
	RawModel model = loader.loadToVAO(vertices);
	
	
	
	while(!Display.isCloseRequested())
	{
		render.prepare();
		render.render(model);
		DisplayManager.updateDisplay();
	}
	loader.cleanUp();
	DisplayManager.closeDisplay();
 }
}
