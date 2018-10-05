public interface NetworkDevice {

    public void packageFrame(int[] data);
    public void receive(Channel c);

}
