package FrontGUI;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

/**
 * LibraryApplication의 패널
 *
 * @author (11팀)
 * @version (2025.12.04)
 */
public class MyPanel extends JPanel
{
    protected JLabel ml_BorrowerName, ml_BookTitle, ml_BookAuthor, ml_BookID;
    protected JTextField mtf_BorrowerName, mtf_BookTitle, mtf_BookAuthor, mtf_BookID;
    protected JButton mb_Run, mb_Clear, mb_FloanD, mb_OloanD;
    protected JTextArea mta;
    protected String[] selectUC = {"이용자 등록","책 등록","대출","반납"};
    protected JComboBox mcb_selectUC;

    public MyPanel(){
        setLayout(new BorderLayout(10, 10));
        
        JPanel topPanel = new JPanel();
        JLabel titleLabel = new JLabel("선문대학교 중앙도서관");
        topPanel.setBackground(Color.LIGHT_GRAY);
        topPanel.add(titleLabel);
        this.add(topPanel, BorderLayout.NORTH);
        
        ml_BorrowerName = new JLabel("이용자 이름");
        ml_BookTitle = new JLabel("책 제목");
        ml_BookAuthor = new JLabel("책 저자이름");
        ml_BookID = new JLabel("책 등록번호");

        mtf_BorrowerName = new JTextField("예: 홍길동", 20);
        mtf_BookTitle = new JTextField("예: 소프트웨어설계론", 20);
        mtf_BookAuthor= new JTextField("예: (c)sHwang", 20);
        mtf_BookID = new JTextField("예: 11111111", 20);
        
        mcb_selectUC = new JComboBox(selectUC);
        
        mta = new JTextArea(20, 28);
        mta.setText("선문대학교 중앙도서관에 오신것을 환영합니다!\n"
        + "----------------------------------------------------------\n");
        this.add(new JScrollPane(mta));
        
        JPanel bottomPanel = new JPanel(new GridLayout(4, 2, 5, 5));

        bottomPanel.add(ml_BorrowerName);
        bottomPanel.add(mtf_BorrowerName);
        bottomPanel.add(ml_BookTitle);
        bottomPanel.add(mtf_BookTitle);
        bottomPanel.add(ml_BookAuthor);
        bottomPanel.add(mtf_BookAuthor);
        bottomPanel.add(ml_BookID);
        bottomPanel.add(mtf_BookID);
        bottomPanel.add(new JLabel("선택"));
        bottomPanel.add(mcb_selectUC);

        mb_Run = new JButton("실행");
        mb_FloanD = new JButton("대출가능");
        mb_OloanD = new JButton("대출중");
        mb_Clear = new JButton("Clear");
        
        bottomPanel.add(mb_Run);
        bottomPanel.add(mb_FloanD);
        bottomPanel.add(mb_OloanD);
        bottomPanel.add(mb_Clear);
        
        add(bottomPanel, BorderLayout.SOUTH);
        
        MyAListener Alistener = new MyAListener(this);

        mcb_selectUC.addActionListener(Alistener);
        mb_Run.addActionListener(Alistener);
        mb_FloanD.addActionListener(Alistener);
        mb_OloanD.addActionListener(Alistener);
        mb_Clear.addActionListener(Alistener);

    }
}