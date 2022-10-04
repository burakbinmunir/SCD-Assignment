public class Main {

    public <T> void cout(T a){
        System.out.println(a);
    }

    public static void main(String[] args) {
        Main m = new Main();
        m.cout("Sallam");
        m.cout(1);
        m.cout('s');
        m.cout(true);
    }
}
