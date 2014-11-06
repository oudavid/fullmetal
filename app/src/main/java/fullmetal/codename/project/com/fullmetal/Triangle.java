package fullmetal.codename.project.com.fullmetal;

import android.opengl.GLES20;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.FloatBuffer;

import static fullmetal.codename.project.com.fullmetal.MyRenderer.loadShader;

/**
 * Created by dcook on 11/5/14.
 */
public class Triangle {

    private final String vertexShaderCode=
            "attribute vec4 vPosition;"+
                    "void main() {"+
                    " gl_Position = vPosition;"+
                    "}";

    private final String fragmentShaderCode=
            "precision mediump float;" +
                    "uniform vec4 vColor;"+
                    "void main() {"+
                    " gl_FragColor = vColor;"+
                    "}";

    //private final int mProgram;
    int vertexShader = loadShader(GLES20.GL_VERTEX_SHADER, vertexShaderCode);
    int fragmentShader = loadShader(GLES20.GL_FRAGMENT_SHADER, fragmentShaderCode);

   // mProgram = GLES20.glCreateProgram();
    private FloatBuffer vertexBuffer;

    static final int COORDS_PER_VERTEX = 3;

    static float triangleCoords[]= {
            0.0f,  0.7f, 0.0f,
           -0.5f, -0.3f, 0.0f,
            0.5f, -0.3f, 0.0f
    };

    float color[]={1.0f,1.0f,0.0f};

    public Triangle(){

        ByteBuffer bb = ByteBuffer.allocateDirect(
                triangleCoords.length *4);

        bb.order(ByteOrder.nativeOrder());

        vertexBuffer = bb.asFloatBuffer();

        vertexBuffer.put(triangleCoords);

        vertexBuffer.position(0);
    }
}
