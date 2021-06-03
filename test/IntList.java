public class IntList {
    public int first;
    public IntList rest;

    public IntList(int f, IntList r) {
        first = f;
        rest = r;
    }

    public int size() {
        if (rest == null) {
            return 1;
        }
        int s  = 1 + rest.size();
        return s;
    }

    public static void main(String[] args) {
    }

}