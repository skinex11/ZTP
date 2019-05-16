public class Container<T extends Plant> {
    private T type;

    public Container(T type){
        this.type = type;
    }

    public T getType(){
        return type;
    }
}
