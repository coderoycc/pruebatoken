package com.example.clases;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.FloatBuffer;

import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.opengles.GL10;

import android.opengl.GLSurfaceView.Renderer;
import android.opengl.GLU;

public class Renderizar implements Renderer {
	float vertices[] = {
			-0.6f, -0.4f,
			-0.3f,  0.3f,
			 0.0f, -0.4f,
			 0.3f,  0.3f,
			 0.6f, -0.4f
	};
	
	float colores[] = {
			1, 0, 0, 1,
			0, 0, 1, 1,
			1, 0, 0, 1,
			1, 0, 0, 1,
			1, 0, 0, 1
	};
		
	FloatBuffer bufVertices;
	FloatBuffer bufColores;
	
	@Override
	public void onSurfaceCreated(GL10 gl, EGLConfig arg1){
		ByteBuffer bufByte = ByteBuffer.allocateDirect(vertices.length * 4);
		bufByte.order(ByteOrder.nativeOrder());
		bufVertices = bufByte.asFloatBuffer();
		bufVertices.put(vertices).rewind();
		
		bufByte = ByteBuffer.allocateDirect(colores.length *4);
		bufByte.order(ByteOrder.nativeOrder());
		bufColores = bufByte.asFloatBuffer();
		bufColores.put(colores).rewind();

		gl.glClearColor(0, 128/255.0f, 1, 1 );
		
	}
	
	@Override
	public void onDrawFrame(GL10 gl) {
		/* Inicializa el buffer de color */
		gl.glClear(GL10.GL_COLOR_BUFFER_BIT);
		
		gl.glEnableClientState(GL10.GL_VERTEX_ARRAY);
		gl.glVertexPointer(2, GL10.GL_FLOAT, 0, bufVertices);
		
		gl.glEnableClientState(GL10.GL_COLOR_ARRAY);
		gl.glColorPointer(4, GL10.GL_FLOAT, 0, bufColores);
		
		//dibujamos
		gl.glDrawArrays(GL10.GL_TRIANGLE_STRIP, 0, 5); //5 vertices
		
		//cerramos color y pincel
		gl.glDisableClientState(GL10.GL_VERTEX_ARRAY);
		gl.glDisableClientState(GL10.GL_COLOR_ARRAY);
	}
	
	
	@Override
	public void onSurfaceChanged(GL10 gl, int width, int height) {
	/* Ventana de despliegue */
		gl.glViewport(0, 0, width, height);
		/* Matriz de Proyección */
		gl.glMatrixMode(GL10.GL_PROJECTION);
		/* Inicializa la Matriz de Proyección */
		//gl.glLoadIdentity();
		/* Proyección paralela */
		//GLU.gluOrtho2D(gl, -4, 4, -6, 6);
		/* Matriz del Modelo-Vista */
		//gl.glMatrixMode(GL10.GL_MODELVIEW);
		/* Inicializa la Matriz del Modelo-Vista */
		//gl.glLoadIdentity();
	}
	
	
	
	
}
