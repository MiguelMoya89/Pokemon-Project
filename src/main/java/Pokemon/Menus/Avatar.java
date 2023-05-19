package Pokemon.Menus;

import Pokemon.Combate.CombateGrafico;
import Pokemon.Database.PokemonCRUD;
import Pokemon.Entrenador.Entrenador;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaView;
import javafx.stage.Stage;

public class Avatar extends Application {

    private static final int WINDOW_WIDTH = 1080;
    private static final int WINDOW_HEIGHT = 650;
    private Image selectedImage;
    private Stage primaryStage;
    private Scene previousScene;

    public Avatar(Stage primaryStage, Scene previousScene) {
        this.primaryStage = primaryStage;
        this.previousScene = previousScene;
    }

    @Override
    public void start(Stage primaryStage) {
        StackPane root = new StackPane();
        root.setStyle("-fx-background-color: black");

        Media videoBackground = new Media(getClass().getResource("/vid/avatar.mp4").toExternalForm());
        MediaPlayer mediaPlayer = new MediaPlayer(videoBackground);
        MediaView videoView = new MediaView(mediaPlayer);
        videoView.fitWidthProperty().bind(primaryStage.widthProperty());
        videoView.fitHeightProperty().bind(primaryStage.heightProperty());
        videoView.setPreserveRatio(false);
        videoView.setMediaPlayer(mediaPlayer);

        mediaPlayer.setCycleCount(MediaPlayer.INDEFINITE);
        mediaPlayer.play();

        VBox container = new VBox(10);
        container.setPadding(new Insets(10));
        container.setAlignment(Pos.CENTER);

        HBox avatarContainer = new HBox(10);
        avatarContainer.setAlignment(Pos.CENTER);

        Image image1 = new Image(getClass().getResourceAsStream("/img/entrenador1.gif"));
        Image image2 = new Image(getClass().getResourceAsStream("/img/entrenador2.gif"));
        Image image3 = new Image(getClass().getResourceAsStream("/img/alonso.png"));
        Image image4 = new Image(getClass().getResourceAsStream("/img/entrenador2.gif"));
        Image image5 = new Image(getClass().getResourceAsStream("/img/entrenador1.gif"));
        Image image6 = new Image(getClass().getResourceAsStream("/img/entrenador2.gif"));

        ImageView imageView1 = new ImageView(image1);
        imageView1.setFitWidth(50);
        imageView1.setFitHeight(50);


        ImageView imageView2 = new ImageView(image2);
        imageView2.setFitWidth(50);
        imageView2.setFitHeight(50);


        ImageView imageView3 = new ImageView(image3);
        imageView3.setFitWidth(50);
        imageView3.setFitHeight(50);


        ImageView imageView4 = new ImageView(image4);
        imageView4.setFitWidth(50);
        imageView4.setFitHeight(50);


        ImageView imageView5 = new ImageView(image5);
        imageView5.setFitWidth(50);
        imageView5.setFitHeight(50);


        ImageView imageView6 = new ImageView(image6);
        imageView6.setFitWidth(50);
        imageView6.setFitHeight(50);

        HBox.setMargin(imageView1, new Insets(0, 0, 0, -300));
        HBox.setMargin(imageView2, new Insets(0, 0, 0, 50));
        HBox.setMargin(imageView3, new Insets(0, 0, 0, 50));
        HBox.setMargin(imageView4, new Insets(0, 0, 0, 50));
        HBox.setMargin(imageView5, new Insets(0, 0, 0, 50));
        HBox.setMargin(imageView6, new Insets(0, 0, 0, 50));


        Button opcion1 = new Button();
        opcion1.setId("opcion1");
        Button opcion2 = new Button();
        opcion2.setId("opcion2");
        Button opcion3 = new Button();
        opcion3.setId("opcion3");
        Button opcion4 = new Button();
        opcion4.setId("opcion4");
        Button opcion5 = new Button();
        opcion5.setId("opcion5");
        Button opcion6 = new Button();
        opcion6.setId("opcion6");

        opcion1.setOnAction(e -> {
            String foto = "/img/Entrenador1.gif";
            Entrenador.setFoto(foto);
            PokemonCRUD.updateFoto(foto);
        });

        opcion2.setOnAction(e -> {
            String foto = "/img/Entrenador2.gif";
            Entrenador.setFoto(foto);
            PokemonCRUD.updateFoto(foto);
        });

        opcion3.setOnAction(e -> {
            String foto = "/img/alonso.gif";
            Entrenador.setFoto(foto);
            PokemonCRUD.updateFoto(foto);
        });

        opcion4.setOnAction(e -> {
            String foto = "/img/alonso1.gif";
            Entrenador.setFoto(foto);
            PokemonCRUD.updateFoto(foto);
        });

        opcion5.setOnAction(e -> {
            String foto = "/img/Entrenador1.gif";
            Entrenador.setFoto(foto);
            PokemonCRUD.updateFoto(foto);
        });

        opcion6.setOnAction(e -> {
            String foto = "/img/Entrenador2.gif";
            Entrenador.setFoto(foto);
            PokemonCRUD.updateFoto(foto);
        });

        avatarContainer.getChildren().addAll(opcion1, opcion2, opcion3, opcion4, opcion5, opcion6,
                imageView1, imageView2, imageView3, imageView4, imageView5, imageView6);

        Button aceptar = new Button();
        aceptar.setId("aceptar");
        aceptar.setOnAction(event -> {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Cambios aplicados");
            alert.setHeaderText(null);
            alert.setContentText("¡El avatar se ha actualizado correctamente!");
            alert.showAndWait();

        });

        Button backButton = new Button();
        backButton.setId("back");
        backButton.setOnAction(e -> {
            StackPane.setAlignment(backButton, Pos.TOP_LEFT);
            primaryStage.setScene(previousScene);
        });

        container.getChildren().addAll(avatarContainer, aceptar, backButton);
        root.getChildren().addAll(videoView, container);

        Scene scene = new Scene(root, WINDOW_WIDTH, WINDOW_HEIGHT);
        scene.getStylesheets().add("Avatar.css");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}