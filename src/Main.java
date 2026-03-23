
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
