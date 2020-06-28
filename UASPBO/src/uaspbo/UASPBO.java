/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
packageUASPBO
        import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.sql.ResultSet;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public UASPBO {
private void koneksi(){
try {
Class.forName("com.mysql.jdbc.Driver");
con=DriverManager.getConnection("jdbc:mysql://localhost/Perpustakaan","root", "");
} catch (SQLException ex) {
JOptionPane.showMessageDialog(null, e);
}
}
private void tabel(){
DefaultTableModel tb= new DefaultTableModel();
// Memberi nama pada setiap kolom tabel
tb.addColumn("No.Buku");
tb.addColumn("Judul Buku");
tb.addColumn("Pengarang");
tb.addColumn("Tahun");
tb.addColumn("Penerbit");
tabel.setModel(tb);
try{
// Mengambil data dari database
res=stat.executeQuery("select * from perpus");

while (res.next())
{
// Mengambil data dari database berdasarkan nama kolom pada tabel
// Lalu di tampilkan ke dalam JTable
tb.addRow(new Object[]{
res.getInt("no_buku"),
res.getString("judul_buku"),
res.getString("pengarang"),
res.getInt("tahun"),
res.getString("penerbit")
});
}

}catch (Exception e){
}
}
private void kosongkan(){
no.setText("");
judul.setText("");
pengarang.setText("");
tahun.setText("");
penerbit.setText("");
no.requestFocus();
}

private void ClearTabel(){
int cb=tabel.getRowCount();
int cc=tabel.getColumnCount();
for (int i=0;i<cb;i++)
for (int j=0;j<cc;j++)
{tabel.setValueAt(null, i, j);
}
}

    }
    try {
stat.executeUpdate("insert into perpus values ("
+ "'" + no.getText()+"',"
+ "'" + judul.getText()+"',"
+ "'" + pengarang.getText()+ "',"
+ "'" + tahun.getText()+ "',"
+ "'" + penerbit.getText()+ "')"
);


kosongkan();//Mengosongkan text field setelah berhasil menyimpan data
tabel();// Menampilkan isi tabel
JOptionPane.showMessageDialog(null, "Data Berhasil Disimpan...");
} catch (Exception e) {
JOptionPane.showMessageDialog(null, "Keterangan Error : "+e);
}
}
