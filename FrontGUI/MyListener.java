package FrontGUI;
import java.awt.event.*;
import CoreEngine.*;

/**
 * ActionListener 클래스의 설명을 작성하세요.
 *
 * @author (작성자 이름)
 * @version (버전 번호 또는 작성한 날짜)
 */
public class MyListener implements ActionListener
{

    private MyPanel panel;
    private int index;
    private String output = "";
    private LibraryApplication libApp;

    public MyListener(MyPanel panel){
        this.panel = panel;
        this.libApp = new LibraryApplication("선문대학교 중앙도서관");
    }

    public void actionPerformed(ActionEvent e){
        Object src = e.getSource();

        if (src.equals(panel.mcb_selectUC)){
            index = panel.mcb_selectUC.getSelectedIndex();
            output = panel.selectUC[index] + "자 : " + panel.mtf_BorrowerName.getText() + "\n"
                    + panel.selectUC[index] + "책 제목 : " + panel.mtf_BookTitle.getText() + "\n"
                    + panel.selectUC[index] + "책 저자 : " + panel.mtf_BookAuthor.getText() + "\n"
                    + panel.selectUC[index] + "책 등록번호 : " + panel.mtf_BookID.getText() + "\n"
                    + "-------------------------------------------------\n";
        }

        // 실행 버튼
        if(index == 0 && src.equals(panel.mb_Run)){
            String outputTitle = libApp.registerOneBorrower(
                    panel.mtf_BorrowerName.getText());
            panel.mta.append(outputTitle + "\n"
                    + "-------------------------------------------------\n");
        }
        else if(index == 1 && src.equals(panel.mb_Run)){
            String outputTitle = libApp.registerOneBook(
                    panel.mtf_BookTitle.getText(),
                    panel.mtf_BookAuthor.getText(),
                    panel.mtf_BookID.getText());
            panel.mta.append(outputTitle + "\n"
                    + "-------------------------------------------------\n");
        }
        else if(index == 2 && src.equals(panel.mb_Run)){
            String outputTitle = libApp.loanOneBook(
                    panel.mtf_BorrowerName.getText(),
                    panel.mtf_BookID.getText());
            panel.mta.append(outputTitle + "\n" + output);
        }
        else if(index == 3 && src.equals(panel.mb_Run)){
            String outputTitle = libApp.returnOneBook(
                    panel.mtf_BookID.getText());
            panel.mta.append(outputTitle + "\n" + output);
        }
        else if(src.equals(panel.mb_FloanD)){
            panel.mta.append(libApp.displayBookForLoan()
                    + "\n-------------------------------------------------\n");
        }
        else if(src.equals(panel.mb_OloanD)){
            panel.mta.append(libApp.displayBookOnLoan()
                    + "\n-------------------------------------------------\n");
        }
        else if (src.equals(panel.mb_Clear)){
            panel.mtf_BorrowerName.setText("");
            panel.mtf_BookTitle.setText("");
            panel.mtf_BookAuthor.setText("");
            panel.mtf_BookID.setText("");
        }
    }
}