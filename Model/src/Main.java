import java.util.Random;

public class Main {
    public static void main(String [ ] args)
    {
       int[] data = new int[100];
       for(int i = 0; i<data.length; ++i) {
           Random rg = new Random();
           int n = rg.nextInt(7);
           data[i] =Integer.parseInt(Integer.toBinaryString(n));
       }
        NetworkAdapter test = new NetworkAdapter();
        test.packageFrame(data);
        test.frameArr.get(0).print();
        //test.printFrames();
    }
}
