public class Scene {
    private Element[][] elements;//contains each of the elements [x][y]
    private Picture pic;//what the user sees on the screen
    private final double GRAVITY = -.01;//the acceleration of gravity
    private final boolean FLOOR = true;//if there is a floor on the ground

    public Scene(int width, int height) {
        elements = new Element[width][height];
        pic = new Picture(width, height);
        pic.setOriginLowerLeft();

        elements = makeNewCells();

        // TODO: 12/5/2019 DELETE ME
        for (int x = 0 ; x < elements.length ; x++) {
            for (int y = 0 ; y < elements[x].length; y++) {

                elements[x][y] = new Water(x, y);
            }//y
        }//x

        run();
    }

    //==================================================================================================================

    //region Private Methods


    //sets the acceleration of gravity of each cell to GRAVITY
    private void addGravity(){
        for (int x = 0 ; x < elements.length ; x++) {
            for (int y = 0 ; y < elements[x].length ; y++) {

                elements[x][y].addVel(0, GRAVITY);
            }//y
        }//x
    }

    //returns an Element[][] with new Elements
    private Element[][] makeNewCells(){
        Element[][] elementsCopy = new Element[elements.length][elements[0].length];

        for (int x = 0 ; x < elements.length ; x++) {
            for (int y = 0 ; y < elements[x].length ; y++) {

                elementsCopy[x][y] = new Element(x, y);
            }//y
        }//x

        return elementsCopy;
    }

    //if a element is null, change it to a default element
    private void cleanUpCells(){
        for (int x = 0 ; x < elements.length ; x++) {
            for (int y = 0 ; y < elements[x].length ; y++) {

                if(elements[x][y] == null) elements[x][y] = new Element(x, y);
            }//y
        }//x
    }


    //endregion

    //==================================================================================================================

    //does all of the fun stuff
    public void run(){

        while (true){
            addGravity();
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

        updateIndexes();
    }

    //==================================================================================================================

    // TODO: 12/5/2019 method broken 
    //moves the elements to their "proper" indexes
    public void updateIndexes(){
        Element[][] elementsCopy = new Element[elements.length][elements[0].length];

        for (int x = 0 ; x < elements.length ; x++) {
            for (int y = 0 ; y < elements[x].length ; y++) {

                //for every element, move the element to its x, y position
                Element element = elements[x][y];

                if(!element.type.equals("N/A")) {

                    //if the element's new position is inside
                    if (element.getY() >= 0 && element.getY() < elements[0].length &&
                            element.getX() >= 0 && element.getX() < elements.length) {

                        elementsCopy[element.getX()][element.getY()] = element;
                    }
                }
            }//y
        }//x

        elements = elementsCopy;

        cleanUpCells();
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
