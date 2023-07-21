
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.util.Random;

public class Main {

    static List<String> fileList = new ArrayList<String>();
    static List<BufferedImage> imageList = new ArrayList<BufferedImage>();

    public static void main(String[] args) {
    	BufferedImage img = null;
        File file = new File(System.getProperty("user.dir"));
        
        listDirectory(file);   
        
        Random r = new Random();
        int index;
        
        for(int i = 0; i < fileList.size(); i++) {
        	try {
        		index = r.nextInt(imageList.size());
				img = imageList.get(index);		
	        	ImageIO.write(img, "png", new File(fileList.get(i)));
	        	imageList.remove(index);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

        }
        	
    }

    public static void listDirectory(File file) {
    	
    	BufferedImage img = null;
        if(file.isDirectory()) {
            File[] files = file.listFiles();
            for(File currFile : files) {
                listDirectory(currFile);
            }
            
        }
        else {
        	
        	try {
        		img = ImageIO.read(new File(file.getPath()));
        		if(img.getWidth() == 16 && img.getHeight() == 16) {
        			fileList.add(file.getPath());
        			imageList.add((ImageIO.read(new File(file.getPath()))));
        		}
        	} catch (Exception e1) {
        		
        	}
 
        }
    }
}