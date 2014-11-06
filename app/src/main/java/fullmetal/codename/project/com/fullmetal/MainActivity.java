package fullmetal.codename.project.com.fullmetal;

import android.app.Activity;
import android.content.Context;
import android.opengl.GLSurfaceView;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;


public class MainActivity extends Activity {

    private GLSurfaceView mSurfaceView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        mSurfaceView = new MyGLSurfaceView(this);

        setContentView(mSurfaceView);
    }


}

class MyGLSurfaceView extends GLSurfaceView{

    public MyGLSurfaceView(Context context){
        super(context);

        setRenderer(new MyRenderer());
        //setEGLContextClientVersion(2);
        setRenderMode(GLSurfaceView.RENDERMODE_WHEN_DIRTY);
    }
}
