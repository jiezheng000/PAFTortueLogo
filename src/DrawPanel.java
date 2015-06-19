import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Transparency;
import java.awt.image.BufferedImage;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

class DrawPanel extends JPanel {
	
    private Graphics2D g2d;
    private int width=1000;
    private int height=700;
    private BufferedImage bimg=new BufferedImage(width,height, BufferedImage.TYPE_INT_RGB);
    
    
    public DrawPanel(){
    	g2d=bimg.createGraphics();

    	bimg = g2d.getDeviceConfiguration().createCompatibleImage(width, height, Transparency.TRANSLUCENT);
    	g2d.dispose();
    	g2d = bimg.createGraphics();
    }
    
    public void paint(Graphics g) {
        
        super.paint(g);
        g.drawImage(new ImageIcon("White-background-for-site111.jpg").getImage(),0 , 0, null);
        g.drawImage(bimg, 0, 0, this);
    }
    
    public void clear(){
    	g2d.clearRect(0, 0, width, height);
    	repaint();
    	g2d=bimg.createGraphics();

    	bimg = g2d.getDeviceConfiguration().createCompatibleImage(width, height, Transparency.TRANSLUCENT);
    	g2d.dispose();
    	g2d = bimg.createGraphics();
    	
    }

    public void drawLine(int x1, int y1, int x2, int y2){
    	g2d.setColor(Color.BLUE);
    	g2d.drawLine(x1, y1, x2, y2);
    	repaint();
    }
}

