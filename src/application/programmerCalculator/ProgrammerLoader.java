package application.programmerCalculator;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

public class ProgrammerLoader extends Application {
	// private static final String IMAGE_LOC="/application/resources/CALC.png";

	
	@Override
	public void start(Stage primaryStage) throws Exception {
			Parent root  = FXMLLoader.load(getClass().getResource("/application/programmerCalculator/Programmer.fxml"));
			Scene scene = new Scene(root);
		//	scene.getStylesheets().add(getClass().getResource("application/resources/application.css").toExternalForm());
			primaryStage.setScene(scene);
			primaryStage.setTitle("Calculator");
			//primaryStage.getIcons().add(new Image(IMAGE_LOC));
//			primaryStage.minWidthProperty().bind(scene.heightProperty().multiply(2));
//		    primaryStage.minHeightProperty().bind(scene.widthProperty().divide(2));
			//primaryStage.sizeToScene();
			primaryStage.show();
			
	
		
	}		
		
	public static void main(String[] args) {
		launch(args);
	}
}
