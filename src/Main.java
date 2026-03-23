
public class Main {

    public static void main(String[] args) {
        // int array[] = new int[]{11, 22, 33}; // 这个数组和下面变量名冲突，建议注释掉
        DynamicArray array = new DynamicArray();

        array.add(11);
        array.add(12);
        array.add(13);
        array.add(13);
        array.add(13);
        array.add(13);
        array.add(13);
        array.add(13);

        System.out.println("删除前：" + array);
        array.remove(0);
        System.out.println("删除后：" + array);

        array.add(2, 33);
        System.out.println("插入后：" + array);
    }
}

    public static int fib1(int n) {
        if (n <= 1) return n;
        return fib1(n - 1) + fib1(n - 2);
    }
    public static int fib2(int n){
        if(n<=1) return n;
        int first=0;
        int second=1;
        for(int i=0;i<n-1;i++){
            int sum=first+second;
            first=second;
            second=sum;
        }
        return second;
    }

    public static void main(String[] args){
        TimeTool.check("fib1",new TimeTool.Task(){
            public void execute(){
                System.out.println(fib1(30));
            }
        });
                TimeTool.check("fib2", new TimeTool.Task() {
                    public void execute() {
                        System.out.println(fib2(30));
                    }
                });
        System.out.println(fib2(64));
               //TIP 当文本光标位于高亮显示的文本处时按 <shortcut actionId="ShowIntentionActions"/>
        // 查看 IntelliJ IDEA 建议如何修正。

    }
}

