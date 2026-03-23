
public class Main {
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