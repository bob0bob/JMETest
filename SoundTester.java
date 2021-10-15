package test;

import com.jme3.app.SimpleApplication;
import com.jme3.audio.AudioData;
import com.jme3.audio.AudioNode;
import com.jme3.input.KeyInput;
import com.jme3.input.controls.ActionListener;
import com.jme3.input.controls.KeyTrigger;
import com.jme3.system.AppSettings;
import com.landbeyond.engine.Window;

public class SoundTester extends SimpleApplication implements ActionListener
{

    public static AppSettings settings;

    
    public static void main(String[] args) {

    	settings = new AppSettings(true);
        settings.setFullscreen(false);
        settings.setVSync(true);
        settings.setUseJoysticks(false);
        settings.setRenderer(AppSettings.LWJGL_OPENGL33);
        settings.setResolution(672 * 2, 512 * 2);
        settings.setUseInput(true);

        SoundTester app = new SoundTester();
        app.showSettings = false;
        app.setSettings(settings);
        app.start();
    }

	private AudioNode errornode;
	private AudioNode keynode;

    @Override
    public void simpleInitApp() 
    {
		inputManager.addMapping("R", new KeyTrigger(KeyInput.KEY_R));
		inputManager.addMapping("1", new KeyTrigger(KeyInput.KEY_1));
		inputManager.addMapping("2", new KeyTrigger(KeyInput.KEY_2));
		inputManager.addListener(this, "R", "1", "2");

        
		
    	errornode = new AudioNode(assetManager,"Sounds/error.ogg",AudioData.DataType.Buffer);
    	errornode.setPositional(false);
    	keynode = new AudioNode(assetManager,"Sounds/keyclick.ogg",AudioData.DataType.Buffer);
    	keynode.setPositional(false);
		
        
        /*
         * Speed up camera motion for convenience.
         */
        flyCam.setMoveSpeed(8f);
        
    }

    @Override
    public void simpleUpdate(float timePerFrame) 
    {
    }
    

	@Override
	public void onAction(String name, boolean isPressed, float tpf)
	{
		if (isPressed)
		{
			if (name.equals("1"))
			{
				errornode.play();
			}
			else if (name.equals("2"))
			{
				keynode.play();;
			}
		}
		
	}
 
	
}