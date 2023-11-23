
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
        jSeparator1 = new javax.swing.JSeparator();
        jPanel3 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(14, 58, 83));
        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        btn_home.setBackground(new java.awt.Color(255, 204, 153));
        btn_home.setFont(new java.awt.Font("Verdana", 1, 24)); // NOI18N
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

        btn_search_record.setBackground(new java.awt.Color(255, 204, 153));
        btn_search_record.setFont(new java.awt.Font("Verdana", 1, 24)); // NOI18N
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

        btn_edit_course.setBackground(new java.awt.Color(255, 204, 153));
        btn_edit_course.setFont(new java.awt.Font("Verdana", 1, 24)); // NOI18N
        btn_edit_course.setText("Edit Course");
        btn_edit_course.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_edit_courseActionPerformed(evt);
            }
        });

        btn_course_list.setBackground(new java.awt.Color(255, 204, 153));
        btn_course_list.setFont(new java.awt.Font("Verdana", 1, 24)); // NOI18N
        btn_course_list.setText("Course List");
        btn_course_list.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_course_listActionPerformed(evt);
            }
        });

        btn_view_records.setBackground(new java.awt.Color(255, 204, 153));
        btn_view_records.setFont(new java.awt.Font("Verdana", 1, 24)); // NOI18N
        btn_view_records.setText("View Records");
        btn_view_records.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_view_recordsActionPerformed(evt);
            }
        });

        btn_back.setBackground(new java.awt.Color(255, 204, 153));
        btn_back.setFont(new java.awt.Font("Verdana", 1, 24)); // NOI18N
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

        btn_logout.setBackground(new java.awt.Color(255, 204, 153));
        btn_logout.setFont(new java.awt.Font("Verdana", 1, 24)); // NOI18N
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
                .addContainerGap(154, Short.MAX_VALUE))
        );

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 270, 630));

        jPanel2.setBackground(new java.awt.Color(173, 239, 209));

        Edit_course_Table.setBackground(new java.awt.Color(255, 204, 204));
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

        txt_course_id.setBackground(new java.awt.Color(255, 255, 204));
        txt_course_id.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        txt_course_id.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        txt_course_id.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_course_idActionPerformed(evt);
            }
        });

        txt_course_name.setBackground(new java.awt.Color(255, 255, 204));
        txt_course_name.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        txt_course_name.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        txt_course_name.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_course_nameActionPerformed(evt);
            }
        });

        txt_course_price.setBackground(new java.awt.Color(255, 255, 204));
        txt_course_price.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        txt_course_price.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        txt_course_price.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_course_priceActionPerformed(evt);
            }
        });

        lbl_course_id.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        lbl_course_id.setForeground(new java.awt.Color(51, 0, 51));
        lbl_course_id.setText("Course ID");

        lbl_course_price.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        lbl_course_price.setText("Course Price");

        lbl_course_name.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        lbl_course_name.setText("Course Name");

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

        jSeparator1.setForeground(new java.awt.Color(0, 0, 0));

        jPanel3.setBackground(new java.awt.Color(51, 0, 51));

        jLabel1.setBackground(new java.awt.Color(255, 255, 255));
        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setIcon(new javax.swing.ImageIcon("C:\\Users\\Lenovo\\Desktop\\my icons\\edit2.png")); // NOI18N
        jLabel1.setText(" Edit Course");
        jLabel1.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 305, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(353, 353, 353))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 74, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 482, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(lbl_course_name, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(txt_course_name, javax.swing.GroupLayout.PREFERRED_SIZE, 260, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(btn_add, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(lbl_course_id, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(lbl_course_price, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(btn_update)
                                .addGap(18, 18, 18)
                                .addComponent(btn_delete))
                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(txt_course_id, javax.swing.GroupLayout.DEFAULT_SIZE, 260, Short.MAX_VALUE)
                                .addComponent(txt_course_price)))))
                .addContainerGap(113, Short.MAX_VALUE))
            .addComponent(jSeparator1, javax.swing.GroupLayout.Alignment.TRAILING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 21, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(77, 77, 77)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txt_course_id, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lbl_course_id, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(36, 36, 36)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txt_course_name, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lbl_course_name, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(40, 40, 40)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txt_course_price, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lbl_course_price, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(63, 63, 63)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btn_add)
                            .addComponent(btn_update)
                            .addComponent(btn_delete)))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(78, 78, 78))
        );

        getContentPane().add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 0, 1050, 630));

        setSize(new java.awt.Dimension(1329, 640));
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

    private void txt_course_idActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_course_idActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_course_idActionPerformed

    private void txt_course_nameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_course_nameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_course_nameActionPerformed

    private void txt_course_priceActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_course_priceActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_course_priceActionPerformed

    private void btn_addActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_addActionPerformed
        int id = Integer.parseInt(txt_course_id.getText());
        String cname = txt_course_name.getText();
        int cost = Integer.parseInt(txt_course_price.getText());
 
         addCourse(id,cname,cost);
    }//GEN-LAST:event_btn_addActionPerformed

    private void btn_updateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_updateActionPerformed
       
         int id = Integer.parseInt(txt_course_id.getText());
        String cname = txt_course_name.getText();
        int cost = Integer.parseInt(txt_course_price.getText());
 
         update(id,cname,cost);
    }//GEN-LAST:event_btn_updateActionPerformed

    private void btn_deleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_deleteActionPerformed
        
         int id = Integer.parseInt(txt_course_id.getText());
         
        delete(id);
    }//GEN-LAST:event_btn_deleteActionPerformed

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
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JLabel lbl_course_id;
    private javax.swing.JLabel lbl_course_name;
    private javax.swing.JLabel lbl_course_price;
    private javax.swing.JTextField txt_course_id;
    private javax.swing.JTextField txt_course_name;
    private javax.swing.JTextField txt_course_price;
    // End of variables declaration//GEN-END:variables
}
