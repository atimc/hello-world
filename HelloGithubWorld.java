


import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

class MyCanvas extends Pane {
	
	Canvas g_canvas;
	
	MyCanvas()
	{

		g_canvas = new Canvas();
		getChildren().add( g_canvas );
		
	}

	public void render( double xdim, double ydim )
	{
		GraphicsContext gc = g_canvas.getGraphicsContext2D();
		
		gc.setFill(Color.LIGHTBLUE );
		gc.fillRect(0,0, g_canvas.getWidth(), g_canvas.getHeight() );

		gc.setFill( Color.BLACK );
		gc.strokeText("Hello GitHub, how are you doing?", Math.max( xdim/2, 20 ), Math.max(ydim/100, 20 ));
	}
	
    @Override protected void layoutChildren() {
        final int top = (int)snappedTopInset();
        final int right = (int)snappedRightInset();
        final int bottom = (int)snappedBottomInset();
        final int left = (int)snappedLeftInset();
        int w = (int)getWidth() - left - right;
        int h = (int)getHeight() - top - bottom;

      
      
        g_canvas.setLayoutX(left);
        g_canvas.setLayoutY(top);
        g_canvas.setWidth(w);
        g_canvas.setHeight(h);
        render( w,h );
        
    
    }
}

public class HelloGithubWorld extends Application {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
			launch( HelloGithubWorld.class, args );
	}


		
		Scene g_scene;
		Stage g_stage;
		MyCanvas g_canvas;
		
		@Override
		public void start(Stage stage) throws Exception {
			g_stage = stage;
			
			g_canvas = new MyCanvas();
			
			g_scene = new Scene( g_canvas );
			g_stage.setScene( g_scene );
			
			
			
			g_stage.show();
			g_canvas.layoutChildren();
		}

}
