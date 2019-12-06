public class Scene {
    private Element[][] cells;//contains each of the Cells [x][y]
    private Picture pic;//what the user sees on the screen

    public Scene(int width, int height) {
        cells = new Element[width][height];
        pic = new Picture(width, height);

        //fills cells with new Cells
        for (int x = 0 ; x < cells.length ; x++) {
            for (int y = 0 ; y < cells[x].length ; y++) {

                cells[x][y] = new Element();
            }//y
        }//x

        draw();
    }

    //==================================================================================================================

    //calls the update method for each of the Cells
    public void update() {
        for (int x = 0 ; x < cells.length ; x++) {
            for (int y = 0 ; y < cells[x].length ; y++) {

                cells[x][y].update();
            }//y
        }//x
    }

    //==================================================================================================================

    //fills pic with everything that is needed and shows on the screen
    public void draw() {

        for (int x = 0 ; x < cells.length ; x++) {
            for (int y = 0 ; y < cells[x].length ; y++) {

                switch (cells[x][y].type) {

                    case "water":
                        pic.setRGB(x, y, 0x0000FF);
                        break;

                    default:
                        pic.setRGB(x, y, 0x000000);
                        break;
                }
            }//y
        }//x

        pic.show();
    }
}
