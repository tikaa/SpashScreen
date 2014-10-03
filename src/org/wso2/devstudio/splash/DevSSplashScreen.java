/*
 * Copyright (c) 2014, WSO2 Inc. (http://www.wso2.org) All Rights Reserved.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.wso2.devstudio.splash;

import javax.swing.UIManager;
import javax.swing.ImageIcon;
import javax.swing.UnsupportedLookAndFeelException;

public class DevSSplashScreen {

	SplashDevScreen screen;

	public DevSSplashScreen() {
		// initialize the splash screen
		splashScreenInit();
		// do something here to simulate the program doing something that
		// is time consuming
		for (int i = 0; i <= 1000; i++) {
			for (long j = 0; j < 50000; ++j) {
				String poop = " " + (j + i);
			}
			// run either of these two -- not both
			screen.setProgress("Loading Dev Studio" + i, i); // progress bar with a message
		}
		splashScreenDestruct();
		// System.exit(0);
	}

	private void splashScreenDestruct() {
		screen.setScreenVisible(false);
	}

	private void splashScreenInit() {
		ImageIcon splashImage = new ImageIcon(this.getClass().getResource(
				"splashscreen.jpg"));
		screen = new SplashDevScreen(splashImage);
		screen.setLocationRelativeTo(null);
		screen.setProgressMax(1000);
		screen.setScreenVisible(true);
	}

	public static void StartUp() {
		try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		} catch (ClassNotFoundException e) {
			System.out.println(e);
		} catch (InstantiationException e) {
			System.out.println(e);
		} catch (IllegalAccessException e) {
			System.out.println(e);
		} catch (UnsupportedLookAndFeelException e) {
			System.out.println(e);
		}
		new DevSSplashScreen();
	}

}