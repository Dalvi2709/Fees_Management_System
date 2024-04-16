
package com.mycompany.fees_managmentsystem;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

public class EditCourse_Page extends javax.swing.JFrame {

    public EditCourse_Page() {
        initComponents();
        setRecordToTableEditCourse();
    }
   DefaultTableModel model;
    public void setRecordToTableEditCourse(){
         try
      {
        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection con =DriverManager.getConnection("jdbc:mysql://localhost:3306/fees_management_system?zeroDateTimeBehavior=CONVERT_TO_NULL", "root", "asdf123");
        PreparedStatement pst = con.prepareStatement("select * from coursedetails ");
       ResultSet rs = pst.executeQuery();
       while(rs.next()){
           String Courseid = rs.getString("id");
           String  Coursename = rs.getString("CName");
           String  Coursecost = rs.getString("Cost");
           
           
           Object[] obj = {Courseid,Coursename,Coursecost};
           
           model =  (DefaultTableModel)Edit_course_Table.getModel();
           model.addRow(obj);
           
           
       }
       
    }
      catch(Exception e)
    {
        e.printStackTrace();
        e.toString();
        System.out.println(e.getMessage());
    }
    }
    
    
    public void addCourse(int id , String cname , int cost ){
        
          try
      {
        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection con =DriverManager.getConnection("jdbc:mysql://localhost:3306/fees_management_system?zeroDateTimeBehavior=CONVERT_TO_NULL", "root", "asdf123");
        PreparedStatement pst = con.prepareStatement("insert into coursedetails values(?,?,?) ");
       
           pst.setInt(1, id);
           pst.setString(2, cname);
           pst.setInt(3, cost);
           int rowCount = pst.executeUpdate();
           if(rowCount==1){
                 JOptionPane.showMessageDialog(this , "Course added Succesfully ");
                 clearTable();
                 setRecordToTableEditCourse();
           }else{
                JOptionPane.showMessageDialog(this , "Course Insertion Failed ");
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
        DefaultTableModel model = (DefaultTableModel)Edit_course_Table.getModel();
         model.setRowCount(0);
    }
    
    
    public void update(int id , String cname , int cost) {
             try
      {
        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection con =DriverManager.getConnection("jdbc:mysql://localhost:3306/fees_management_system?zeroDateTimeBehavior=CONVERT_TO_NULL", "root", "asdf123");
        PreparedStatement pst = con.prepareStatement("update coursedetails set cname = ? , cost = ? where id =? ");
       
         
           pst.setString(1, cname);
           pst.setInt(2, cost);
             pst.setInt(3, id);
           int rowCount = pst.executeUpdate();
           if(rowCount==1){
                 JOptionPane.showMessageDialog(this , "Course Updation Succesfully ");
                 clearTable();
                 setRecordToTableEditCourse();
           }else{
                JOptionPane.showMessageDialog(this , "Course Updation Failed ");
           }
      
    }
      catch(Exception e)
    {
        e.printStackTrace();
        e.toString();
        System.out.println(e.getMessage());
    }
    }
            
    public void delete(int id) {
             try
      {
        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection con =DriverManager.getConnection("jdbc:mysql://localhost:3306/fees_management_system?zeroDateTimeBehavior=CONVERT_TO_NULL", "root", "asdf123");
        PreparedStatement pst = con.prepareStatement("delete from  coursedetails where id = ? ");
       
             pst.setInt(1, id);
           int rowCount = pst.executeUpdate();
           if(rowCount==1){
                 JOptionPane.showMessageDialog(this , "Course Deleted Succesfully ");
                 clearTable();
                 setRecordToTableEditCourse();
           }else{
                JOptionPane.showMessageDialog(this , "Course Deletion Failed ");
           }
      
    }
      catch(Exception e)
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
        jScrollPane1 = new javax.swing.JScrollPane();
        Edit_course_Table = new javax.swing.JTable();
        txt_course_id = new javax.swing.JTextField();
        txt_course_name = new javax.swing.JTextField();
        txt_course_price = new javax.swing.JTextField();
        lbl_course_id = new javax.swing.JLabel();
        lbl_course_price = new javax.swing.JLabel();
        lbl_course_name = new javax.swing.JLabel();
        btn_add = new javax.swing.JButton();
        btn_update = new javax.swing.JButton();
        btn_delete = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jSeparator7 = new javax.swing.JSeparator();
        jLabel1 = new javax.swing.JLabel();

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
                .addContainerGap(194, Short.MAX_VALUE))
        );

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 270, 670));

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        Edit_course_Table.setBackground(new java.awt.Color(204, 204, 204));
        Edit_course_Table.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        Edit_course_Table.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Course ID", "Course Name ", "Course  Price"
            }
        ));
        Edit_course_Table.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Edit_course_TableMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(Edit_course_Table);

        txt_course_id.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        txt_course_id.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        txt_course_id.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_course_idActionPerformed(evt);
            }
        });

        txt_course_name.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        txt_course_name.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        txt_course_name.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_course_nameActionPerformed(evt);
            }
        });

        txt_course_price.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        txt_course_price.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        txt_course_price.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_course_priceActionPerformed(evt);
            }
        });

        lbl_course_id.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        lbl_course_id.setForeground(new java.awt.Color(51, 0, 51));
        lbl_course_id.setText("Course ID :");

        lbl_course_price.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        lbl_course_price.setText("Course Price");

        lbl_course_name.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        lbl_course_name.setText("Course Name :");

        btn_add.setBackground(new java.awt.Color(102, 102, 102));
        btn_add.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btn_add.setForeground(new java.awt.Color(255, 255, 255));
        btn_add.setIcon(new javax.swing.ImageIcon("C:\\Users\\Lenovo\\Desktop\\my icons\\add2.png")); // NOI18N
        btn_add.setText(" ADD");
        btn_add.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_addActionPerformed(evt);
            }
        });

        btn_update.setBackground(new java.awt.Color(102, 102, 102));
        btn_update.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btn_update.setForeground(new java.awt.Color(255, 255, 255));
        btn_update.setIcon(new javax.swing.ImageIcon("C:\\Users\\Lenovo\\Desktop\\my icons\\update.png")); // NOI18N
        btn_update.setText("UPDATE");
        btn_update.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_updateActionPerformed(evt);
            }
        });

        btn_delete.setBackground(new java.awt.Color(102, 102, 102));
        btn_delete.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btn_delete.setForeground(new java.awt.Color(255, 255, 255));
        btn_delete.setIcon(new javax.swing.ImageIcon("C:\\Users\\Lenovo\\Desktop\\my icons\\delete.png")); // NOI18N
        btn_delete.setText("DELETE");
        btn_delete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_deleteActionPerformed(evt);
            }
        });

        jLabel4.setIcon(new javax.swing.ImageIcon("C:\\Users\\Lenovo\\Desktop\\my icons\\diet1.jpg")); // NOI18N

        jLabel5.setFont(new java.awt.Font("Arial Black", 1, 48)); // NOI18N
        jLabel5.setText("DNYANSHREE");

        jLabel6.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        jLabel6.setText("            Institute of Engineering and Technology");

        jLabel7.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel7.setText("   A/P. : Sonavadi-Gajavadi, Sajjangad Road, Tal.& Dist. Satara - 415013  ");

        jLabel8.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel8.setText("Maharashtra State , India. DTE Code : EN 6797");

        jLabel3.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel3.setText("            Raosaheb Wangde Master Charitable Trust");

        jSeparator7.setBackground(new java.awt.Color(0, 0, 0));
        jSeparator7.setForeground(new java.awt.Color(0, 0, 0));
        jSeparator7.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 4));
        jSeparator7.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        jLabel1.setFont(new java.awt.Font("Segoe UI Black", 1, 36)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(102, 51, 0));
        jLabel1.setText("      Edit Course");
        jLabel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(160, 160, 160)
                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(30, 30, 30)
                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 340, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 390, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 370, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 450, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(70, 70, 70)
                        .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 310, javax.swing.GroupLayout.PREFERRED_SIZE))))
            .addComponent(jSeparator7, javax.swing.GroupLayout.PREFERRED_SIZE, 900, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 316, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(287, 287, 287))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 759, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(66, 66, 66))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(jPanel2Layout.createSequentialGroup()
                                    .addComponent(lbl_course_price, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(18, 18, 18)
                                    .addComponent(txt_course_price, javax.swing.GroupLayout.PREFERRED_SIZE, 260, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(jPanel2Layout.createSequentialGroup()
                                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(lbl_course_name, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGroup(jPanel2Layout.createSequentialGroup()
                                            .addGap(3, 3, 3)
                                            .addComponent(lbl_course_id, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                    .addGap(18, 18, 18)
                                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(txt_course_id, javax.swing.GroupLayout.PREFERRED_SIZE, 260, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(txt_course_name, javax.swing.GroupLayout.PREFERRED_SIZE, 260, javax.swing.GroupLayout.PREFERRED_SIZE))))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(btn_add, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(39, 39, 39)
                                .addComponent(btn_update)
                                .addGap(31, 31, 31)
                                .addComponent(btn_delete)))
                        .addGap(238, 238, 238))))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addGap(0, 0, 0)
                        .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, 0)
                        .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, 0)
                        .addComponent(jLabel7)
                        .addGap(0, 0, 0)
                        .addComponent(jLabel8)))
                .addGap(10, 10, 10)
                .addComponent(jSeparator7, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(24, 24, 24)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbl_course_id, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txt_course_id, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lbl_course_name, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txt_course_name, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(17, 17, 17)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txt_course_price, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbl_course_price, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(13, 13, 13)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btn_add)
                    .addComponent(btn_update)
                    .addComponent(btn_delete))
                .addContainerGap(79, Short.MAX_VALUE))
        );

        getContentPane().add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 0, 900, 660));

        setSize(new java.awt.Dimension(1188, 693));
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

    private void btn_search_recordMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_search_recordMouseClicked
    Search_Details_page s =  new Search_Details_page();
          s.setVisible(true);
          this.dispose();
    }//GEN-LAST:event_btn_search_recordMouseClicked

    private void btn_deleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_deleteActionPerformed

        int id = Integer.parseInt(txt_course_id.getText());

        delete(id);
    }//GEN-LAST:event_btn_deleteActionPerformed

    private void btn_updateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_updateActionPerformed

        int id = Integer.parseInt(txt_course_id.getText());
        String cname = txt_course_name.getText();
        int cost = Integer.parseInt(txt_course_price.getText());

        update(id,cname,cost);
    }//GEN-LAST:event_btn_updateActionPerformed

    private void btn_addActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_addActionPerformed
        int id = Integer.parseInt(txt_course_id.getText());
        String cname = txt_course_name.getText();
        int cost = Integer.parseInt(txt_course_price.getText());

        addCourse(id,cname,cost);
    }//GEN-LAST:event_btn_addActionPerformed

    private void txt_course_priceActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_course_priceActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_course_priceActionPerformed

    private void txt_course_nameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_course_nameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_course_nameActionPerformed

    private void txt_course_idActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_course_idActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_course_idActionPerformed

    private void Edit_course_TableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Edit_course_TableMouseClicked

        int rowNo = Edit_course_Table.getSelectedRow();
        TableModel model = Edit_course_Table.getModel();

        txt_course_id.setText(model.getValueAt(rowNo, 0).toString());
        txt_course_name.setText((String)model.getValueAt(rowNo, 1));
        txt_course_price.setText(model.getValueAt(rowNo, 2).toString());

    }//GEN-LAST:event_Edit_course_TableMouseClicked


    public static void main(String args[]) {
   java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new EditCourse_Page().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable Edit_course_Table;
    private javax.swing.JButton btn_add;
    private javax.swing.JButton btn_back;
    private javax.swing.JButton btn_course_list;
    private javax.swing.JButton btn_delete;
    private javax.swing.JButton btn_edit_course;
    private javax.swing.JButton btn_home;
    private javax.swing.JButton btn_logout;
    private javax.swing.JButton btn_search_record;
    private javax.swing.JButton btn_update;
    private javax.swing.JButton btn_view_records;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator7;
    private javax.swing.JLabel lbl_course_id;
    private javax.swing.JLabel lbl_course_name;
    private javax.swing.JLabel lbl_course_price;
    private javax.swing.JTextField txt_course_id;
    private javax.swing.JTextField txt_course_name;
    private javax.swing.JTextField txt_course_price;
    // End of variables declaration//GEN-END:variables
}
