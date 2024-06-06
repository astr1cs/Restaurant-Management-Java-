package Classes;
public class MainItemList {
    private MainItem[] itemList;
    private int itemCount;

    public MainItemList(int index) {
        this.itemList = new MainItem[index];
        this.itemCount = 0;

    }

    public void addItem(MainItem item) {
        if (itemCount < itemList.length) {
            itemList[itemCount] = item;
            itemCount++;
        } else {

            // the array is full exception
            System.out.println("Cannot add more items. Array is full.");

        }
    }

    public void removeItem(MainItem item) {
        int index = indexOf(item);
        if (index != -1) {
            // Shift elements to fill the gap
            for (int i = index; i < itemCount - 1; i++) {
                itemList[i] = itemList[i + 1];
            }
            itemList[itemCount - 1] = null; // Set the last element to null and removes
            itemCount--;
        }
        else {
            System.out.println("Item not found.");
        }
    }

    private int indexOf(MainItem item) {
        for (int i = 0; i < itemCount; i++) {
            if (itemList[i].equals(item)) {
                return i;
            }
        }
        return -1; // Item not found
    }

    public MainItem[] getItemList() {
        MainItem[] result = new MainItem[itemCount];
        System.arraycopy(itemList, 0, result, 0, itemCount);
        return result;
    }
}
