package sample;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.FileChooser;

import java.io.File;
import java.io.FileInputStream;
import java.util.StringTokenizer;

public class Controller {

    @FXML public TableView<Data>tableView;
    @FXML public TableColumn<Data, Integer>no;
    @FXML public TableColumn<Data, String>strings;
    @FXML public TableColumn<Data, Integer>freq;

    private File file;

    public Button btnBrowse;
    public void btnBrowseClicked(){
        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Choose File");
        file = fileChooser.showOpenDialog(null);
    }

    public Button btnCalculate;
    public void btnCalculateClicked(){
        String string = new String();
        try{
            FileInputStream fin=new FileInputStream(file);
            int i=0;
            while((i=fin.read())!=-1){
                string+=(char)i;
            }
            fin.close();
        }catch(Exception e){System.out.println(e);}

        //System.out.println(string);
        listResult(string);
    }

    private void listResult(String string){
        StringTokenizer tokens = new StringTokenizer(string, ", ?!;:'.");
        //System.out.println(tokens.countTokens());
        int i = tokens.countTokens();
        String[] str = new String[500];
        int j=0;
        while(tokens.hasMoreTokens()){
            str[j]=tokens.nextToken();
            j++;
        }
        j=0;
        str[i]=null;
        int idx=0;
        int[] ara = new int[500];
        while(str[j]!=null){
            for(int k=j+1; str[k]!=null; k++){
                if(str[j].equals(str[k])){
                    int m;
                    ara[j]++;
                    for(m=k+1; str[m]!=null; m++){
                        str[m-1]=str[m];
                    }
                    str[m-1]=null;
                    k--;
                }
            }
            j++;
        }

        no.setCellValueFactory(new PropertyValueFactory<>("no"));
        strings.setCellValueFactory(new PropertyValueFactory<>("string"));
        freq.setCellValueFactory(new PropertyValueFactory<>("frequency"));

        while(j!=0){
            //System.out.println(str[idx]);
            //System.out.println(ara[idx]+1);
            String str1 = new String(str[idx]);
            Data data = new Data(idx+1, str1, ara[idx]+1);
            tableView.getItems().add(data);
            idx++;
            j--;
        }
    }

}
