package FrontGUI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import CoreEngine.*;
/**
 * LibraryApplication의 패널(Event Listener Object의 역할 겸용)
 *
 * @author (11팀)
 * @version (2025.11.29)
 */
public class MyPanel extends JPanel implements ActionListener
{
    protected JPanel buttonPanel;
    protected JPanel outputDataPanel;

    protected JLabel ml_BorrowerName, ml_BookTitle, ml_BookAuthor, ml_BookID;
    protected JTextField mtf_BorrowerName, mtf_BookTitle, mtf_BookAuthor, mtf_BookID;
    protected JButton mb_Run, mb_Clear, mb_FloanD, mb_OloanD;
    protected JTextArea mta;
    protected String[] selectUC = {"이용자 등록","책 등록","대출", "반납"};
    protected JComboBox mcb_selectUC;
    protected String output = "";
    protected int index;

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

        mtf_BorrowerName = new JTextField("Your Name", 20);
        mtf_BookTitle = new JTextField("Book Title", 20);
        mtf_BookAuthor= new JTextField("Book Author", 20);
        mtf_BookID = new JTextField("Book ID", 20);

        mcb_selectUC = new JComboBox(selectUC);
        
        
        mta = new JTextArea(20, 28);
        mta.setText("선문대학교 중앙도서관입니다\n"
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
        bottomPanel.add(mb_Run);
        mb_FloanD = new JButton("대출가능한 책");
        bottomPanel.add(mb_FloanD);
        mb_OloanD = new JButton("대출중인 책");
        bottomPanel.add(mb_OloanD);
        mb_Clear = new JButton("Clear");
        bottomPanel.add(mb_Clear);
        
        add(bottomPanel, BorderLayout.SOUTH);

        mcb_selectUC.addActionListener(this);
        mb_Run.addActionListener(this);
        mb_FloanD.addActionListener(this);
        mb_OloanD.addActionListener(this);
        mb_Clear.addActionListener(this);

    }

    public void actionPerformed(ActionEvent e){
        LibraryApplication libApp = new LibraryApplication("선문대학교 중앙도서관");

        if(e.getSource().equals(mcb_selectUC)){
            JComboBox cb = (JComboBox)e.getSource();
            index = cb.getSelectedIndex(); 

            output = selectUC[index] + "자 : " + mtf_BorrowerName.getText() + "\n"
            + selectUC[index] + "책 제목 : " + mtf_BookTitle.getText() + "\n"
            + selectUC[index] + "책 저자 : " + mtf_BookAuthor.getText() + "\n"
            + selectUC[index] + "책 등록번호 : " + mtf_BookID.getText() + "\n"
            + "-------------------------------------------------" + "\n";
        }   

        if(index == 0 && e.getSource().equals(mb_Run)){
            String outputTitle = libApp.registerOneBorrower(mtf_BorrowerName.getText());
            mta.append(outputTitle + "\n"+ "-------------------------------------------------" + "\n");
        }
        else if(index == 1 && e.getSource().equals(mb_Run)){
            String outputTitle = libApp.registerOneBook(mtf_BookTitle.getText(),mtf_BookAuthor.getText(),mtf_BookID.getText());
            mta.append(outputTitle + "\n"+ "-------------------------------------------------" + "\n");        
        }
        else if(index == 2 && e.getSource().equals(mb_Run)){
            String outputTitle = libApp.loanOneBook(mtf_BorrowerName.getText(), mtf_BookID.getText());
            mta.append(outputTitle + "\n" + output);        
        }
        else if(index == 3 && e.getSource().equals(mb_Run)){
            String outputTitle = libApp.returnOneBook(mtf_BookID.getText());
            mta.append(outputTitle + "\n" + output);
        }
        else if(e.getSource().equals(mb_FloanD)){
            mta.append(libApp.displayBookForLoan()+ "\n"+ "-------------------------------------------------" + "\n");
        }
        else if(e.getSource().equals(mb_OloanD)){
            mta.append(libApp.displayBookOnLoan()+ "\n"+ "-------------------------------------------------" + "\n");
        }
        else if(e.getSource().equals(mb_Clear)){
            mtf_BorrowerName.setText("");
            mtf_BookTitle.setText("");
            mtf_BookAuthor.setText("");
            mtf_BookID.setText("");
        }

    }
}