import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        // 1. 初始化测试
        ArrayList list = new ArrayList();
        System.out.println("1. 初始化后，是否为空：" + list.isEmpty() + "，元素数量：" + list.size());
        System.out.println("初始化内容：" + list + "\n");

        // 2. 尾插测试
        list.add(11);
        list.add(22);
        list.add(33);
        System.out.println("2. 尾插 11, 22, 33 后：");
        System.out.println("内容：" + list);
        System.out.println("元素数量：" + list.size() + "\n");

        // 3. 指定位置插入测试
        list.add(1, 99); // 在索引 1 插入 99
        System.out.println("3. 在索引 1 插入 99 后：");
        System.out.println("内容：" + list);
        System.out.println("索引 1 的元素：" + list.get(1) + "\n");

        // 4. 修改元素测试
        list.set(2, 88); // 将索引 2 的元素改为 88
        System.out.println("4. 将索引 2 改为 88 后：");
        System.out.println("内容：" + list + "\n");

        // 5. 删除测试
        int removed = list.remove(3); // 删除索引 3 的元素
        System.out.println("5. 删除索引 3 的元素（值：" + removed + "）后：");
        System.out.println("内容：" + list);
        System.out.println("删除后数量：" + list.size() + "\n");

        // 6. 查找测试
        System.out.println("6. 查找 22 的索引：" + list.indexOf(22));
        System.out.println("查找 99 的索引：" + list.indexOf(99));
        System.out.println("是否包含 33：" + list.contains(33) + "\n");

        // 7. 扩容测试（添加超过默认容量 10 个元素）
        System.out.println("7. 开始扩容测试（添加 10 个元素）：");
        for (int i = 0; i < 10; i++) {
            list.add(i + 100);
            System.out.print("添加 " + (i + 100) + "，");
        }
        System.out.println("\n扩容后内容：" + list + "\n");

        // 8. 清空测试
        list.clear();
        System.out.println("8. 清空后，是否为空：" + list.isEmpty() + "，内容：" + list);

        // 9. 越界测试（取消注释查看异常）
        // System.out.println(list.get(10)); // 越界访问
        // list.remove(-1); // 越界删除
    }
}




