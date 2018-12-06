package application;
	
import java.io.IOException;

import javafx.application.Application;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.effect.GaussianBlur;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;


public class Main extends Application {
	
	
	private AnchorPane mypane;

	// modifica el metodo start de la clase principal
	@Override
	public void start(Stage stage) throws IOException {

		// primero cargamos la vista fxml en el FXMLLoader
		FXMLLoader loader = new FXMLLoader(getClass().getResource(
				"../application/JavaFX.fxml"));

		// y opcionalmente un controlador para inicializar algún componente
		loader.setController(new SetBlur());

		// ahora sobre el panel mypane cargamos la vista que dejamos en el
		// FXMLLoader
		mypane = (AnchorPane) loader.load();
		
		// añade la escena al stage y la titula
		stage.setTitle("Where's the squirrel?");
		stage.setScene(new Scene(mypane));
		stage.show();
	}

	// la clase controladora que añade un efecto a la imagen
	class SetBlur {

		// la etiqueta FXML permite acceder al componente imageView ya creado en
		// fxml
		
		@FXML
		private ImageView view;

		@FXML
		public void initialize() {
			view.setEffect(new GaussianBlur(20));
		}

	}

	// arranca la aplicación
	public static void main(String[] args) {
		launch(args);
	}
}
