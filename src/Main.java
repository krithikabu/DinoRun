/*
 * STUDENT NAME goes here
 */
/*
 * Lesson Objectives:
 *    - Learn a Framework through inspection and breakpoints
 *    - Lambda expressions and event handlers
 *    - Click Event via MouseListener interface & MouseAdapter class
 *      and using an inline anonymous class.
 *    - Intro to Multi-threading
 *    - Abstract class and methods (volatile keyword)
 *    - Menu system (JMenuBar, JMenu, JMenuItem, accelerator keys)
 *    - Drawing using Swing GUI API
 *    - Images, RGB, drawImage to screen Graphics
 *         BufferedImage drawing
 *    - paintComponent() override
 *    - Good use of constants
 *    - Fill Algo using Stack (iterative version of recursive algo)
 */

import java.awt.event.InputEvent;
import javax.swing.*;


class Main extends JFrame  {
	// To eliminate a warning shown in Eclipse, add this constant
	private static final long serialVersionUID = 1L;

	// This is declared volatile so that loops that use
	// it are not optimized strangely. We need to access this
	// variable from different threads, meaning that it can
	// change at any second!! It is volatile.
	private static volatile boolean done = false;
	
	public static final int WIDTH = 800;
	public static final int HEIGHT = 800;

    // Question: What's the benefit of these constants?
    // A: 
	private static final int GAME_PANEL = 0;

    // Our application may have many animated panels
    // But only one panel will be currently visible at a time
	private AnimatedPanel[] panels;
	private int currentPanel = -1;
	
	// This is used to establish the animation speed
	public static int delay = 100;
	
	public static void main(String[] args) throws InterruptedException {
		Main theGUI = new Main();
		
		// Starts the UI Thread and creates the the UI in that thread.
		// Uses a Lambda Expression to call the createFrame method.
		// Use theGUI as the semaphore object
		SwingUtilities.invokeLater( () -> theGUI.createFrame(theGUI) );

		// Have the main thread wait for the GUI Thread to be done
		// creating the frame and all panels.
		// Q: What happens if this wait is deleted? Why does that happen?
		// A: 
		synchronized (theGUI ) {
			theGUI.wait();
		}
		
		// Have the main thread continually trigger animations.
		// When an animation stops, trigger another one.
		// The method startAnimation is a synchronous call that will continually
		// repeat the following until animation is stopped:
		// 	    1) update panel (i.e. the animation)
		//      2) paint
		//      3) wait
		// The GUI thread will trigger the animation to stop.
		while (true) {
			System.out.println("Start Animation");
			theGUI.startAnimation();
			System.out.println("Animation stopped");
		}

        // Question: How does our application end when the above while-loop
        // has no exit? It loops while(true)!
        // A: 
	}
	
	/**
	 * Create the main JFrame and all animation JPanels.
	 * 
	 * @param semaphore The object to notify when complete
	 */
	public void createFrame(Object semaphore) {
        // NOTE : This method will be similar to the Calculator createFrame
        // method. Leverage that code to complete these TODOs.
        
		// TODO: Set the title found in the Title Bar of the JFrame
		
		// TODO: Set the size of the main Window (this JFrame) to WIDTH, HEIGHT
		
		// Allows the application to properly close when the
		// user clicks on the Red-X. It tells the all threads
        // to terminate. This will end the main thread.
        // TODO: call the method to Exit on Close.

        // The JFrame has a menu attached to it
		addMenuBar();

        // we will have 4 possible panels that we may display
		this.panels = new AnimatedPanel[1];
		this.setSize(WIDTH, HEIGHT);

        // Question: How is it that we can put all these different Panels into the
        // same array?
        // A:
		panels[GAME_PANEL] = new GamePanel();
		
		// All Panels need to have their bounds set correctly or else they
		// won't be sized correctly and won't be visible.
		for (AnimatedPanel panel : panels) {
			panel.setBounds(0, 0, Main.WIDTH, Main.HEIGHT);
			add(panel);
			panel.setVisible(false);
		}
		// Set the current panel and make it visible 
		this.currentPanel = GAME_PANEL;
		panels[currentPanel].setVisible(true);

		// Set this JFrame to be visible
		this.setVisible(true);

        System.out.println("All done creating our frame");
		// tell the main thread that we are done creating our dialogs.
        // This allows the main thread to stop wait()'ing.
		synchronized (semaphore) {
			semaphore.notify();
		}
	}
	
	/**
	 * This is run on the Main Thread.
	 * Like a drummer, it keeps the pace, telling the Panel when 
	 * to update itself--when to repaint.
	 */
	public void startAnimation() {
        // We set done to false and allow the UI thread to change the value
        // to true when menu options are selected.
		Main.done = false;
		try {			
			while (!Main.done) {
				panels[currentPanel].updateAnimation();
                // This informs the UI Thread to repaint this component
				repaint();
                // This causes our main thread to wait... to sleep... for a bit.
				Thread.sleep(Main.delay);
			}
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * Stops the animation of the current panel and shows the new panel.
	 * This is run on the GUI thread
	 * 
	 * @param index Should be one of Main.BALL_PANEL, BANNER_PANEL, etc.
	 */
	private void showPanel(int index) {
		System.out.printf("Show Panel. Thread is: %s\n", Thread.currentThread().getName());
		
		// stop the current animation
		Main.done = true;
		
		// hide the current panel
		panels[currentPanel].setVisible(false);
		
		// show the correct panel
		currentPanel = index;
		panels[currentPanel].setVisible(true);
		
		// The animation will start on the main thread.
		// Do nothing in the UI thread
	}
	
	/**
	 * Add some menu options to control the experience.
	 */
	private void addMenuBar() {
		
		JMenuBar bar = new JMenuBar();
		// Add the menu bar to the JFrame
		this.setJMenuBar(bar);
		
		JMenu menu = createAnimationMenu();
		bar.add(menu);
		
		// Add more top-level menu options for the specific animation panel
		menu = new JMenu("Game");
		menu.setMnemonic('B');
		JMenuItem item = new JMenuItem("Start", 'S');
		item.addActionListener(e -> ((GamePanel)panels[GAME_PANEL]).showMessage());
		menu.add(item);
        
	}
	
	/**
	 * Create the top-level menu that controls Animation
	 * 
	 * @return The JMenu object with all the JMenuItems in it.
	 */
	private JMenu createAnimationMenu() {
		// The Animation menu will display the specific animation
		// such as the ability to increase/decrease the animation speed.
		JMenu menu = new JMenu("Dinosaur Game");
		menu.setMnemonic('A');
		// Q: What is the second parameter in the JMenuItem constructor?
		// A:
		JMenuItem item = new JMenuItem("Easy Mode", 'E');
		// Q: What is the 'e -> showPanel(BALL_PANEL)?
		// Q: What is the 'e'?
		item.addActionListener(e -> showPanel(GAME_PANEL));
		menu.add(item);
		item = new JMenuItem("Medium Mode", 'M');
		// item.addActionListener( ... what goes here? ...)
		menu.add(item);
		item = new JMenuItem("Hard Mode", 'H');
		// item.addActionListener( ... what goes here? ...)
		item.addActionListener(e -> Main.delay = Math.min(500, Main.delay+10));
		// Q: What is an accelerator? How does it impact the user experience/functionality?
		// A:
		item.setAccelerator(KeyStroke.getKeyStroke('-', InputEvent.CTRL_DOWN_MASK));
		menu.add(item);
		item = new JMenuItem("Faster animation", 'F');
		item.addActionListener(e -> Main.delay = Math.max(10, Main.delay-10));
		item.setAccelerator(KeyStroke.getKeyStroke('=', InputEvent.CTRL_DOWN_MASK));
		menu.add(item);
		
		return menu;
	}
}
