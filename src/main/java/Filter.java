import java.io.*;
import java.util.*;

public class Filter {

    private File fileIn;
    private File fileOut;

    private List<Integer> list;
    private  List<Integer> list2;
    private  List<Integer> list3;


    public Filter() {
        list = new ArrayList<>();
        list2 = new ArrayList<>();
        list3 = new ArrayList<>();
    }

    public static void main(String[] args) {

        Filter filter = new Filter();

        String pathIn = "src/main/resources/input.txt";
        String pathOut = "src/main/resources/output.txt";

        filter.setFileIn(new File(pathIn).getAbsoluteFile());
        filter.setFileOut(new File(pathOut).getAbsoluteFile());
        filter.readFileNum();
        filter.evenNumList();
        filter.sortList();
        filter.writeFile();


    }

    public void setFileIn(File fileIn) {
        this.fileIn = fileIn;
    }
    public void setFileOut(File fileOut) {
        this.fileOut = fileOut;
    }

    public void readFileNum() {
        try (Scanner in = new Scanner(fileIn)) {
            while (in.hasNextInt()) {
                Integer num = in.nextInt();
                list.add(num);
            }
        } catch (FileNotFoundException e) {
            System.out.println(e.fillInStackTrace());

        }
    }

    public void evenNumList(){
        this.list.stream().filter(num -> num % 2==0).forEach(num -> this.list2.add(num*num));
    }

    public void sortList(){
        Collections.sort(this.list2);
    }

    public void writeFile(){
        try (FileWriter writer = new FileWriter(fileOut)){
            this.list2.forEach(num-> {
                try {
                    writer.write(num+" ");
                } catch (IOException e) {
                    e.printStackTrace();
                }
            });
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


}
