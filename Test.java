import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

/**
 * Created by kjh on 16. 11. 24.
 */
public class Test {
    public static void main(String[] args) throws IOException {
        Item item;
        Knapsack knapsack = new Knapsack();
        BufferedReader br = new BufferedReader(new FileReader("/home/kjh/Documents/git/Knapsack/src/data11.txt"));
        knapsack.itemList.add(new Item(0,0,0));
        while(true){
            String line = br.readLine();
            if(line == null) break;
            String[] temp = line.split(",");
            item = convertToInt(temp[0], temp[1], temp[2]);
            knapsack.itemList.add(item);
        }

        Scanner scan = new Scanner(System.in);
        System.out.print("가방 사이즈 : ");
        int size = scan.nextInt();

        knapsack.printTable(size);
    }

    public static Item convertToInt(String str1, String str2, String str3){
        return new Item(Integer.parseInt(str1), Integer.parseInt(str2), Integer.parseInt(str3));
    }
}
