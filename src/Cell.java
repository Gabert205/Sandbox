public class Cell {
    private Element element;//what the Cell's elemental type is
    private Cell[] neighbors;//the orthogonal neighbors of the Cell
    //private double temperature;//the temperature of the Cell
    //private double airPressure;
    
    public Cell(){
        // TODO: 12/5/2019 Change this the default element to air 
        element = null;
        neighbors = new Cell[4];
    }
    
    public Cell(Element element){
        this.element = element;
        neighbors = new Cell[4];
    }
    
    //==================================================================================================================

}
