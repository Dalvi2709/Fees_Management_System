package com.mycompany.fees_managmentsystem;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import javax.swing.JOptionPane;
import java.text.NumberFormat;
import java.util.Scanner;

public class Add_fees_page extends javax.swing.JFrame {

    
    
//     Constructor Class
    
    public Add_fees_page() {
        initComponents();
        displayCashFirst();
        fillcomboboxofcourse();
        int r =getrecieptNo();
        r++;
        txt_receipt_no.setText(Integer.toString(r));
    }
    
//     Main Database Method Insserting Data in Table
    
       public String InsertFeesData(){
                   String status="";
             int receiptno = Integer.parseInt(txt_receipt_no.getText());
             String stname = txt_reciver_name.getText();
             String rollno = txt_roll_no.getText();
             String paymentmode = combo_mode_of_payment.getSelectedItem().toString();
             String chequeno =txt_cheque_no1.getText();
             String transactionno =txt_transiction_no.getText();
             String ddno = txt_dd_no.getText();
             String bankname =txt_bank_name.getText();
             String coursename = Combo_coursemain.getSelectedItem().toString();
             float totalamount = Float.parseFloat(txt_total.getText());
             SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
             String date = dateFormat.format(datechooser.getDate());
            float amount = Float.parseFloat(txt_amount.getText());
             String totalinwords = txt_total_in_words.getText();
             String remark = txt_remark.getText();
             int year1 = Integer.parseInt(fromyear.getText());
             int year2 = Integer.parseInt(toyear.getText());

   try
      {
        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection con =DriverManager.getConnection("jdbc:mysql://localhost:3306/fees_management_system?zeroDateTimeBehavior=CONVERT_TO_NULL", "root", "asdf123");
        PreparedStatement pst = con.prepareStatement("insert into fees_details values (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
                pst.setInt(1,receiptno);
                pst.setString(2, stname);
                pst.setString(3,rollno);
                pst.setString(4, paymentmode);
                pst.setString(5, chequeno);
                pst.setString(6, transactionno);
                pst.setString(7,  ddno);
                pst.setString(8, bankname);
                pst.setString(9,  coursename);
                pst.setFloat(10, totalamount);
                pst.setString(11, date);
                pst.setFloat(12, amount);
                pst.setString(13,totalinwords);
                pst.setString(14,remark);
                pst.setInt(15,year1);
                pst.setInt(16,year2);

    int c = pst.executeUpdate();
    if(c==1)
      {
          status="success";
      }
    else
      {
            status = "failed";
      }
    }
      catch(Exception e)
    {
        e.printStackTrace();
        e.toString();
        System.out.println(e.getMessage());
    }
       return status;
    }   
    
    
//       AutoIncrement Receipt No Method Start
    
         public int getrecieptNo()
         {
            int rno = 0;
   try
      {
      Class.forName("com.mysql.cj.jdbc.Driver");
      Connection con =DriverManager.getConnection("jdbc:mysql://localhost:3306/fees_management_system?zeroDateTimeBehavior=CONVERT_TO_NULL", "root", "asdf123");
      PreparedStatement pst = con.prepareStatement("select max(reciept_no) from fees_details");
      ResultSet rs = pst.executeQuery();
        if(rs.next()==true)
        {
          rno = rs.getInt(1);
        }
      
      }
       catch(Exception e)
      {
        e.printStackTrace();
        e.toString();
        System.out.println(e.getMessage());
      }
           return rno;
     }
    
//         Autofill Course Method
         
     public void fillcomboboxofcourse(){
           try
    {
      Class.forName("com.mysql.cj.jdbc.Driver");
      Connection con =DriverManager.getConnection("jdbc:mysql://localhost:3306/fees_management_system?zeroDateTimeBehavior=CONVERT_TO_NULL", "root", "asdf123");
      PreparedStatement pst = con.prepareStatement("select CName from coursedetails");
     ResultSet rs = pst.executeQuery();
      while(rs.next()){
         Combo_coursemain.addItem(rs.getString("CName"));
      }
      
 }
      catch(Exception e)
    {
        e.printStackTrace();
        e.toString();
        System.out.println(e.getMessage());
    }
     }
     


public class NumberToWordsConverter {

	public static final String[] units = { "", "One", "Two", "Three", "Four",
			"Five", "Six", "Seven", "Eight", "Nine", "Ten", "Eleven", "Twelve",
			"Thirteen", "Fourteen", "Fifteen", "Sixteen", "Seventeen",
			"Eighteen", "Nineteen" };

	public static final String[] tens = { 
			"", 		// 0
			"",		// 1
			"Twenty", 	// 2
			"Thirty", 	// 3
			"Forty", 	// 4
			"Fifty", 	// 5
			"Sixty", 	// 6
			"Seventy",	// 7
			"Eighty", 	// 8
			"Ninety" 	// 9
	};

	public static String convert(final int n) {
		if (n < 0) 
                {
			return "Minus " + convert(-n);
		}

		if (n < 20) 
                {
			return units[n];
		}

		if (n < 100) {
			return tens[n / 10] + ((n % 10 != 0) ? " " : "") + units[n % 10];
		}

		if (n < 1000) {
			return units[n / 100] + " Hundred" + ((n % 100 != 0) ? " " : "") + convert(n % 100);
		}

		if (n < 100000) {
			return convert(n / 1000) + " Thousand" + ((n % 10000 != 0) ? " " : "") + convert(n % 1000);
		}

		if (n < 10000000) {
			return convert(n / 100000) + " Lakh" + ((n % 100000 != 0) ? " " : "") + convert(n % 100000);
		}

		return convert(n / 10000000) + " Crore" + ((n % 10000000 != 0) ? " " : "") + convert(n % 10000000);
	}

	public static void main(final String[] args) {
            Scanner sc=new Scanner(System.in);
            System.out.println("Enter the Amount : ");
		int n=sc.nextInt();

		
		System.out.println( convert(n)+ " Only");

	
	}
}
     
//   Display lables Method
     
     public void displayCashFirst(){
        
        lbl_dd_no.setVisible(false);
        lbl_transiction_no.setVisible(false);
        txt_dd_no.setVisible(false);
        txt_transiction_no.setVisible(false);
        lbl_bank__name.setVisible(false);
        txt_bank_name.setVisible(false);
           txt_cheque_no1.setVisible(false);
         lbl_cheque_no1.setVisible(false);
         txt_reciver_name.setVisible(true);
         lbl_reciver_name.setVisible(true);
    }
    
//     Validation of print button 
     
     boolean validation(){
        if( txt_reciver_name.getText().equals("")){
                    JOptionPane.showMessageDialog(this , "please enter Reciver Name ","Warning",JOptionPane.WARNING_MESSAGE);
                    return false;
                }
        if(datechooser.getDate()==(null)){
                    JOptionPane.showMessageDialog(this , "please enter Date ","Warning",JOptionPane.WARNING_MESSAGE);
                    return false;
                }
          if( txt_amount.getText().equals("")||txt_amount.getText().matches("[0-9]+") == false){
                    JOptionPane.showMessageDialog(this , "please enter Valid Amount ","Warning",JOptionPane.WARNING_MESSAGE);
                    return false;
                }
          
          if( txt_roll_no.getText().equals("")||txt_amount.getText().matches("[0-9]+") == false){
                    JOptionPane.showMessageDialog(this , "please enter Roll Number ","Warning",JOptionPane.WARNING_MESSAGE);
                    return false;
                }
            if( fromyear.getText().equals("")||txt_amount.getText().matches("[0-9]+") == false){
                    JOptionPane.showMessageDialog(this , "please enter Year ","Warning",JOptionPane.WARNING_MESSAGE);
                    return false;
                }
            if( toyear.getText().equals("")||txt_amount.getText().matches("[0-9]+") == false){
                    JOptionPane.showMessageDialog(this , "please enter Year ","Warning",JOptionPane.WARNING_MESSAGE);
                    return false;
                }
             if(  txt_total.getText().equals("")||txt_amount.getText().matches("[0-9]+") == false){
                    JOptionPane.showMessageDialog(this , "please enter Total Amount ","Warning",JOptionPane.WARNING_MESSAGE);
                    return false;
                }  
      if(combo_mode_of_payment.getSelectedItem().toString().equalsIgnoreCase("cheque")){
              if( txt_cheque_no1.getText().equals("")){
                    JOptionPane.showMessageDialog(this , "please enter cheque Number ","Warning",JOptionPane.WARNING_MESSAGE);
                    return false;
                }
              if( txt_bank_name.getText().equals("")){
                    JOptionPane.showMessageDialog(this , "please enter Bank Name","Warning",JOptionPane.WARNING_MESSAGE);
                    return false;
                }
          }
      if(combo_mode_of_payment.getSelectedItem().toString().equalsIgnoreCase("DD")){
              if( txt_dd_no.getText().equals("")){
                    JOptionPane.showMessageDialog(this , "please enter DD Number ","Warning",JOptionPane.WARNING_MESSAGE);
                    return false;
                }
              if( txt_bank_name.getText().equals("")){
                    JOptionPane.showMessageDialog(this , "please enter Bank Name","Warning",JOptionPane.WARNING_MESSAGE);
                    return false;
                }
          }
       if(combo_mode_of_payment.getSelectedItem().toString().equalsIgnoreCase("phonepay")){
              if( txt_transiction_no.getText().equals("")){
                    JOptionPane.showMessageDialog(this , "please enter Transiction Number ","Warning",JOptionPane.WARNING_MESSAGE);
                    return false;
                }
          }
                return true;   
     }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        btn_home = new javax.swing.JButton();
        btn_search_record = new javax.swing.JButton();
        btn_edit_course = new javax.swing.JButton();
        btn_course_list = new javax.swing.JButton();
        btn_view_records = new javax.swing.JButton();
        btn_back = new javax.swing.JButton();
        btn_logout = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jTextField2 = new javax.swing.JTextField();
        jSeparator7 = new javax.swing.JSeparator();
        jSeparator6 = new javax.swing.JSeparator();
        jTextField1 = new javax.swing.JTextField();
        Combo_coursemain = new javax.swing.JComboBox<>();
        txt_receipt_no = new javax.swing.JTextField();
        lbl_receipt_no = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        txt_reciver_name = new javax.swing.JTextField();
        lbl_reciver_name = new javax.swing.JLabel();
        lbl_date = new javax.swing.JLabel();
        datechooser = new com.toedter.calendar.JDateChooser();
        lbl_roll_no2 = new javax.swing.JLabel();
        fromyear = new javax.swing.JTextField();
        lbl_roll_no = new javax.swing.JLabel();
        toyear = new javax.swing.JTextField();
        jSeparator5 = new javax.swing.JSeparator();
        jLabel10 = new javax.swing.JLabel();
        txt_amount = new javax.swing.JTextField();
        txt_total = new javax.swing.JTextField();
        jLabel14 = new javax.swing.JLabel();
        jSeparator4 = new javax.swing.JSeparator();
        jLabel16 = new javax.swing.JLabel();
        txt_total_in_words = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        txt_remark = new javax.swing.JTextArea();
        jLabel13 = new javax.swing.JLabel();
        lbl_bank__name = new javax.swing.JLabel();
        txt_bank_name = new javax.swing.JTextField();
        lbl_dd_no = new javax.swing.JLabel();
        txt_dd_no = new javax.swing.JTextField();
        lbl_cheque_no1 = new javax.swing.JLabel();
        txt_cheque_no1 = new javax.swing.JTextField();
        lbl_transiction_no = new javax.swing.JLabel();
        txt_transiction_no = new javax.swing.JTextField();
        lbl_mode_of_payment = new javax.swing.JLabel();
        combo_mode_of_payment = new javax.swing.JComboBox<>();
        lbl_roll_no1 = new javax.swing.JLabel();
        txt_roll_no = new javax.swing.JTextField();
        btn_print = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(173, 239, 209));
        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));

        btn_home.setBackground(new java.awt.Color(0, 51, 51));
        btn_home.setFont(new java.awt.Font("Verdana", 1, 24)); // NOI18N
        btn_home.setForeground(new java.awt.Color(255, 255, 255));
        btn_home.setText("Home");
        btn_home.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn_homeMouseClicked(evt);
            }
        });
        btn_home.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_homeActionPerformed(evt);
            }
        });

        btn_search_record.setBackground(new java.awt.Color(0, 51, 51));
        btn_search_record.setFont(new java.awt.Font("Verdana", 1, 24)); // NOI18N
        btn_search_record.setForeground(new java.awt.Color(255, 255, 255));
        btn_search_record.setText("Search Record");
        btn_search_record.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn_search_recordMouseClicked(evt);
            }
        });
        btn_search_record.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_search_recordActionPerformed(evt);
            }
        });

        btn_edit_course.setBackground(new java.awt.Color(0, 51, 51));
        btn_edit_course.setFont(new java.awt.Font("Verdana", 1, 24)); // NOI18N
        btn_edit_course.setForeground(new java.awt.Color(255, 255, 255));
        btn_edit_course.setText("Edit Course");
        btn_edit_course.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn_edit_courseMouseClicked(evt);
            }
        });
        btn_edit_course.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_edit_courseActionPerformed(evt);
            }
        });

        btn_course_list.setBackground(new java.awt.Color(0, 51, 51));
        btn_course_list.setFont(new java.awt.Font("Verdana", 1, 24)); // NOI18N
        btn_course_list.setForeground(new java.awt.Color(255, 255, 255));
        btn_course_list.setText("Course List");
        btn_course_list.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_course_listActionPerformed(evt);
            }
        });

        btn_view_records.setBackground(new java.awt.Color(0, 51, 51));
        btn_view_records.setFont(new java.awt.Font("Verdana", 1, 24)); // NOI18N
        btn_view_records.setForeground(new java.awt.Color(255, 255, 255));
        btn_view_records.setText("View Records");
        btn_view_records.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_view_recordsActionPerformed(evt);
            }
        });

        btn_back.setBackground(new java.awt.Color(0, 51, 51));
        btn_back.setFont(new java.awt.Font("Verdana", 1, 24)); // NOI18N
        btn_back.setForeground(new java.awt.Color(255, 255, 255));
        btn_back.setText("Back");
        btn_back.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn_backMouseClicked(evt);
            }
        });
        btn_back.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_backActionPerformed(evt);
            }
        });

        btn_logout.setBackground(new java.awt.Color(0, 51, 51));
        btn_logout.setFont(new java.awt.Font("Verdana", 1, 24)); // NOI18N
        btn_logout.setForeground(new java.awt.Color(255, 255, 255));
        btn_logout.setText("Logout");
        btn_logout.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn_logoutMouseClicked(evt);
            }
        });
        btn_logout.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_logoutActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(9, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btn_view_records, javax.swing.GroupLayout.PREFERRED_SIZE, 229, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_back, javax.swing.GroupLayout.PREFERRED_SIZE, 229, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_logout, javax.swing.GroupLayout.PREFERRED_SIZE, 229, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(btn_edit_course, javax.swing.GroupLayout.PREFERRED_SIZE, 228, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btn_course_list, javax.swing.GroupLayout.PREFERRED_SIZE, 229, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btn_search_record, javax.swing.GroupLayout.PREFERRED_SIZE, 229, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btn_home, javax.swing.GroupLayout.PREFERRED_SIZE, 229, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(50, 50, 50)
                .addComponent(btn_home, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(26, 26, 26)
                .addComponent(btn_search_record, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(32, 32, 32)
                .addComponent(btn_edit_course, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(32, 32, 32)
                .addComponent(btn_course_list, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(29, 29, 29)
                .addComponent(btn_view_records, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(29, 29, 29)
                .addComponent(btn_back, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(31, 31, 31)
                .addComponent(btn_logout, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(192, Short.MAX_VALUE))
        );

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 260, 670));

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel4.setIcon(new javax.swing.ImageIcon("C:\\Users\\Lenovo\\Desktop\\my icons\\diet1.jpg")); // NOI18N
        jPanel2.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 10, 130, 130));

        jLabel3.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel3.setText("            Raosaheb Wangde Master Charitable Trust");
        jPanel2.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 10, 340, 20));

        jLabel2.setFont(new java.awt.Font("Arial Black", 1, 48)); // NOI18N
        jLabel2.setText("DNYANSHREE");
        jPanel2.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 30, 390, 40));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        jLabel1.setText("            Institute of Engineering and Technology");
        jPanel2.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 70, 370, 20));

        jLabel5.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel5.setText("   A/P. : Sonavadi-Gajavadi, Sajjangad Road, Tal.& Dist. Satara - 415013  ");
        jPanel2.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 90, 450, -1));

        jLabel7.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel7.setText("Maharashtra State , India. DTE Code : EN 6797");
        jPanel2.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 110, 310, 20));

        jTextField2.setBackground(new java.awt.Color(0, 0, 0));
        jTextField2.setFont(new java.awt.Font("Arial Black", 1, 14)); // NOI18N
        jTextField2.setForeground(new java.awt.Color(255, 255, 255));
        jTextField2.setText("DIPLOMA / DEGREE");
        jTextField2.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jPanel2.add(jTextField2, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 140, -1, 30));

        jSeparator7.setBackground(new java.awt.Color(0, 0, 0));
        jSeparator7.setForeground(new java.awt.Color(0, 0, 0));
        jSeparator7.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 4));
        jSeparator7.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jPanel2.add(jSeparator7, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 150, 320, 10));

        jSeparator6.setBackground(new java.awt.Color(0, 0, 0));
        jSeparator6.setForeground(new java.awt.Color(0, 0, 0));
        jSeparator6.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 4));
        jSeparator6.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jPanel2.add(jSeparator6, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 150, 310, 10));

        jTextField1.setBackground(new java.awt.Color(0, 0, 0));
        jTextField1.setFont(new java.awt.Font("Arial Black", 3, 22)); // NOI18N
        jTextField1.setForeground(new java.awt.Color(255, 255, 255));
        jTextField1.setText(" RECEIPT ");
        jTextField1.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
        jPanel2.add(jTextField1, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 180, 130, -1));

        Combo_coursemain.setFont(new java.awt.Font("Arial", 1, 16)); // NOI18N
        Combo_coursemain.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        Combo_coursemain.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Combo_coursemainActionPerformed(evt);
            }
        });
        jPanel2.add(Combo_coursemain, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 270, 290, 30));

        txt_receipt_no.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        txt_receipt_no.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        txt_receipt_no.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_receipt_noActionPerformed(evt);
            }
        });
        jPanel2.add(txt_receipt_no, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 190, 150, 30));

        lbl_receipt_no.setFont(new java.awt.Font("Segoe UI", 1, 15)); // NOI18N
        lbl_receipt_no.setText("Receipt No :  ");
        jPanel2.add(lbl_receipt_no, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 190, -1, -1));

        jLabel20.setFont(new java.awt.Font("Segoe UI", 1, 15)); // NOI18N
        jLabel20.setText("Course :");
        jPanel2.add(jLabel20, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 270, 80, -1));

        txt_reciver_name.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        txt_reciver_name.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        txt_reciver_name.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        txt_reciver_name.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_reciver_nameActionPerformed(evt);
            }
        });
        jPanel2.add(txt_reciver_name, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 230, 350, -1));

        lbl_reciver_name.setFont(new java.awt.Font("Segoe UI", 1, 15)); // NOI18N
        lbl_reciver_name.setText("Student Name :");
        jPanel2.add(lbl_reciver_name, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 230, -1, -1));

        lbl_date.setFont(new java.awt.Font("Segoe UI", 1, 15)); // NOI18N
        lbl_date.setText("Date :");
        jPanel2.add(lbl_date, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 190, 50, 30));

        datechooser.setBackground(new java.awt.Color(255, 255, 204));
        datechooser.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jPanel2.add(datechooser, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 190, 140, 30));

        lbl_roll_no2.setFont(new java.awt.Font("Segoe UI", 1, 15)); // NOI18N
        lbl_roll_no2.setText("From year");
        jPanel2.add(lbl_roll_no2, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 270, -1, -1));

        fromyear.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        fromyear.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        fromyear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                fromyearActionPerformed(evt);
            }
        });
        jPanel2.add(fromyear, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 270, 60, 30));

        lbl_roll_no.setFont(new java.awt.Font("Segoe UI", 1, 15)); // NOI18N
        lbl_roll_no.setText("to ");
        jPanel2.add(lbl_roll_no, new org.netbeans.lib.awtextra.AbsoluteConstraints(630, 270, -1, -1));

        toyear.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        toyear.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        toyear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                toyearActionPerformed(evt);
            }
        });
        jPanel2.add(toyear, new org.netbeans.lib.awtextra.AbsoluteConstraints(660, 270, 50, 30));

        jSeparator5.setBackground(new java.awt.Color(0, 0, 0));
        jSeparator5.setForeground(new java.awt.Color(0, 0, 0));
        jSeparator5.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jPanel2.add(jSeparator5, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 310, 790, 20));

        jLabel10.setFont(new java.awt.Font("Segoe UI", 1, 15)); // NOI18N
        jLabel10.setText("Amount");
        jPanel2.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(630, 320, 80, -1));

        txt_amount.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        txt_amount.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        txt_amount.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_amountActionPerformed(evt);
            }
        });
        jPanel2.add(txt_amount, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 360, 180, 30));

        txt_total.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        txt_total.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel2.add(txt_total, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 460, 190, 30));

        jLabel14.setFont(new java.awt.Font("Segoe UI", 1, 15)); // NOI18N
        jLabel14.setText("Total :");
        jPanel2.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 470, 50, 20));

        jSeparator4.setBackground(new java.awt.Color(0, 0, 0));
        jSeparator4.setForeground(new java.awt.Color(0, 0, 0));
        jSeparator4.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jPanel2.add(jSeparator4, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 440, 230, 10));

        jLabel16.setFont(new java.awt.Font("Segoe UI", 1, 15)); // NOI18N
        jLabel16.setText("Total in words :");
        jPanel2.add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 450, 120, -1));

        txt_total_in_words.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        txt_total_in_words.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        txt_total_in_words.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_total_in_wordsActionPerformed(evt);
            }
        });
        jPanel2.add(txt_total_in_words, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 440, 330, 30));

        txt_remark.setColumns(20);
        txt_remark.setFont(new java.awt.Font("Arial", 0, 16)); // NOI18N
        txt_remark.setLineWrap(true);
        txt_remark.setRows(5);
        txt_remark.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jScrollPane1.setViewportView(txt_remark);

        jPanel2.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 330, 260, 90));

        jLabel13.setFont(new java.awt.Font("Segoe UI", 1, 15)); // NOI18N
        jLabel13.setText("Remark :");
        jPanel2.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 330, 80, -1));

        lbl_bank__name.setFont(new java.awt.Font("Segoe UI", 1, 15)); // NOI18N
        lbl_bank__name.setText("Bank Name :");
        jPanel2.add(lbl_bank__name, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 540, -1, -1));

        txt_bank_name.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        txt_bank_name.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        txt_bank_name.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_bank_nameActionPerformed(evt);
            }
        });
        jPanel2.add(txt_bank_name, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 540, 240, 30));

        lbl_dd_no.setFont(new java.awt.Font("Segoe UI", 1, 15)); // NOI18N
        lbl_dd_no.setText("DD No : ");
        jPanel2.add(lbl_dd_no, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 590, -1, -1));

        txt_dd_no.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        txt_dd_no.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        txt_dd_no.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_dd_noActionPerformed(evt);
            }
        });
        jPanel2.add(txt_dd_no, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 590, 200, -1));

        lbl_cheque_no1.setFont(new java.awt.Font("Segoe UI", 1, 15)); // NOI18N
        lbl_cheque_no1.setText("Cheque No :");
        jPanel2.add(lbl_cheque_no1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 590, -1, 20));

        txt_cheque_no1.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        txt_cheque_no1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        txt_cheque_no1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_cheque_no1ActionPerformed(evt);
            }
        });
        jPanel2.add(txt_cheque_no1, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 590, 200, -1));

        lbl_transiction_no.setFont(new java.awt.Font("Segoe UI", 1, 15)); // NOI18N
        lbl_transiction_no.setText("Transiction No :");
        jPanel2.add(lbl_transiction_no, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 590, -1, 20));

        txt_transiction_no.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        txt_transiction_no.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        txt_transiction_no.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_transiction_noActionPerformed(evt);
            }
        });
        jPanel2.add(txt_transiction_no, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 590, 200, -1));

        lbl_mode_of_payment.setFont(new java.awt.Font("Segoe UI", 1, 15)); // NOI18N
        lbl_mode_of_payment.setText("Mode Of Payment :");
        jPanel2.add(lbl_mode_of_payment, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 490, -1, -1));

        combo_mode_of_payment.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        combo_mode_of_payment.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "CASH", "DD", "PhonePay", "Cheque" }));
        combo_mode_of_payment.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        combo_mode_of_payment.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                combo_mode_of_paymentActionPerformed(evt);
            }
        });
        jPanel2.add(combo_mode_of_payment, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 490, 180, 30));

        lbl_roll_no1.setFont(new java.awt.Font("Segoe UI", 1, 15)); // NOI18N
        lbl_roll_no1.setText("Roll No :");
        jPanel2.add(lbl_roll_no1, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 230, 70, 30));

        txt_roll_no.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        txt_roll_no.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        txt_roll_no.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_roll_noActionPerformed(evt);
            }
        });
        jPanel2.add(txt_roll_no, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 230, 130, 30));

        btn_print.setBackground(new java.awt.Color(102, 102, 102));
        btn_print.setFont(new java.awt.Font("Verdana", 1, 24)); // NOI18N
        btn_print.setForeground(new java.awt.Color(255, 255, 255));
        btn_print.setText("Print");
        btn_print.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_printActionPerformed(evt);
            }
        });
        jPanel2.add(btn_print, new org.netbeans.lib.awtextra.AbsoluteConstraints(640, 580, -1, 30));

        getContentPane().add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 0, 790, 670));

        setSize(new java.awt.Dimension(1062, 704));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btn_homeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_homeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btn_homeActionPerformed

    private void btn_search_recordActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_search_recordActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btn_search_recordActionPerformed

    private void btn_edit_courseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_edit_courseActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btn_edit_courseActionPerformed

    private void btn_course_listActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_course_listActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btn_course_listActionPerformed

    private void btn_view_recordsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_view_recordsActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btn_view_recordsActionPerformed

    private void btn_backActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_backActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btn_backActionPerformed

    private void btn_logoutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_logoutActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btn_logoutActionPerformed

    private void txt_receipt_noActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_receipt_noActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_receipt_noActionPerformed

    private void txt_transiction_noActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_transiction_noActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_transiction_noActionPerformed

    private void txt_bank_nameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_bank_nameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_bank_nameActionPerformed

    private void txt_reciver_nameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_reciver_nameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_reciver_nameActionPerformed

    private void txt_total_in_wordsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_total_in_wordsActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_total_in_wordsActionPerformed
 
    private void txt_amountActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_amountActionPerformed
        // TODO add your handling code here:
       String a=txt_total.getText();
      float amt = Float.parseFloat(a);
      float t = amt;
        txt_total.setText (Float.toString(t));
        txt_total_in_words.setText(NumberToWordsConverter.convert((int)t));
    }//GEN-LAST:event_txt_amountActionPerformed

    private void txt_dd_noActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_dd_noActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_dd_noActionPerformed
 // Which lbl is showing on action of combo box
    private void combo_mode_of_paymentActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_combo_mode_of_paymentActionPerformed
       
            if(combo_mode_of_payment.getSelectedIndex()==0)
        {
             lbl_dd_no.setVisible(false);
            lbl_transiction_no.setVisible(false);
            txt_dd_no.setVisible(false);
            txt_transiction_no.setVisible(false);
            lbl_bank__name.setVisible(false);
            txt_bank_name.setVisible(false);
            txt_cheque_no1.setVisible(false);
            lbl_cheque_no1.setVisible(false);
            txt_reciver_name.setVisible(true);
            lbl_reciver_name.setVisible(true);
        }
        if(combo_mode_of_payment.getSelectedIndex()==1)
        {
            lbl_dd_no.setVisible(true);
            txt_dd_no.setVisible(true);
            lbl_bank__name.setVisible(true);
            txt_bank_name.setVisible(true);
            txt_cheque_no1.setVisible(false);
            lbl_cheque_no1.setVisible(false);
            lbl_transiction_no.setVisible(false);
            txt_transiction_no.setVisible(false);
            txt_reciver_name.setVisible(true);
            lbl_reciver_name.setVisible(true);
        }
    
        if(combo_mode_of_payment.getSelectedIndex()==2)
        {
            lbl_dd_no.setVisible(false);
            lbl_transiction_no.setVisible(true);
            txt_dd_no.setVisible(false);
            txt_transiction_no.setVisible(true);
            lbl_bank__name.setVisible(false);
            txt_bank_name.setVisible(false);
            txt_cheque_no1.setVisible(false);
            lbl_cheque_no1.setVisible(false);
            txt_reciver_name.setVisible(true);
            lbl_reciver_name.setVisible(true);        
        }
        if(combo_mode_of_payment.getSelectedIndex()==3)
        {
            lbl_dd_no.setVisible(false);
            lbl_transiction_no.setVisible(false);
            txt_dd_no.setVisible(false);
            txt_transiction_no.setVisible(false);
            lbl_bank__name.setVisible(true);
            txt_bank_name.setVisible(true);
            txt_cheque_no1.setVisible(true);
            lbl_cheque_no1.setVisible(true);
            txt_reciver_name.setVisible(true);
            lbl_reciver_name.setVisible(true);   
        }
    }//GEN-LAST:event_combo_mode_of_paymentActionPerformed

    private void btn_homeMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_homeMouseClicked
        // TODO add your handling code here:
          home_page hp = new home_page();
           hp.show();
           this.dispose();
    }//GEN-LAST:event_btn_homeMouseClicked

    private void btn_backMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_backMouseClicked
        // TODO add your handling code here:
          home_page hp = new home_page();
           hp.show();
           this.dispose();
    }//GEN-LAST:event_btn_backMouseClicked

    private void btn_logoutMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_logoutMouseClicked
        // TODO add your handling code here:
         login_page  l1 = new login_page();
      l1.show();
      this.dispose();
    }//GEN-LAST:event_btn_logoutMouseClicked

    private void txt_cheque_no1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_cheque_no1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_cheque_no1ActionPerformed

    private void Combo_coursemainActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Combo_coursemainActionPerformed
        // TODO add your handling code here:
//        txt_course_head.setText( Combo_coursemain.getSelectedItem().toString());
    }//GEN-LAST:event_Combo_coursemainActionPerformed

    private void toyearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_toyearActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_toyearActionPerformed

    private void txt_roll_noActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_roll_noActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_roll_noActionPerformed

    private void fromyearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_fromyearActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_fromyearActionPerformed

    private void btn_search_recordMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_search_recordMouseClicked
       Search_Details_page s =  new Search_Details_page();
          s.setVisible(true);
          this.dispose();
    }//GEN-LAST:event_btn_search_recordMouseClicked

    private void btn_edit_courseMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_edit_courseMouseClicked
         EditCourse_Page e = new EditCourse_Page();
        e.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btn_edit_courseMouseClicked

    private void btn_printActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_printActionPerformed
        // TODO add your handling code here:
          if(validation()==true){
          String s= InsertFeesData();
       if(s.equals("success")){
              JOptionPane.showMessageDialog(this , "Records Inserted Succesfully");
                Print_reciept p1 = new Print_reciept();
                p1.setVisible(true);
                this.dispose();
        }else{
            JOptionPane.showMessageDialog(this , "Records Updatation failed");
        }
        }
    }//GEN-LAST:event_btn_printActionPerformed

    public static void main(String args[]) {

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Add_fees_page().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> Combo_coursemain;
    private javax.swing.JButton btn_back;
    private javax.swing.JButton btn_course_list;
    private javax.swing.JButton btn_edit_course;
    private javax.swing.JButton btn_home;
    private javax.swing.JButton btn_logout;
    private javax.swing.JButton btn_print;
    private javax.swing.JButton btn_search_record;
    private javax.swing.JButton btn_view_records;
    private javax.swing.JComboBox<String> combo_mode_of_payment;
    private com.toedter.calendar.JDateChooser datechooser;
    private javax.swing.JTextField fromyear;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator4;
    private javax.swing.JSeparator jSeparator5;
    private javax.swing.JSeparator jSeparator6;
    private javax.swing.JSeparator jSeparator7;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JLabel lbl_bank__name;
    private javax.swing.JLabel lbl_cheque_no1;
    private javax.swing.JLabel lbl_date;
    private javax.swing.JLabel lbl_dd_no;
    private javax.swing.JLabel lbl_mode_of_payment;
    private javax.swing.JLabel lbl_receipt_no;
    private javax.swing.JLabel lbl_reciver_name;
    private javax.swing.JLabel lbl_roll_no;
    private javax.swing.JLabel lbl_roll_no1;
    private javax.swing.JLabel lbl_roll_no2;
    private javax.swing.JLabel lbl_transiction_no;
    private javax.swing.JTextField toyear;
    private javax.swing.JTextField txt_amount;
    private javax.swing.JTextField txt_bank_name;
    private javax.swing.JTextField txt_cheque_no1;
    private javax.swing.JTextField txt_dd_no;
    private javax.swing.JTextField txt_receipt_no;
    private javax.swing.JTextField txt_reciver_name;
    private javax.swing.JTextArea txt_remark;
    private javax.swing.JTextField txt_roll_no;
    private javax.swing.JTextField txt_total;
    private javax.swing.JTextField txt_total_in_words;
    private javax.swing.JTextField txt_transiction_no;
    // End of variables declaration//GEN-END:variables
}
