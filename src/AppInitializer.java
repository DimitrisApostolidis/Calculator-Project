import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.Parent;

public class AppInitializer extends Application {
    public static void main(String[] args) {
        launch(args);

    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        try {
            // Φορτώνουμε το αρχείο FXML
            Parent root = FXMLLoader.load(getClass().getResource("/view/CalForm.fxml"));
            Scene scene = new Scene(root);

            // Φορτώνουμε το αρχικό στυλ (Light Mode)
            scene.getStylesheets().add(getClass().getResource("/resources/light.css").toExternalForm());

            primaryStage.setScene(scene);
            primaryStage.setTitle("Calculator");
            primaryStage.show();
        } catch (Exception e) {
            e.printStackTrace();
        }
}}


