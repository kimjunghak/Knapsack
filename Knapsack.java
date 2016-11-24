import java.util.ArrayList;

/**
 * Created by kjh on 16. 11. 23.
 */

public class Knapsack {

    ArrayList<Item> itemList = new ArrayList<>();

    private int opt(int index, int weight){
        Item item = itemList.get(index);
        if(index == 0)
            return 0;

        else if(item.weight > weight)
            return opt(index-1, weight);

        else
            return max(opt(index - 1, weight), item.value + opt(index - 1, weight - item.weight));
    }

    public void printTable(int weight){
        int size = itemList.size();
        int[][] table = new int[size][weight+1];
        for(int i=0 ; i<size ; i++){

            for(int j=0 ; j<=weight ; j++) {
                table[i][j] = opt(i,j);
                System.out.printf("%4d", table[i][j]);
            }

            System.out.println();
        }

        int max =table[size-1][weight];

        System.out.println();
        System.out.println("max : " + max);
        System.out.print("item : ");

        ArrayList print = itemSelect(weight, size, table);
        printItem(print);

    }

    private void printItem(ArrayList print) {
        for(int i=print.size()-1 ; i>=0 ; i--)
            System.out.print(print.get(i) + " ");
    }

    private ArrayList itemSelect(int weight, int size, int[][] table) {
        ArrayList item = new ArrayList();
        int i = size-1;
        int line = weight;
        while(i>0){
            try {
                if ((table[i][line] - table[i - 1][line - itemList.get(i).weight]) == itemList.get(i).value) {
                    item.add(itemList.get(i).item);
                    line = line - itemList.get(i).weight;
                    if (line < 0)
                        return item;
                    i--;
                } else
                    i--;
            }
            catch(ArrayIndexOutOfBoundsException e) {
                i--;
                continue;
            }

        }
        return item;
    }

    public int max(int a, int b){
        return Math.max(a, b);
    }
}
