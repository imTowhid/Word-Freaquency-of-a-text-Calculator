package sample;

public class Data {
    private int no;
    private String string;
    private int frequency;

    public int getNo() {
        return no;
    }

    public void setNo(int no) {
        this.no = no;
    }

    public String getString() {
        return string;
    }

    public void setString(String string) {
        this.string = string;
    }

    public int getFrequency() {
        return frequency;
    }

    public void setFrequency(int frequency) {
        this.frequency = frequency;
    }

    public Data(int no, String string, int frequency){
        this.no = no;
        this.string = string;
        this.frequency = frequency;
    }


}
