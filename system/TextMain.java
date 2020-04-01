package system;

import javafx.scene.effect.DropShadow;
import javafx.scene.paint.Color;
import javafx.scene.paint.CycleMethod;
import javafx.scene.paint.LinearGradient;
import javafx.scene.paint.Stop;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;

class TextMain {
    Text createText() {
        Text text = new Text("     Welcome to \n Student Information \n  Management System");
        text.setFont(Font.font("Consolas", FontWeight.BOLD, 70));
        text.setFill(new LinearGradient(0, 0, 1, 2, true, CycleMethod.REPEAT,
                new Stop(0, Color.AQUA), new Stop(0.5f, Color.RED)));
        DropShadow dropShadow = new DropShadow();
        dropShadow.setOffsetY(3.0f);
        dropShadow.setColor(Color.color(0.4f, 0.4f, 0.4f));
        text.setEffect(dropShadow);
        text.setStrokeWidth(1);
        text.setStroke(Color.BLACK);
        return text;
    }
}
