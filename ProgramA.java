/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package programa;


import java.util.HashMap;
import java.util.Map;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.MapValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import javafx.util.Callback;
import javafx.util.StringConverter;


/**
 *
 * @author letic
 */
public class ProgramA extends Application {
    public static final String Column1MapKey = "A";
    public static final String Column2MapKey = "B";
    public static final String Column3MapKey = "C";
    public static final String Column4MapKey = "D";
    public static final String Column5MapKey = "E";
    public static final String Column6MapKey = "F";
 
    public static void main(String[] args) {
        launch(args);
    }
    
    @Override         
    public void start(Stage stage) {
        Scene scene = new Scene(new Group());
        stage.setTitle("Table View Sample");
        stage.setWidth(850);
        stage.setHeight(500);
        
        final Label label = new Label("Tabela do jogos");
        label.setFont(new Font("Arial", 20));
      
        TableColumn<Map, String> firstDataColumn = new TableColumn<>("JOGO");
        TableColumn<Map, String> secondDataColumn = new TableColumn<>("PLACAR");
        TableColumn<Map, String> thirdDataColumn = new TableColumn<>("MÍNIMO DA TEMPORADA");
        TableColumn<Map, String> fourthDataColumn = new TableColumn<>("MÁXIMO DA TEMPORADA");
        TableColumn<Map, String> fifthDataColumn = new TableColumn<>("QUEBRA RECORDE MÍNIMO");
        TableColumn<Map, String> sixthDataColumn = new TableColumn<>("QUEBRA RECORDE MÁXIMO");
        
        firstDataColumn.setCellValueFactory(new MapValueFactory(Column1MapKey));
        firstDataColumn.setMinWidth(80);
        secondDataColumn.setCellValueFactory(new MapValueFactory(Column2MapKey));
        secondDataColumn.setMinWidth(80);
        thirdDataColumn.setCellValueFactory(new MapValueFactory(Column3MapKey));
        thirdDataColumn.setMinWidth(140);
        fourthDataColumn.setCellValueFactory(new MapValueFactory(Column4MapKey));
        fourthDataColumn.setMinWidth(140); 
        fifthDataColumn.setCellValueFactory(new MapValueFactory(Column3MapKey));
        fifthDataColumn.setMinWidth(140);
        sixthDataColumn.setCellValueFactory(new MapValueFactory(Column4MapKey));
        sixthDataColumn.setMinWidth(140);
        
        TableView table_view = new TableView<>(generateDataInMap());
 
        table_view.setEditable(true);
        table_view.getSelectionModel().setCellSelectionEnabled(true);
        table_view.getColumns().setAll(firstDataColumn, secondDataColumn, thirdDataColumn, fourthDataColumn, fifthDataColumn, sixthDataColumn);
        Callback<TableColumn<Map, String>, TableCell<Map, String>>
            cellFactoryForMap = new Callback<TableColumn<Map, String>,
                TableCell<Map, String>>() {
                    @Override
                    public TableCell call(TableColumn p) {
                        return new TextFieldTableCell(new StringConverter() {
                            @Override
                            public String toString(Object t) {
                                return t.toString();
                            }
                            @Override
                            public Object fromString(String string) {
                                return string;
                            }                                    
                        });
                    }
        };
        firstDataColumn.setCellFactory(cellFactoryForMap);
        secondDataColumn.setCellFactory(cellFactoryForMap);
        thirdDataColumn.setCellFactory(cellFactoryForMap);
        fourthDataColumn.setCellFactory(cellFactoryForMap);
        fifthDataColumn.setCellFactory(cellFactoryForMap);
        sixthDataColumn.setCellFactory(cellFactoryForMap);
         
        
        final VBox vbox = new VBox();
 
        vbox.setSpacing(5);
        vbox.setPadding(new Insets(10, 0, 0, 10));
        vbox.getChildren().addAll(label, table_view);
 
        ((Group) scene.getRoot()).getChildren().addAll(vbox);
 
        stage.setScene(scene);
 
        stage.show();
    }
 
    private ObservableList<Map> generateDataInMap() {
        int max = 50;
        ObservableList<Map> allData = FXCollections.observableArrayList();
        for (int i = 1; i < max; i++) {
            Map<String, String> dataRow = new HashMap<>();
 
            String value1 = "A" + i;
            String value2 = "B" + i;
            String value3 = "C" + i;
            String value4 = "C" + i;
            String value5 = "C" + i;
            String value6 = "C" + i;
 
            dataRow.put(Column1MapKey, value1);
            dataRow.put(Column2MapKey, value2);
            dataRow.put(Column3MapKey, value3);
            dataRow.put(Column4MapKey, value4);
            dataRow.put(Column5MapKey, value3);
            dataRow.put(Column6MapKey, value4);
            
            allData.add(dataRow);
        }
        return allData;
        
    }
}