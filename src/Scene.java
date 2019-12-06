public class Scene {
    private Cell[][] cells;//contains each of the Cells [x][y]
    private Picture pic;//what the user sees on the screen

    public Scene(int width, int height){
        cells = new Cell[width][height];
        pic = new Picture(width, height);
    }
}
