public class Element {
    protected Vector pos;//the position of the element in the scene
    protected Vector vel;//the velocity of the element
    protected Vector acc;//the acceleration of the element
    public String type;//the name of the element

    public Element(){
        pos = new Vector();
        vel = new Vector();
        acc = new Vector();
        type = "N/A";
    }

    public Element(double x, double y, String type){
        pos = new Vector(x, y);
        vel = new Vector();
        acc = new Vector();
        this.type = type;
    }

    //==================================================================================================================

    //region Gets and Sets
    //returns the pixel value of the x position
    public int getX(){
        return (int) (Math.round(pos.getX()));
    }

    //returns the pixel value of the y position
    public int getY(){
        return (int) (Math.round(pos.getY()));
    }
    //endregion

    //==================================================================================================================

}
