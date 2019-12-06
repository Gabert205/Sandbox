public class Scene {
    private Element[][] elements;//contains each of the elements [x][y]
    private Picture pic;//what the user sees on the screen
    private final double GRAVITY = 1;//the acceleration of gravity

    public Scene(int width, int height) {
        elements = new Element[width][height];
        pic = new Picture(width, height);

        resetCells();

        // TODO: 12/5/2019 DELETE ME
        for (int x = 0 ; x < elements.length ; x++) {
            for (int y = elements[x].length / 2 ; y < elements[x].length ; y++) {

                elements[x][y] = new Water(x, y);
            }//y
        }//x

        run();
    }

    //==================================================================================================================

    //region Private Methods


    //sets the acceleration of gravity of each cell to GRAVITY
    //---WARNING--- it only adds gravity, so if there is already an acceleration, there is now more
    private void addGravity(){
        for (int x = 0 ; x < elements.length ; x++) {
            for (int y = 0 ; y < elements[x].length ; y++) {

                elements[x][y].addAcc(0, GRAVITY);
            }//y
        }//x
    }

    //removes the acceleration of gravity
    //---WARNING--- it only subtracts gravity, so if there is no acceleration, it will accelerate upwards
    private void removeGravity(){
        for (int x = 0 ; x < elements.length ; x++) {
            for (int y = 0 ; y < elements[x].length ; y++) {

                elements[x][y].addAcc(0, 0);
            }//y
        }//x
    }

    //fills elements with new Cells
    private void resetCells(){

        for (int x = 0 ; x < elements.length ; x++) {
            for (int y = 0 ; y < elements[x].length ; y++) {

                elements[x][y] = new Element(x, y);
            }//y
        }//x
    }


    //endregion

    //==================================================================================================================

    public void run(){
        addGravity();

        while (true){
            update();
            draw();
        }
    }

    //calls the update method for each of the Cells
    public void update() {
        for (int x = 0 ; x < elements.length ; x++) {
            for (int y = 0 ; y < elements[x].length ; y++) {

                elements[x][y].update();
            }//y
        }//x
    }

    //==================================================================================================================

    public void updateIndexes(){
        Element[][] elementsCopy = elements.clone();


    }

    //==================================================================================================================

    //fills pic with everything that is needed and shows on the screen
    public void draw() {

        for (int x = 0 ; x < elements.length ; x++) {
            for (int y = 0 ; y < elements[x].length ; y++) {

                switch (elements[x][y].type) {

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
