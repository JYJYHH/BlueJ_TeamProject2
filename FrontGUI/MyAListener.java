package FrontGUI;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import CoreEngine.*;

/**
 * MyPanel의 Event Listener Object 
 *
 * @author (11팀)
 * @version (2025.12.04)
 */
public class MyAListener implements ActionListener
{
    public MyPanel mypanel;
    private String output = "";
    private int index;
    public MyAListener(MyPanel mypanel)
    {
        this.mypanel = mypanel;
    }
    public void actionPerformed(ActionEvent e){
        LibraryApplication libApp = new LibraryApplication("선문대학교 중앙도서관");

        if(e.getSource().equals(mypanel.mcb_selectUC)){
            JComboBox mcb = (JComboBox)e.getSource();
            index = mcb.getSelectedIndex(); 

            output = mypanel.selectUC[index] + "자 : " + mypanel.mtf_BorrowerName.getText() + "\n"
            + mypanel.selectUC[index] + "책 제목 : " + mypanel.mtf_BookTitle.getText() + "\n"
            + mypanel.selectUC[index] + "책 저자 : " + mypanel.mtf_BookAuthor.getText() + "\n"
            + mypanel.selectUC[index] + "책 등록번호 : " + mypanel.mtf_BookID.getText() + "\n"
            + "-------------------------------------------------" + "\n";
        }   

        if(index == 0 && e.getSource().equals(mypanel.mb_Run)){
            String outputTitle = libApp.registerOneBorrower(mypanel.mtf_BorrowerName.getText());
            mypanel.mta.append(outputTitle + "\n" + "-------------------------------------------------" + "\n");
        }
        else if(index == 1 && e.getSource().equals(mypanel.mb_Run)){
            String outputTitle = libApp.registerOneBook(mypanel.mtf_BookTitle.getText(),mypanel.mtf_BookAuthor.getText(),mypanel.mtf_BookID.getText());
            mypanel.mta.append(outputTitle + "\n" + "-------------------------------------------------" + "\n");        
        }
        else if(index == 2 && e.getSource().equals(mypanel.mb_Run)){
            String outputTitle = libApp.loanOneBook(mypanel.mtf_BorrowerName.getText(), mypanel.mtf_BookID.getText());
            mypanel.mta.append(outputTitle + "\n" + output);        
        }
        else if(index == 3 && e.getSource().equals(mypanel.mb_Run)){
            String outputTitle = libApp.returnOneBook(mypanel.mtf_BookID.getText());
            mypanel.mta.append(outputTitle + "\n" + output);
        }
        else if(e.getSource().equals(mypanel.mb_FloanD)){
            mypanel.mta.append(libApp.displayBookForLoan()+ "\n" + "-------------------------------------------------" + "\n");
        }
        else if(e.getSource().equals(mypanel.mb_OloanD)){
            mypanel.mta.append(libApp.displayBookOnLoan()+ "\n" + "-------------------------------------------------" + "\n");
        }
        else if(e.getSource().equals(mypanel.mb_Clear)){
            mypanel.mtf_BorrowerName.setText("");
            mypanel.mtf_BookTitle.setText("");
            mypanel.mtf_BookAuthor.setText("");
            mypanel.mtf_BookID.setText("");
        }

    }
}
