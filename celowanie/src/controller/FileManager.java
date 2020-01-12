package controller;

import model.ModelBoard;

import java.io.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.List;

public class FileManager {

    private String gameSavesPath;

    public FileManager() {
        gameSavesPath = System.getProperty("user.home") + "/.aassaves";
        new File(gameSavesPath).mkdir();
    }

    public void saveFile(ModelBoard modelBoard, int[] arrowsValues, List<Historian> historianList) {
        LocalDateTime now = LocalDateTime.now();
        String fileName = "/" + DateTimeFormatter.ofPattern("dd-MM-yyyy-HHmmss").format(now) + ".aas";
        GameFile gameFile = new GameFile(modelBoard, arrowsValues, historianList);
        try {
            FileOutputStream fos = new FileOutputStream(gameSavesPath + fileName);
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(gameFile);
            oos.flush();
            oos.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static class GameFile implements Serializable {

        private ModelBoard modelBoard;
        private int[] arrowsValues;
        private List<Historian> historianList;

        public GameFile(ModelBoard modelBoard, int[] arrowsValues, List<Historian> historianList) {

            this.historianList = historianList;
            this.modelBoard = modelBoard;
            this.arrowsValues = arrowsValues;
        }

        public ModelBoard getModelBoardFromSave() {
            return modelBoard;
        }

        public int[] getArrowsValuesFromSave() {
            return arrowsValues;
        }

        public List<Historian> getHistorianListFromSave() {
            return historianList;
        }
    }
}
