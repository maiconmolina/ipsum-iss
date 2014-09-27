/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lancamento.view;

import Util.ReturnValidate;
import Util.Util;
import caixa.view.TelaCaixa;
import ipsum.view.TelaStart;
import javax.swing.JOptionPane;
import lancamento.controller.LancamentoController;
import lancamento.model.Lancamento;
import lancamento.model.TipoDeLancamento;

/**
 *
 * @author Maicon
 */
public class TelaLancamento extends javax.swing.JInternalFrame {

    /**
     * Creates new form TelaLancamento
     */
    public TelaLancamento() {
        initComponents();
    }

    public TelaLancamento(String id) {
        Lancamento lanc = LancamentoController.buscaId(id);
//        JOptionPane.showMessageDialog(this, lanc.getDescricao());
        initComponents();
        descricao.setText(lanc.getDescricao());
        valor.setText(Double.toString(lanc.getValor()));
        tipo.setSelectedItem(lanc.getTipo());
//        if (lanc.getTipo().toString().equals("Entrada")) {
//            tipo.setS(0);
//        } else {
//            tipo.setSelectedIndex(1);
//        }
        codigo.setText(lanc.getCodigo().toString());
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        tipo = new javax.swing.JComboBox();
        descricao = new javax.swing.JTextField();
        valor = new javax.swing.JTextField();
        salvar = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        codigo = new javax.swing.JTextField();
        excluir = new javax.swing.JButton();

        setClosable(true);
        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Lançamento");

        jLabel1.setText("Descrição:");

        jLabel2.setText("Tipo:");

        jLabel3.setText("Valor:");

        tipo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tipoActionPerformed(evt);
            }
        });
        for(TipoDeLancamento t : TipoDeLancamento.values()){
            this.tipo.addItem(t);
        }

        descricao.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                descricaoActionPerformed(evt);
            }
        });

        salvar.setText("Salvar");
        salvar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                salvarActionPerformed(evt);
            }
        });

        jLabel4.setText("Código:");

        codigo.setEditable(false);

        excluir.setText("Excluir");
        excluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                excluirActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel4)
                    .addComponent(jLabel2)
                    .addComponent(jLabel3)
                    .addComponent(jLabel1))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(descricao, javax.swing.GroupLayout.PREFERRED_SIZE, 382, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(valor, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(codigo, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(excluir)
                        .addGap(18, 18, 18)
                        .addComponent(salvar))
                    .addComponent(tipo, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(7, 7, 7)
                        .addComponent(descricao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel1)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(tipo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(9, 9, 9)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(valor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(8, 8, 8)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(codigo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(excluir)
                    .addComponent(salvar))
                .addContainerGap(25, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void salvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_salvarActionPerformed

        ReturnValidate validacaoView = this.validaLancamentoView();
        if (validacaoView.isValid()) {
            Lancamento lancamento = new Lancamento();
            if (!"".equals(codigo.getText())) {
                Lancamento antigo = LancamentoController.buscaId(codigo.getText());
                ReturnValidate retornoRemove = LancamentoController.Remove(antigo);
                lancamento.setCodigo(Integer.parseInt(codigo.getText()));
            }
            lancamento.setDescricao(descricao.getText());
            lancamento.setTipo((TipoDeLancamento) tipo.getSelectedItem());
            lancamento.setValor(valor.getText());
            ReturnValidate retorno = LancamentoController.InsereLancamento(lancamento);
            if (retorno.isValid()) {
                this.setVisible(false);
                this.dispose();
                TelaCaixa tl = new TelaCaixa();
                TelaStart.addFrame(tl);
                tl.setLocation(10, 10);
                tl.setVisible(true);
                this.dispose();
            } else {
                JOptionPane.showMessageDialog(this, "Erro ao gravar no Banco de Dados");
            }
        } else {
            JOptionPane.showMessageDialog(this, validacaoView.getMessage());
        }
    }//GEN-LAST:event_salvarActionPerformed

    private ReturnValidate validaLancamentoView() {
        String retorno = "";
        if (Util.isNullOrEmpty(descricao.getText())) {
            retorno += "Campo 'Descrição' não pode ser vazio\n";
        }
        if (Util.isNullOrEmpty(valor.getText())) {
            retorno += "Campo 'Valor' inválido\n";
        }
        try {
            Double.parseDouble(valor.getText().replace(",", "."));
        } catch (NumberFormatException ex) {
            retorno += "Campo 'Valor' inválido\n";
        }

        return new ReturnValidate(retorno);
    }
    private void descricaoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_descricaoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_descricaoActionPerformed

    private void tipoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tipoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tipoActionPerformed

    private void excluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_excluirActionPerformed
        ReturnValidate validacaoView = this.validaLancamentoView();
        if (validacaoView.isValid()) {
            Lancamento lancamento = new Lancamento();
            if (!"".equals(codigo.getText())) {
                Lancamento antigo = LancamentoController.buscaId(codigo.getText());
//                antigo.setStatus(false);
//                Lancamento novo = new Lancamento();
//                novo.setDescricao(antigo.getDescricao());
//                novo.setTipo((TipoDeLancamento) antigo.getTipo());
//                novo.setValor(antigo.getValor());
//                novo.setCodigo(antigo.getCodigo());
                ReturnValidate retornoUpdate = LancamentoController.InsereLancamento(antigo);
            }
//            ReturnValidate retorno = LancamentoController.InsereLancamento(novo);
//            if (retorno.isValid()) {
            this.setVisible(false);
            this.dispose();
            TelaCaixa tl = new TelaCaixa();
            TelaStart.addFrame(tl);
            tl.setLocation(10, 10);
            tl.setVisible(true);
            this.dispose();
//            } else {
//                JOptionPane.showMessageDialog(this, "Erro ao gravar no Banco de Dados");
//            }
        } else {
//            JOptionPane.showMessageDialog(this, validacaoView.getMessage());
        }
    }//GEN-LAST:event_excluirActionPerformed

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
                if ("Windows".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(TelaLancamento.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TelaLancamento.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TelaLancamento.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TelaLancamento.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TelaLancamento().setVisible(true);
            }
        });

    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField codigo;
    private javax.swing.JTextField descricao;
    private javax.swing.JButton excluir;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JButton salvar;
    private javax.swing.JComboBox tipo;
    private javax.swing.JTextField valor;
    // End of variables declaration//GEN-END:variables
}
