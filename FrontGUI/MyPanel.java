package FrontGUI;
import javax.swing.*;
import java.awt.*;
import CoreEngine.*;
/**
 * LibraryApplication의 패널 (Event Listener Object 겸용)
 *
 * @author (11팀)
 * @version (2025.11.29)
 */
public class MyPanel extends JPanel
{
    protected JLabel ml_BorrowerName, ml_BookTitle, ml_BookAuthor, ml_BookID;
    protected JTextField mtf_BorrowerName, mtf_BookTitle, mtf_BookAuthor, mtf_BookID;
    protected JButton mb_Run, mb_Clear, mb_FloanD, mb_OloanD;
    protected JTextArea mta;
    protected String[] selectUC = {"이용자 등록","책 등록","대출", "반납"};
    protected JComboBox mcb_selectUC;

    public MyPanel(){
        ml_BorrowerName = new JLabel("이용자 이름");
        ml_BookTitle = new JLabel("책 제목");
        ml_BookAuthor = new JLabel("책 저자이름");
        ml_BookID = new JLabel("책 등록번호");

        mtf_BorrowerName = new JTextField("Your Name", 20);
        mtf_BookTitle = new JTextField("Book Title", 20);
        mtf_BookAuthor= new JTextField("Book Author", 20);
        mtf_BookID = new JTextField("Book ID", 20);

        mcb_selectUC = new JComboBox(selectUC);
        
        
        mta = new JTextArea("선문대학교 중앙도서관에 오신것을 환영합니다!" + "\n" 
        + "-------------------------------------------------" + "\n",20, 28);
        this.add(new JScrollPane(mta));

        this.add(ml_BorrowerName);
        this.add(mtf_BorrowerName);
        this.add(ml_BookTitle);
        this.add(mtf_BookTitle);
        this.add(ml_BookAuthor);
        this.add(mtf_BookAuthor);
        this.add(ml_BookID);
        this.add(mtf_BookID);
        this.add(new JLabel("선택"));
        this.add(mcb_selectUC);

        mb_Run = new JButton("실행");
        this.add(mb_Run);
        mb_FloanD = new JButton("대출가능한 책");
        this.add(mb_FloanD);
        mb_OloanD = new JButton("대출중인 책");
        this.add(mb_OloanD);
        mb_Clear = new JButton("Clear");
        this.add(mb_Clear);

        MyListener listener = new MyListener(this);
        mcb_selectUC.addActionListener(listener);
        mb_Run.addActionListener(listener);
        mb_FloanD.addActionListener(listener);
        mb_OloanD.addActionListener(listener);
        mb_Clear.addActionListener(listener);

    }
    
}