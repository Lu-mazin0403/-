public class DynamicArray {
    // 底层存储数组
    private int[] elementData;
    // 实际元素数量
    private int size;
    // 默认初始容量
    private static final int DEFAULT_CAPACITY = 10;

    /**
     * 构造方法：初始化默认容量的动态数组
     */
    public DynamicArray() {
        elementData = new int[DEFAULT_CAPACITY];
        size = 0;
    }

    /**
     * 尾插法：添加元素到数组末尾
     */
    public void add(int value) {
        // 检查是否需要扩容
        growIfNeeded();
        elementData[size++] = value;
    }

    /**
     * 指定索引插入元素
     */
    public void add(int index, int value) {
        // 检查索引合法性
        checkIndexForAdd(index);
        // 检查是否需要扩容
        growIfNeeded();

        // 从后往前移动元素，给待插入元素腾位置
        for (int i = size; i > index; i--) {
            elementData[i] = elementData[i - 1];
        }
        // 插入元素
        elementData[index] = value;
        size++;
    }

    /**
     * 删除指定索引位置的元素
     */
    public void remove(int index) {
        // 检查索引合法性
        checkIndex(index);

        // 从前往后移动元素，覆盖被删除元素
        for (int i = index; i < size - 1; i++) {
            elementData[i] = elementData[i + 1];
        }
        size--;
    }

    /**
     * 私有方法：检查索引是否合法（用于访问/删除）
     */
    private void checkIndex(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
        }
    }

    /**
     * 私有方法：检查索引是否合法（用于添加）
     */
    private void checkIndexForAdd(int index) {
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
        }
    }

    /**
     * 私有方法：容量不足时扩容（1.5倍）
     */
    private void growIfNeeded() {
        if (size == elementData.length) {
            // 新容量 = 原容量 * 3 / 2
            int newCapacity = elementData.length + (elementData.length >> 1);
            int[] newElementData = new int[newCapacity];
            // 复制原数组元素到新数组
            System.arraycopy(elementData, 0, newElementData, 0, size);
            elementData = newElementData;
        }
    }

    // 以下为方便测试，可选的打印方法
    @Override
    public String toString() {
        if (size == 0) {
            return "[]";
        }
        StringBuilder sb = new StringBuilder("[");
        for (int i = 0; i < size; i++) {
            sb.append(elementData[i]).append(", ");
        }
        sb.setLength(sb.length() - 2);
        sb.append("]");
        return sb.toString();
    }
}
