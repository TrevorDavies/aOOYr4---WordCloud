package ie.gmit.sw;

import java.awt.Color;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics2D;

import java.awt.image.BufferedImage;
import java.io.File;

import java.util.Map;
import java.util.Map.Entry;
import java.util.Random;

import javax.imageio.ImageIO;

public class WordCloudGen {
	
	public WordCloudGen(Map<String,Integer> cloudMap) throws Exception
	{
		Paint(cloudMap);
	}

	public void Paint(Map<String,Integer> cloudMap)throws Exception
	{
		BufferedImage image = new BufferedImage(1200, 900, BufferedImage.TYPE_4BYTE_ABGR);
		Graphics2D  graphics = (Graphics2D) image.getGraphics();
		
		 int x = 750;
		 int y = 40;
		 int FontSize;
		 int angle = 0;
		 int yCordinates = 0;
		 int xCordinates = 750;
		 int fontSize = 40;
		 int count=0;
		 
		 for(Entry<String,Integer> ent: cloudMap.entrySet())
		 {
			 String sKey = ent.getKey();
			 Integer val = ent.getValue();
			
			    if(val > 10)
			    {
			    	if(fontSize == 5)
			    	{
			    		fontSize = 16;
			    	}
			    	
			    	FontSize = 25;
			    	
			    	
			    	
			    	Font font = new Font(fontType(), fontStyle(), fontSize--);
			    	
			    	FontMetrics metrics = graphics.getFontMetrics(font);
			    

			    	graphics.setColor(fontColor());
			    	graphics.setFont(font);
			    	
			    	
			    	drawRotate(graphics, x , y + metrics.getHeight(), angle, sKey);
			    	angle += 20;
			    	
			    
			    	if(angle > 21)
			    	{
			    		y += metrics.stringWidth(sKey)+metrics.getHeight();
			    		angle = 0;
			    		
			    	}
			    	else
			    	{
			    		x += metrics.stringWidth(sKey);
			    		
			    	}
		
			    	if(x > 750)
			    	{
			    		yCordinates = yCordinates+30;
			    		y = yCordinates;
			    		xCordinates = xCordinates - 75;
			    		x = xCordinates;
			    		
			    	}
			    	else if(y > 750)
			    	{
			    		yCordinates = yCordinates+30 ;
			    		y = yCordinates;
			    		xCordinates = xCordinates - 75;
			    		x = xCordinates;
			    	}
			    	
			    }//end if 
			 

		 }//end for
		 graphics.dispose();
		 
		 ImageIO.write(image, "png", new File("TestCloud.png"));
	}
	
	public static void drawRotate(Graphics2D Graph, double x, double y, int angle, String text) 
	{    
		Graph.translate((float)x,(float)y);
		Graph.rotate(Math.toRadians(angle));
		Graph.drawString(text,0,0);
		Graph.rotate(-Math.toRadians(angle));
		Graph.translate(-(float)x,-(float)y);
	} 
	
	public static String fontType(){
	Random random = new Random();
	//returns random font styles
	switch(random.nextInt(3))
	{
	case 0:
		return Font.SANS_SERIF;
		
	case 1:
		return Font.MONOSPACED;
		
	case 2:
		return Font.SERIF;
		
	default:
		return Font.SANS_SERIF;
	}
}
public static Color fontColor(){
	Random rand = new Random();
	switch(rand.nextInt(5))
	{
	case 0:
		return Color.BLUE;
		
	case 1:
		return Color.RED;
		
	case 2:
		return Color.GREEN;
	case 3:
		return Color.YELLOW;
	case 4:
		Random rnd = new Random();
		float r = rnd.nextFloat();
		float g = rnd.nextFloat();
		float b = rnd.nextFloat();
		
		return new Color(r, g, b);
		
	default:
		return Color.BLACK;
	}
	
	
	}
public static int fontStyle(){
	Random rand = new Random();
	switch(rand.nextInt(4))
	{
	case 0:
		return Font.BOLD;
		
	case 1:
		return Font.ITALIC;
		
	case 2:
		return Font.LAYOUT_RIGHT_TO_LEFT;
	case 3:
		return Font.LAYOUT_LEFT_TO_RIGHT;
		
	default:
		return Font.PLAIN;
	}
	
	
	}
}
