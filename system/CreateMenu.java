package system;

import javafx.event.ActionEvent;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuItem;
import javafx.scene.layout.BorderPane;

class CreateMenu {
	Menu createMenuInformationEntry(BorderPane borderPane) {
		Menu menu = new Menu("Information _Entry");
		menu.setMnemonicParsing(true); // 设置快捷键有效
		MenuItem menuItem = new MenuItem("Entry");
		menu.getItems().addAll(menuItem);
		
		menuItem.setOnAction((ActionEvent event) -> {
			try {
				borderPane.setCenter(new Entry().createNode());
			} catch (Exception e) {
				e.printStackTrace();
			}
		});
		return menu;
	}

	Menu createMenuInformationSearch(BorderPane borderPane) {
		Menu menu = new Menu("Information _Search");
		menu.setMnemonicParsing(true); // 设置快捷键有效
		MenuItem menuItem = new MenuItem("Search");
		menu.getItems().addAll(menuItem);
		
		menuItem.setOnAction((ActionEvent event) -> {
			try {
				borderPane.setCenter(new Search().createNode());
			} catch (Exception e) {
				e.printStackTrace();
			}
		});
		return menu;
	}

	Menu createMenuInformationUpdate(BorderPane borderPane) {
		Menu menu = new Menu("Information _Update");
		menu.setMnemonicParsing(true); // 设置快捷键有效
		MenuItem menuItem = new MenuItem("Update");
		menu.getItems().addAll(menuItem);
		
		menuItem.setOnAction((ActionEvent event) -> {
			try {
				borderPane.setCenter(new Update().createNode());
			} catch (Exception e) {
				e.printStackTrace();
			}
		});
		return menu;
	}

	Menu createMenuInformationDelete(BorderPane borderPane) {
		Menu menu = new Menu("Information _Delete");
		menu.setMnemonicParsing(true); // 设置快捷键有效
		MenuItem menuItem = new MenuItem("Delete");
		menu.getItems().addAll(menuItem);

		menuItem.setOnAction((ActionEvent event) -> {
			try {
				borderPane.setCenter(new Delete().createNode());
			} catch (Exception e) {
				e.printStackTrace();
			}
		});
		return menu;
	}

	Menu createMenuInformationSystem(BorderPane borderPane) {
		Menu menu = new Menu("S_ystem");
		menu.setMnemonicParsing(true); // 设置快捷键有效
		MenuItem menuItem1 = new MenuItem("Home");
		MenuItem menuItem2 = new MenuItem("Off");
		MenuItem menuItem3 = new MenuItem("Author");
		menu.getItems().addAll(menuItem1, menuItem2, menuItem3);

		menuItem1.setOnAction((ActionEvent event) -> {
			borderPane.setCenter(new TextMain().createText());
		});

		menuItem2.setOnAction((ActionEvent event) -> {
			if (new Off().show())
				System.exit(0);
		});

		menuItem3.setOnAction((ActionEvent event) -> {
			new Author().show();
		});
		return menu;
	}
}
