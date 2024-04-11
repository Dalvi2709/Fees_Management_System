package com.mycompany.fees_managmentsystem;

import java.io.File;
import java.io.FileOutputStream;
import java.sql.Connection;
import java.sql.Date;

import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.MessageFormat;
import java.text.SimpleDateFormat;
import java.util.Set;
import java.util.TreeMap;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;

public class Genrate_report_page extends javax.swing.JFrame {
    String cname;
     SimpleDateFormat dateFormat;
     String fromdate;
     String todate;
     
  DefaultTableModel model;
    public Genrate_report_page() {
        initComponents();
         fillcomboboxofcourse();
//        setRecordToTableReportCourse();
       clearTable();
//       exportToExcle();
    }

    
    public void setRecordToTableReportCourse(){
           
       try
      {
             cname = ComboBox_course.getSelectedItem().toString();
             dateFormat = new SimpleDateFormat("YYYY-MM-dd");
             fromdate = dateFormat.format(DateChooser_from.getDate()).toString();
             todate = dateFormat.format(DateChooser_to.getDate()).toString();  
             
            Float amountTotal = 0.0f;
              
        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection con =DriverManager.getConnection("jdbc:mysql://localhost:3306/fees_management_system?zeroDateTimeBehavior=CONVERT_TO_NULL", "root", "asdf123");
        PreparedStatement pst = con.prepareStatement("select * from fees_details where dates between '"+fromdate+"' and '"+todate+"' and course_name = '"+cname+"' ");

         ResultSet rs = pst.executeQuery();
       
       while(rs.next()){
           
           String recieptNo = rs.getString("reciept_no");
           String  studentname = rs.getString("student_name");
           String  rollno = rs.getString("roll_no");
           String modeOfPyament = rs.getString("payment_mode");
           String coursename = rs.getString("course_name");
           Date date = rs.getDate("dates");
           float  Coursecost = rs.getFloat("amount");
           String  remark = rs.getString("remark");
           
          amountTotal = amountTotal  + Coursecost;
           Object[] obj = {recieptNo,studentname,rollno,modeOfPyament,coursename,date,Coursecost,remark };
           
           model =  (DefaultTableModel)table_report_data.getModel();
           model.addRow(obj);        
           
       } 
//       lbl_course_selected.setText(cname);
       lbl_total_amount.setText(amountTotal.toString());
    }
      catch(Exception e)
    {
        e.printStackTrace();
        e.toString();
        System.out.println(e.getMessage());
    }
    }
    
    
         public void fillcomboboxofcourse(){
           try
    {
      Class.forName("com.mysql.cj.jdbc.Driver");
      Connection con =DriverManager.getConnection("jdbc:mysql://localhost:3306/fees_management_system?zeroDateTimeBehavior=CONVERT_TO_NULL", "root", "asdf123");
      PreparedStatement pst = con.prepareStatement("select CName from coursedetails");
      ResultSet rs = pst.executeQuery();
      while(rs.next()){
        ComboBox_course.addItem(rs.getString("CName"));
      }
      
   }
      catch(Exception e)
    {
        e.printStackTrace();
        e.toString();
        System.out.println(e.getMessage());
    }
     }
         
           public void clearTable(){
        DefaultTableModel model = (DefaultTableModel)table_report_data.getModel();
         model.setRowCount(1);
    }
    
     public void exportToExcle()
     {
       HSSFWorkbook wb = new  HSSFWorkbook();
       HSSFSheet ws = wb.createSheet();
          model =  (DefaultTableModel)table_report_data.getModel();

       TreeMap<String,Object[]> map=new TreeMap<>();
         map.put ("0", new Object [] {model. getColumnName (0) , model.getColumnName (1), model.getColumnName (2),
             model.getColumnName (3), model.getColumnName (4), model.getColumnName (5) , model.getColumnName (6), 
             model.getColumnName (7)});
         
         
         for (int i =1; i < model.getRowCount(); i++) {
         map.put(Integer.toString(i), new Object [] {model.getValueAt (i, 0),
             model.getValueAt (i, 1), model.getValueAt (i, 2) ,model.getValueAt (i, 3), model.getValueAt (i, 4),
             model.getValueAt (i, 5),model.getValueAt (i, 6),model.getValueAt (i, 7)});
              }
               Set<String> id = map.keySet();
                HSSFRow fRow;
                int rowId = 0;
                for (String key : id){
                fRow = ws.createRow (rowId++);
                Object [] value= map.get(key);
                int cellId = 0;
                for (Object object : value) {
                    
                    HSSFCell cell = fRow.createCell(cellId++);
                    cell.setCellValue(object.toString());
                }
                }
                
                try(FileOutputStream fos = new FileOutputStream(new File(txt_file_path.getText()))){
                    
                    wb.write(fos);
                      JOptionPane.showMessageDialog(this , "File  Exported Succesfully: "+txt_file_path.getText());
                    
                }catch(Exception e)
                    {
                        e.printStackTrace();
                        e.toString();
                        System.out.println(e.getMessage());
                    }          
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
        jLabel2 = new javax.swing.JLabel();
        ComboBox_course = new javax.swing.JComboBox<>();
        jLabel5 = new javax.swing.JLabel();
        DateChooser_to = new com.toedter.calendar.JDateChooser();
        DateChooser_from = new com.toedter.calendar.JDateChooser();
        btn_excel = new javax.swing.JButton();
        btn_submit = new javax.swing.JButton();
        txt_file_path = new javax.swing.JTextField();
        btn_print1 = new javax.swing.JButton();
        btn_brows = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        table_report_data = new javax.swing.JTable();
        jPanel3 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        lbl_total_amount = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jSeparator7 = new javax.swing.JSeparator();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(173, 239, 209));
        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

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
                .addContainerGap(21, Short.MAX_VALUE)
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
                .addContainerGap(234, Short.MAX_VALUE))
        );

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 270, 710));

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel2.setBackground(new java.awt.Color(255, 255, 255));
        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(102, 51, 0));
        jLabel2.setText("  Generate  Report ");
        jLabel2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel2.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 160, 340, 40));

        ComboBox_course.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        ComboBox_course.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        ComboBox_course.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ComboBox_courseActionPerformed(evt);
            }
        });
        jPanel2.add(ComboBox_course, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 210, 270, 30));

        jLabel5.setBackground(new java.awt.Color(255, 255, 255));
        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel5.setText("From ");
        jPanel2.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 210, -1, -1));

        DateChooser_to.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel2.add(DateChooser_to, new org.netbeans.lib.awtextra.AbsoluteConstraints(720, 210, 130, 30));

        DateChooser_from.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel2.add(DateChooser_from, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 210, 130, 30));

        btn_excel.setBackground(new java.awt.Color(102, 102, 255));
        btn_excel.setFont(new java.awt.Font("Verdana", 1, 20)); // NOI18N
        btn_excel.setForeground(new java.awt.Color(255, 255, 255));
        btn_excel.setText("Excel");
        btn_excel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_excelActionPerformed(evt);
            }
        });
        jPanel2.add(btn_excel, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 250, 100, 35));

        btn_submit.setBackground(new java.awt.Color(102, 102, 255));
        btn_submit.setFont(new java.awt.Font("Verdana", 1, 20)); // NOI18N
        btn_submit.setForeground(new java.awt.Color(255, 255, 255));
        btn_submit.setIcon(new javax.swing.ImageIcon("C:\\Users\\Lenovo\\Desktop\\my icons\\signup.png")); // NOI18N
        btn_submit.setText("Submit");
        btn_submit.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn_submitMouseClicked(evt);
            }
        });
        btn_submit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_submitActionPerformed(evt);
            }
        });
        jPanel2.add(btn_submit, new org.netbeans.lib.awtextra.AbsoluteConstraints(720, 250, 150, 35));

        txt_file_path.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        txt_file_path.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_file_pathActionPerformed(evt);
            }
        });
        jPanel2.add(txt_file_path, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 250, 280, 30));

        btn_print1.setBackground(new java.awt.Color(102, 102, 102));
        btn_print1.setFont(new java.awt.Font("Verdana", 1, 20)); // NOI18N
        btn_print1.setForeground(new java.awt.Color(255, 255, 255));
        btn_print1.setText("Print");
        btn_print1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_print1ActionPerformed(evt);
            }
        });
        jPanel2.add(btn_print1, new org.netbeans.lib.awtextra.AbsoluteConstraints(710, 620, 90, 35));

        btn_brows.setBackground(new java.awt.Color(102, 102, 255));
        btn_brows.setFont(new java.awt.Font("Verdana", 1, 20)); // NOI18N
        btn_brows.setForeground(new java.awt.Color(255, 255, 255));
        btn_brows.setText("Brows");
        btn_brows.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_browsActionPerformed(evt);
            }
        });
        jPanel2.add(btn_brows, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 250, 120, 35));

        table_report_data.setBackground(new java.awt.Color(204, 204, 204));
        table_report_data.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null}
            },
            new String [] {
                "Reciept No", "Student Name", "Roll No", "Mode Of Paymet", "Course", "date", "amount", "remark"
            }
        ));
        jScrollPane1.setViewportView(table_report_data);

        jPanel2.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 290, 860, 290));

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));
        jPanel3.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 3, true));
        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel3.setBackground(new java.awt.Color(255, 255, 255));
        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel3.setText("Total Amount ");
        jPanel3.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 30, 130, 40));

        lbl_total_amount.setBackground(new java.awt.Color(255, 255, 255));
        lbl_total_amount.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        lbl_total_amount.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel3.add(lbl_total_amount, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 40, 240, 30));

        jPanel2.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 590, 390, 90));

        jLabel6.setBackground(new java.awt.Color(0, 0, 0));
        jLabel6.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel6.setText("to ");
        jPanel2.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(690, 210, -1, -1));

        jLabel7.setBackground(new java.awt.Color(255, 255, 255));
        jLabel7.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel7.setText("Select Course");
        jPanel2.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 210, -1, -1));

        jLabel8.setIcon(new javax.swing.ImageIcon("C:\\Users\\Lenovo\\Desktop\\my icons\\diet1.jpg")); // NOI18N
        jPanel2.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 10, 130, 130));

        jLabel10.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel10.setText("            Raosaheb Wangde Master Charitable Trust");
        jPanel2.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 10, 340, 20));

        jLabel11.setFont(new java.awt.Font("Arial Black", 1, 48)); // NOI18N
        jLabel11.setText("DNYANSHREE");
        jPanel2.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 30, 390, 40));

        jLabel12.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        jLabel12.setText("            Institute of Engineering and Technology");
        jPanel2.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 70, 370, 20));

        jLabel13.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel13.setText("   A/P. : Sonavadi-Gajavadi, Sajjangad Road, Tal.& Dist. Satara - 415013  ");
        jPanel2.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 90, 450, -1));

        jLabel14.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel14.setText("Maharashtra State , India. DTE Code : EN 6797");
        jPanel2.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 110, 310, 20));

        jSeparator7.setBackground(new java.awt.Color(0, 0, 0));
        jSeparator7.setForeground(new java.awt.Color(0, 0, 0));
        jSeparator7.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 4));
        jSeparator7.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jPanel2.add(jSeparator7, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 150, 900, 10));

        getContentPane().add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 0, 900, 710));

        setSize(new java.awt.Dimension(1189, 723));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btn_homeMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_homeMouseClicked
        // TODO add your handling code here:
        home_page hp = new home_page();
        hp.show();
        this.dispose();
    }//GEN-LAST:event_btn_homeMouseClicked

    private void btn_homeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_homeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btn_homeActionPerformed

    private void btn_search_recordMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_search_recordMouseClicked
        Search_Details_page s =  new Search_Details_page();
        s.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btn_search_recordMouseClicked

    private void btn_search_recordActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_search_recordActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btn_search_recordActionPerformed

    private void btn_edit_courseMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_edit_courseMouseClicked
        EditCourse_Page e = new EditCourse_Page();
        e.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btn_edit_courseMouseClicked

    private void btn_edit_courseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_edit_courseActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btn_edit_courseActionPerformed

    private void btn_course_listActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_course_listActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btn_course_listActionPerformed

    private void btn_view_recordsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_view_recordsActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btn_view_recordsActionPerformed

    private void btn_backMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_backMouseClicked
        // TODO add your handling code here:
        home_page hp = new home_page();
        hp.show();
        this.dispose();
    }//GEN-LAST:event_btn_backMouseClicked

    private void btn_backActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_backActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btn_backActionPerformed

    private void btn_logoutMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_logoutMouseClicked
        // TODO add your handling code here:
        login_page  l1 = new login_page();
        l1.show();
        this.dispose();
    }//GEN-LAST:event_btn_logoutMouseClicked

    private void btn_logoutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_logoutActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btn_logoutActionPerformed

    private void ComboBox_courseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ComboBox_courseActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_ComboBox_courseActionPerformed

    private void btn_excelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_excelActionPerformed
              exportToExcle();

    }//GEN-LAST:event_btn_excelActionPerformed

    private void btn_submitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_submitActionPerformed
       clearTable();
        setRecordToTableReportCourse();
    }//GEN-LAST:event_btn_submitActionPerformed

    private void txt_file_pathActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_file_pathActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_file_pathActionPerformed

    private void btn_print1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_print1ActionPerformed

      SimpleDateFormat Date_Format = new SimpleDateFormat("YYYY-MM-dd"); 
        String fromdate=  Date_Format.format(DateChooser_from.getDate());
      String todate=  Date_Format.format(DateChooser_to.getDate());
       
        MessageFormat header=new MessageFormat("Report From "+fromdate+" To " +todate);
        MessageFormat footer=new MessageFormat("page{0,number,integer}");
        try {
             table_report_data.print(JTable.PrintMode.FIT_WIDTH, header, footer);
            
        } catch (Exception e) {
            e.getMessage();
        } 

    }//GEN-LAST:event_btn_print1ActionPerformed

    private void btn_browsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_browsActionPerformed
       JFileChooser filechooser = new JFileChooser();
       filechooser.showOpenDialog(this);
//          SimpleDateFormat dateFormat= new SimpleDateFormat("YYYY-MM-dd"); 
//          String date =  dateFormat.format(new Date());
       
        try {
                File f = filechooser.getSelectedFile();
                String path = f.getAbsolutePath();
             path = path+".xls";
                txt_file_path.setText(path);
                
            } catch (Exception e) {
                e.getMessage();
            } 

       
    }//GEN-LAST:event_btn_browsActionPerformed

    private void btn_submitMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_submitMouseClicked
       
    }//GEN-LAST:event_btn_submitMouseClicked

    public static void main(String args[]) {

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Genrate_report_page().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> ComboBox_course;
    private com.toedter.calendar.JDateChooser DateChooser_from;
    private com.toedter.calendar.JDateChooser DateChooser_to;
    private javax.swing.JButton btn_back;
    private javax.swing.JButton btn_brows;
    private javax.swing.JButton btn_course_list;
    private javax.swing.JButton btn_edit_course;
    private javax.swing.JButton btn_excel;
    private javax.swing.JButton btn_home;
    private javax.swing.JButton btn_logout;
    private javax.swing.JButton btn_print1;
    private javax.swing.JButton btn_search_record;
    private javax.swing.JButton btn_submit;
    private javax.swing.JButton btn_view_records;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator7;
    private javax.swing.JLabel lbl_total_amount;
    private javax.swing.JTable table_report_data;
    private javax.swing.JTextField txt_file_path;
    // End of variables declaration//GEN-END:variables

 
}
