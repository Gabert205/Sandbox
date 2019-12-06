public class Element {
    protected Vector pos;//the position of the element in the scene
    protected Vector vel;//the velocity of the element
    protected Vector acc;//the acceleration of the element
    private Element[] neighbors;//the orthogonal neighbors of the element
    public String type;//the name of the element
    private boolean locked;//if true, the element won't change positions

    public Element() {
        pos = new Vector();
        vel = new Vector();
        acc = new Vector();
        neighbors = new Element[4];
        type = "N/A";
    }

    public Element(double x, double y, String type) {
        pos = new Vector(x, y);
        vel = new Vector();
        acc = new Vector();
        neighbors = new Element[4];
        this.type = type;
    }

    //==================================================================================================================

    //region Gets and Sets


    //returns the pixel value of the x position
    public int getX() {
        return (int) ( Math.round(pos.getX()) );
    }

    //returns the pixel value of the y position
    public int getY() {
        return (int) ( Math.round(pos.getY()) );
    }

    //returns the neighbor at the given index
    //0 - up ### 1 - right ### 2 - down ### 3 - left
    public Element getNeighbor(int direction){
        return neighbors[direction];
    }


    //endregion

    //==================================================================================================================

    public void update() {
        if (!locked) {
            vel.update(acc);
            pos.update(vel);
        }
    }
}
