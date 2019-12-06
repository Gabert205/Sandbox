public class Element {
    protected Vector pos;//the position of the element in the scene
    protected Vector vel;//the velocity of the element
    protected Vector acc;//the acceleration of the element

    public Element(){
        pos = new Vector();
        vel = new Vector();
        acc = new Vector();
    }

    public Element(double x, double y){
        pos = new Vector(x, y);
        vel = new Vector();
        acc = new Vector();
    }

    //==================================================================================================================


}
