public class Oak extends Tree {
    private int acorns;

    public Oak(String name, int age, int acorns) {
        super(name, age);
        this.acorns = acorns;
    }

    public int getAcorns() {
        return acorns;
    }

    public void setAcorns(int acorns) {
        this.acorns = acorns;
    }

    public void collectAcorns(){
        if(acorns>0){
            acorns = 0;
            System.out.println("Wszystkie żołędzie zostały zebrane!");
        }
        else {
            System.out.println("Na tym dąbie nie ma żołędzi :(...");
        }
    }
}
