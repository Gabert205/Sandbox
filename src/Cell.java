public class Cell {
    public Element element;//what the Cell's elemental type is
    private Cell[] neighbors;//the orthogonal neighbors of the Cell
    //private double temperature;//the temperature of the Cell
    //private double airPressure;
    
    public Cell(){
        // TODO: 12/5/2019 Change the default element to air
        element = new Element();
        neighbors = new Cell[4];
    }
    
    public Cell(Element element){
        this.element = element;
        neighbors = new Cell[4];
    }
    
    //==================================================================================================================

}
