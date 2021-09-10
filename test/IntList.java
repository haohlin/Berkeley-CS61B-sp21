public class IntList {
    public int first;
    public IntList rest;

    public IntList(int f, IntList r) {
        this.first = f;
        this.rest = r;
    }

    public int size() {
        if (this.rest == null) {
            return 1;
        }
        return 1 + this.rest.size();
    }

    public int iterSize() {
        IntList tempList = this;
        int count = 0;
        while (tempList != null) {
            tempList = tempList.rest;
            count ++;
        }
        return count;
    }

    public int get(int i) {
        IntList tempList = this;
        int count = 0;
        while (tempList != null) {
            if (count == i) {
                return tempList.first;
            }
            tempList = tempList.rest;
            count ++;
        }
        return 0;
    }

    public int recurGet(int i) {
        if (i == 0) {
            return this.first;
        }
        return this.rest.recurGet(i - 1);
    }

    public static void main(String[] args) {
        IntList l = new IntList(1, null);
        l = new IntList(2, l);
        l = new IntList(3, l);

        int s_pred = l.size();
        System.out.println(s_pred);
    }

}