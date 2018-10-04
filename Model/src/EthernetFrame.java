public class EthernetFrame {
    String content = "";

    EthernetFrame(int[] data, int offset) {
        //Simplified initially to just be packet of 64 bytes.
        //Will add mac addresses checksums etc. once base program is working.
        for (int i = offset; i < (offset+64) && i < data.length; i++) {
            content += Integer.toString(data[i]);
        }

    }

    public void print(){
        System.out.println("Frame content: " + content + "\n");
    }
}
