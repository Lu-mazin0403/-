import java.util.Arrays;

public class ArrayList {
    /**
     * 元素的数量
     */
    private int size;
    /**
     * 所有的元素
     */
    private int[] elements;

    private static final int DEFAULT_CAPACITY = 10;

    public ArrayList(int capacity) {
        capacity = (capacity < DEFAULT_CAPACITY) ? DEFAULT_CAPACITY : capacity;
        elements = new int[capacity];
    }

    public ArrayList() {
        this(DEFAULT_CAPACITY);
    }

    /**
     * 清除所有元素
     */
    

        public void clear() {
            size = 0;
            // 可选：把数组内容也清零（不强制）
            Arrays.fill(elements, 0);
        }

       
    


    /**
     * 返回元素数量
     */
    public int size() {
        return size;
    }

    /**
     * 是否为空
     */
    public boolean isEmpty() {
        return size == 0;
    }

    /**
     * 获取 index 位置的元素
     */
    public int get(int index) {
        checkIndex(index);
        return elements[index];
    }

    /**
     * 设置 index 位置的元素为 value
     */
    public void set(int index, int value) {
        checkIndex(index);
        elements[index] = value;
    }

    /**
     * 添加元素到末尾
     */
    public void add(int value) {
        add(size, value);
    }

    /**
     * 在 index 位置插入元素
     */
    public void add(int index, int value) {
        checkIndexForAdd(index);
        ensureCapacity(size + 1);

        // 从后往前移动
        for (int i = size; i > index; i--) {
            elements[i] = elements[i - 1];
        }
        elements[index] = value;
        size++;
    }

    /**
     * 删除 index 位置的元素
     */
    public int remove(int index) {
        checkIndex(index);
        int oldValue = elements[index];

        // 从前往后移动
        for (int i = index; i < size - 1; i++) {
            elements[i] = elements[i + 1];
        }
        size--;
        return oldValue;
    }

    /**
     * 是否包含某个元素
     */
    public boolean contains(int value) {
        return indexOf(value) != -1;
    }

    /**
     * 返回元素第一次出现的索引，不存在返回 -1
     */
    public int indexOf(int value) {
        for (int i = 0; i < size; i++) {
            if (elements[i] == value) {
                return i;
            }
        }
        return -1;
    }

    /**
     * 确保容量足够（不够则扩容 1.5 倍）
     */
    private void ensureCapacity(int capacity) {
        int oldCapacity = elements.length;
        if (oldCapacity >= capacity) return;

        // 新容量 = 老容量 * 1.5
        int newCapacity = oldCapacity + (oldCapacity >> 1);
        int[] newElements = new int[newCapacity];
        System.arraycopy(elements, 0, newElements, 0, size);
        elements = newElements;
    }

    /**
     * 检查访问索引是否合法
     */
    private void checkIndex(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("index: " + index + ", size: " + size);
        }
    }

    /**
     * 检查添加索引是否合法
     */
    private void checkIndexForAdd(int index) {
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException("index: " + index + ", size: " + size);
        }
    }

    @Override
    public String toString() {
        if (size == 0) return "[]";
        StringBuilder sb = new StringBuilder("[");
        for (int i = 0; i < size; i++) {
            sb.append(elements[i]).append(", ");
        }
        sb.setLength(sb.length() - 2);
        sb.append("]");
        return sb.toString();
    }
}
