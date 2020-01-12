package controller;

import model.ModelBoard;

import java.io.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;

public class FileManager {

    private String gameSavesPath;

    public FileManager() {
        gameSavesPath = System.getProperty("user.home") + "/.aassaves";
        new File(gameSavesPath).mkdir();
    }

    public void saveFile(ModelBoard modelBoard, int[] arrowsValues) {
        LocalDateTime now = LocalDateTime.now();
        String fileName = "/" + DateTimeFormatter.ofPattern("dd-MM-yyyy-HHmmss").format(now) + ".aas";
        GameFile gameFile = new GameFile(modelBoard, arrowsValues);
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

        public GameFile(ModelBoard modelBoard, int[] arrowsValues) {

            this.modelBoard = modelBoard;
            System.out.println(Arrays.deepToString(modelBoard.getCurrentGameBoard()));
            System.out.println(Arrays.deepToString(modelBoard.getCurrentSolutionBoard()));
            this.arrowsValues = arrowsValues;
            System.out.println(Arrays.toString(arrowsValues));
        }

        public ModelBoard getModelBoardFromSave() {
            return modelBoard;
        }

        public int[] getArrowsValuesFromSave() {
            return arrowsValues;
        }
    }
}
