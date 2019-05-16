public class Display {
    public static void main(String args[]){
        Container<Plant> plantContainer = new Container<>(new Plant("Hibiskus"));
        Container<Tree> treeContainer = new Container<>(new Tree("Kasztan",154));
        Container<Oak> oakContainer = new Container<>(new Oak("Bartek", 1200, 986));

        pokazPlant(plantContainer);
        pokazPlant(treeContainer);
        pokazPlant(oakContainer);

        //pokazTree(plantContainer);
        pokazTree(treeContainer);
        pokazTree(oakContainer);

        //pokazOak(plantContainer);
        //pokazOak(treeContainer);
        pokazOak(oakContainer);
    }

    public static void pokazPlant(Container<? extends Plant> k){
        k.getType().water();
    }

    public static void pokazTree(Container<? extends Tree> k){
        System.out.println("Twoja roślina ma: "+k.getType().getAge());
    }

    public static void pokazOak(Container<? extends Oak> k){
        k.getType().collectAcorns();
    }
}
