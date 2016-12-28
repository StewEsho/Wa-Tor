package com.stewesho.wator.desktop;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;
import com.stewesho.wator.Main;

public class DesktopLauncher {
	public static void main (String[] arg) {
		LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();
		config.title = "Wa-Tor Simulation | Stew Esho";
		config.width = 800;
        config.height = 800;
		config.resizable = false;
		config.forceExit = true;
		new LwjglApplication(new Main(), config);
	}
}
