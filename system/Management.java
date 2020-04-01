package system;

import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.MenuBar;
import javafx.scene.image.Image;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class Management extends Application {

    private MenuBar createMenuBar(BorderPane borderPane) {
        MenuBar menuBar = new MenuBar();
        CreateMenu createMenu = new CreateMenu();
        menuBar.getMenus().addAll(createMenu.createMenuInformationEntry(borderPane),
                createMenu.createMenuInformationSearch(borderPane), createMenu.createMenuInformationUpdate(borderPane),
                createMenu.createMenuInformationDelete(borderPane), createMenu.createMenuInformationSystem(borderPane));
        return menuBar;
    }

    private BorderPane createBorderPane() {
        BorderPane borderPane = new BorderPane();
        borderPane.setTop(createMenuBar(borderPane));
        borderPane.setCenter(new TextMain().createText());
        return borderPane;
    }

    private Scene createScene() {
        return new Scene(createBorderPane(), 800, 600);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        Scene scene = createScene();
        primaryStage.setScene(scene);
        primaryStage.setTitle("Student Information Management System");
        primaryStage.setResizable(false);
        primaryStage.getIcons().add(new Image(Management.class.getResourceAsStream("/source/UniversityTable.png")));

        EventHandler<MouseEvent> handler = new DragWindowHandler(primaryStage);
        scene.setOnMousePressed(handler);
        scene.setOnMouseDragged(handler);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }

}
