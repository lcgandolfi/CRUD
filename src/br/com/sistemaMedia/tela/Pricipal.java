package br.com.sistemaMedia.tela;

import br.com.sistemaMedia.dao.AlunoDaoImpl;
import br.com.sistemaMedia.entidade.Aluno;
import br.com.sistemaMedia.entidade.Professor;
import java.sql.SQLException;
import java.util.List;
import javax.swing.table.DefaultTableModel;

public class Pricipal extends javax.swing.JFrame {

    private Professor professor;
    private DefaultTableModel tabelaModelo;
    private AlunoDaoImpl alunoDao = new AlunoDaoImpl();

    public Pricipal() {
        initComponents();
    }

    public Pricipal(Professor professor) throws SQLException {
        initComponents();
        this.professor = professor;
        this.pupualarTabla();

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        varTabela = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        cadastrarAluno = new javax.swing.JMenu();
        mnCadAluno = new javax.swing.JMenuItem();
        alteraAluno = new javax.swing.JMenu();
        mnAltAluno = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        varTabela.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "Nome:", "Nota:", "Nota:", "Média", "Estado"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(varTabela);

        jLabel1.setFont(new java.awt.Font("Liberation Sans", 1, 18)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("alunos");

        cadastrarAluno.setText("Cadastro");

        mnCadAluno.setText("Alunos");
        mnCadAluno.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnCadAlunoActionPerformed(evt);
            }
        });
        cadastrarAluno.add(mnCadAluno);

        jMenuBar1.add(cadastrarAluno);

        alteraAluno.setText("Alterar");

        mnAltAluno.setText("Aluno");
        mnAltAluno.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnAltAlunoActionPerformed(evt);
            }
        });
        alteraAluno.add(mnAltAluno);

        jMenuBar1.add(alteraAluno);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 400, Short.MAX_VALUE)
            .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 179, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void mnAltAlunoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnAltAlunoActionPerformed
        new MudarAluno(professor).setVisible(true);
        this.dispose();
    }//GEN-LAST:event_mnAltAlunoActionPerformed

    private void mnCadAlunoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnCadAlunoActionPerformed
        new CadastroAluno(professor).setVisible(true);
        this.dispose();
    }//GEN-LAST:event_mnCadAlunoActionPerformed

    private void pupualarTabla() throws SQLException {
        tabelaModelo = (DefaultTableModel) varTabela.getModel();
        tabelaModelo.setNumRows(0);
        List<Aluno> alunos = alunoDao.mostrarAlunos(professor);
        for (Aluno aluno : alunos) {
            String nome = aluno.getNome();
            double nota1 = aluno.getNota1();
            double nota2 = aluno.getNota2();
            double media = aluno.getMedia();
            String estado = aluno.getEstado();

            tabelaModelo.addRow(new Object[]{nome,
                nota1, nota2, media, estado});

        }
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Pricipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Pricipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Pricipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Pricipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Pricipal().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenu alteraAluno;
    private javax.swing.JMenu cadastrarAluno;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JMenuItem mnAltAluno;
    private javax.swing.JMenuItem mnCadAluno;
    private javax.swing.JTable varTabela;
    // End of variables declaration//GEN-END:variables
}