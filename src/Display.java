import java.io.IOException;

public interface Display {
    void show() throws IOException, ClassNotFoundException;
    void addInfos() throws IOException, ClassNotFoundException;
    void edit();
    void delete();
    void search();
    void readFile() throws IOException, ClassNotFoundException;
    void writeToFile() throws IOException, ClassNotFoundException;

}
