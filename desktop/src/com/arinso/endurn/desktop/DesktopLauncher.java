package com.arinso.endurn.desktop;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;
import com.arinso.endurn.GameClass;
public class DesktopLauncher {

	public static void main (final String[] arg) {
		final LwjglApplicationConfiguration cfg = new LwjglApplicationConfiguration();
		cfg.width = 405;
		cfg.height = 720;
		cfg.title = "Endurn";
		cfg.samples = 2;
		cfg.resizable = false;
		new LwjglApplication(new GameClass(null), cfg);
	}
}
