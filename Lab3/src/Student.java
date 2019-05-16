class Student{
    public String surname;
    public int index;

    public Student(String surname, int index) {
        this.surname = surname;
        this.index = index;
    }

    @Override
    public String toString() {
        return surname +" "+index;
    }

    public int getIndex() {
        return index;
    }
}