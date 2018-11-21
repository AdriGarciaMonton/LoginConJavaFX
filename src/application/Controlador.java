package application;

import javafx.animation.FadeTransition;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.util.Duration;

public class Controlador {
	
	@FXML
	private AnchorPane pane1;
	@FXML
	private AnchorPane pane2;
	@FXML
	private AnchorPane pane3;
	@FXML
	private AnchorPane pane4;

	@FXML
	public void cerrar() {
		System.exit(0);
	}
	
	public void initialize() {
		pane1.setStyle("-fx-background-image: url('application/1.jpg')");
		pane2.setStyle("-fx-background-image: url('application/2.jpg')");
		pane3.setStyle("-fx-background-image: url('application/3.jpg')");
		pane4.setStyle("-fx-background-image: url('application/4.jpg')");

		backgroundAnimation();
	}
	
	private void backgroundAnimation() {
		
		FadeTransition fadeTransition = new FadeTransition(Duration.seconds(5), pane4);
		fadeTransition.setFromValue(1);
		fadeTransition.setToValue(0);
		fadeTransition.play();
		
		fadeTransition
		.setOnFinished(event -> {

			FadeTransition fadeTransition1 = new FadeTransition(
					Duration.seconds(3), pane3);
			fadeTransition1.setFromValue(1);
			fadeTransition1.setToValue(0);
			fadeTransition1.play();

			fadeTransition1.setOnFinished(event1 -> {
				FadeTransition fadeTransition2 = new FadeTransition(
						Duration.seconds(3), pane2);
				fadeTransition2.setFromValue(1);
				fadeTransition2.setToValue(0);
				fadeTransition2.play();

				fadeTransition2.setOnFinished(event2 -> {

					FadeTransition fadeTransition0 = new FadeTransition(
							Duration.seconds(3), pane2);
					fadeTransition0.setFromValue(0);
					fadeTransition0.setToValue(1);
					fadeTransition0.play();

					fadeTransition0.setOnFinished(event3 -> {

						FadeTransition fadeTransition11 = new FadeTransition(
								Duration.seconds(3), pane3);

						fadeTransition11.setFromValue(0);
						fadeTransition11.setToValue(1);
						fadeTransition11.play();

						fadeTransition11.setOnFinished(event4 -> {

							FadeTransition fadeTransition22 = new FadeTransition(
									Duration.seconds(3), pane4);

							fadeTransition22.setFromValue(0);
							fadeTransition22.setToValue(1);
							fadeTransition22.play();

							fadeTransition22.setOnFinished(event5 -> {

								backgroundAnimation();
							});

						});

					});

				});
			});

		});
	}

	@FXML
	public void mostrarVentanaSecundaria() {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("RegistrarseEjer1.fxml"));
            AnchorPane ventanaDos = (AnchorPane) loader.load();
            Stage ventana = new Stage();
            ventana.setTitle("Registro");
            Scene scene = new Scene(ventanaDos);
            ventana.setScene(scene);
            ventana.show();
 
        } catch (Exception e) {
            //tratar la excepción
        }
    }
}
