package bounce;

        //author Gremlin
        // Student no . 17418673

        import java.awt.*;
        import java.awt.event.*;
        import javax.swing.*;


        public class Bounce extends JFrame implements ActionListener, KeyListener  {
            
        GameCanvas 	g1;
        JMenuBar 	menuBar;
        JMenu 		menuFile, menuEdit;
        JMenuItem 	menuSave, menuExit, menuOpen, menuCut, menuCopy ,menuPaste; 
        JSlider 	slider;
        JButton 	playerButton2, playerButton4, multiButton, exitButton, 
			actButton, runButton, resetButton, ForwardButton, 
			BackwardsButton ,UpButton, DownButton;
        JPanel  	RightPanel, BottomPanel;  
        int t;
        int directionX ; 
        int directionY ; 
        
     
                

        public static void main(String[] args) {

            new Bounce();
        
        }

        
        public Bounce(){
        super("CBabyBallBounce – Baby Ball Bounce Application");
        setLayout(null);
        setSize(825 , 586);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        //right pannel 
        
        RightPanel  = new JPanel(); 
        RightPanel.setSize(200,386);
        RightPanel.setLocation(600, 50);
        //RightPanel.setLayout(null);
        add(RightPanel);
        RightPanel.setBackground(Color.yellow);
        
        ForwardButton = new JButton(">");
        ForwardButton.setSize(50, 20);
        ForwardButton.setLocation(150, 500);
        //setVisible(true);
        RightPanel.add(ForwardButton);
       
        BackwardsButton = new JButton("<");
        BackwardsButton.setSize(50, 20);
        BackwardsButton.setLocation(150, 400);
        RightPanel.add(BackwardsButton);
        
        UpButton = new JButton("^");
        UpButton.setSize(50, 20);
        UpButton.setLocation(200, 400);
        RightPanel.add(UpButton);
        
        DownButton = new JButton("v");
        DownButton.setSize(50, 20);
        DownButton.setLocation(150, 400);
        RightPanel.add(DownButton);

        //2 Player, 4 Player, Multi’ and ‘Exit’.
        playerButton2 = new JButton ("2 Player");
        playerButton2.setSize(100, 30);
        playerButton2.setLocation(100, 500);
        playerButton2.setVisible(true);
        RightPanel.add(playerButton2);

        playerButton4 = new JButton ("4 Player") ;
        playerButton4.setSize(100, 30);
        playerButton4.setLocation(100, 500);
        playerButton4.setVisible(true);
        RightPanel.add(playerButton4);

        multiButton = new JButton ("Multi") ;
        multiButton.setSize(150, 30);
        multiButton.setLocation(100, 500);
        multiButton.setVisible(true);
        RightPanel.add(multiButton);

        exitButton = new JButton ("Exit") ;
        exitButton.setSize(150, 30);
        exitButton.setLocation(100, 500);
        exitButton.setVisible(true);
        RightPanel.add(exitButton);
        
       
        
        //end of right pannel elements.
        

        // Bottom pannel layout                     
        BottomPanel = new JPanel();
        BottomPanel.setSize(825,200);
        BottomPanel.setLocation(0,470);
        BottomPanel.setLayout(null);
        add(BottomPanel);
        //BottomPanel.setBackground(Color.red);

        //bottom panel buttons act, run, reset                   
        actButton = new JButton ("Act") ;
        actButton.setSize(75, 20);
        actButton.setLocation(100, 20);
        actButton.setVisible(true);
        actButton.setBackground(Color.white);
        BottomPanel.add(actButton);

        ImageIcon icon = new ImageIcon("images\\step.png");
        actButton.setIcon(icon);

        runButton = new JButton ("Run") ;
        runButton.setSize(75, 20);
        runButton.setLocation(185, 20);
        runButton.setVisible(true);
        runButton.setBackground(Color.white);
        BottomPanel.add(runButton);
        ImageIcon icon2 = new ImageIcon("images\\run.png");
        runButton.setIcon(icon2);

        resetButton = new JButton ("Reset") ;
        resetButton.setSize(90, 20);
        resetButton.setLocation(270, 20);
        resetButton.setVisible(true);
        resetButton.setBackground(Color.white);
        BottomPanel.add(resetButton);
        ImageIcon icon3 = new ImageIcon("images\\reset.png");
        resetButton.setIcon(icon3);
        
        
       // bottom pannel slider
       //http://www.dummies.com/programming/java/how-to-use-sliders-in-java/
		
        slider = new JSlider(0,50);
        slider.setMajorTickSpacing(10);
        slider.setPaintTicks(true);
        slider.setLocation(300,10);
	//slider.setVisible(true);
        BottomPanel.add(slider);
        
        
        g1 = new GameCanvas();
        g1.Xlocation = 100;
        g1.Ylocation = 100;
        add(g1);
        g1.setSize(600,470);
       
        addKeyListener(this);

        Timer t1 = new Timer(100,this);
        t1.start();
        
        menuBar = new JMenuBar();
        menuFile = new JMenu("File");
        menuSave = new JMenuItem("Save");
        menuOpen = new JMenuItem("Open");
        menuExit = new JMenuItem("Exit");
        menuEdit = new JMenu("Edit");
        menuCut = new JMenuItem("Cut");
        menuCopy = new JMenuItem("Copy");
        menuPaste = new JMenuItem("Paste");
        menuFile.add(menuSave);
        menuFile.add(menuOpen);
        menuFile.add(menuExit);
        menuEdit.add(menuCut);
        menuEdit.add(menuCopy);
        menuEdit.add(menuPaste);
        menuBar.add(menuFile);
        menuBar.add(menuEdit);
        setJMenuBar(menuBar);
        
        directionX = 10;
        directionY = 5;
        
        setResizable(false);
        setVisible(true);
      
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        
           g1.Ylocation+=directionY;
           g1.Xlocation+=directionX;

           if(g1.Xlocation >=g1.getWidth()-50 || g1.Xlocation <=0)
           {
               directionX=-directionX;
           }
           if(g1.Ylocation >=g1.getHeight()-50 || g1.Ylocation <=0)
           {
               directionY =- directionY;
           }

           g1.repaint();
           
           /*
          if (g1.XlocationB1 == g1.Xlocation){
           
               directionX =- directionX;
           }
           if (g1.YlocationB1 == g1.YlocationB1){
               
               directionY =- directionY;
           } 
        */
    }
     
  

    @Override
    public void keyTyped(KeyEvent ke) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

   

    @Override
    public void keyReleased(KeyEvent ke) {
        

    
    
    }

    @Override
    public void keyPressed(KeyEvent ke) {
        
        int key = ke.getKeyCode();

    if (key == KeyEvent.VK_LEFT) {
        g1.XlocationB1 += -5;
    }

    if (key == KeyEvent.VK_RIGHT) {
        g1.XlocationB1 += 5;
   
    }

  }
}
       
 
class GameCanvas extends JPanel {
    
        Image image;
        
        int Xlocation, Ylocation ,
            XlocationB1 = 100, YlocationB1=250,
            XlocationB2 = 200, YlocationB2=250,
            XlocationB3 = 300, YlocationB3 = 250,
            XlocationB4 = 400 , YlocationB4 = 250;
        Image imgball, imgbaby1, imgbaby2, imgbaby3, imgbaby4;
    
        
       
        
        public GameCanvas()
        {
            imgball = Toolkit.getDefaultToolkit().getImage("images\\ball.png");
            imgbaby1 = Toolkit.getDefaultToolkit().getImage("images\\baby1.png");
            imgbaby2 = Toolkit.getDefaultToolkit().getImage("images\\baby2.png");
            imgbaby3 = Toolkit.getDefaultToolkit().getImage("images\\baby1.png");
            imgbaby4 = Toolkit.getDefaultToolkit().getImage("images\\baby2.png");
            Xlocation = 200;
            Ylocation=300 ;
        }

        public void paint (Graphics g){
            
            
            g.clearRect(0,0,getWidth(),getHeight());
            g.drawImage(imgball, Xlocation, Ylocation, this);
            g.drawImage(imgbaby1, XlocationB1, YlocationB1, this);
            g.drawImage(imgbaby2, XlocationB2, YlocationB2, this);
            g.drawImage(imgbaby3, XlocationB3, YlocationB3, this);
            g.drawImage(imgbaby4, XlocationB4, YlocationB4, this);

            }

  }
    