/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package fornecedor.view;

import Util.Constante;
import Util.ReturnValidate;
import Util.UfEnum;
import Util.Util;
import fornecedor.controller.FornecedorController;
import fornecedor.model.Fornecedor;
import java.util.Arrays;
import javax.swing.JOptionPane;

/**
 *
 * @author Maicon
 */
public class FornecedorCadastro extends javax.swing.JInternalFrame { //Variaveis locais

    private Integer codigo = null;
    private Boolean ativo;
    /**
     * Creates new form FornecedorCadastro
     */
    public FornecedorCadastro() { //Contrutor para inserção
        initComponents();
        Inativar.setVisible(false);
    }
    
    public FornecedorCadastro(Fornecedor forn){  //Construtor para edição
        initComponents();
        CNPJ.setText(forn.getCnpj());
        RazaoSocial.setText(forn.getRazao());
        Fantasia.setText(forn.getFantasia());
        Telefone.setText(forn.getTelefone());
        Endereco.setText(forn.getEndereço());
        Numero.setText(forn.getNumero().toString());
        UF.setSelectedItem(forn.getUf());
        Cidade.setText(forn.getCidade());
        CEP.setText(forn.getCep());
        Email.setText(forn.getEmail());
        Login.setText(forn.getLogin());
        Senha.setText(forn.getSenha());
        ConfirmarSenha.setText(forn.getSenha());
        
        this.codigo = forn.getCodigo();
        this.ativo = forn.isAtivo();
        
        Salvar.setText("Editar");
        Login.setEditable(false);
        Inativar.setText(forn.isAtivo() ? "Inativar" : "Reativar");
        Salvar.setEnabled(forn.isAtivo());
        this.setEditableScreen(forn.isAtivo());
        
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        RazaoSocial = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        Fantasia = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        Numero = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        Endereco = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        UF = new javax.swing.JComboBox();
        jLabel9 = new javax.swing.JLabel();
        Salvar = new javax.swing.JButton();
        jLabel11 = new javax.swing.JLabel();
        Login = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        Senha = new javax.swing.JPasswordField();
        jLabel13 = new javax.swing.JLabel();
        ConfirmarSenha = new javax.swing.JPasswordField();
        CNPJ = new javax.swing.JFormattedTextField(Constante.CnpjMask);
        Telefone = new javax.swing.JFormattedTextField(Constante.TelefoneMask);
        jLabel14 = new javax.swing.JLabel();
        Email = new javax.swing.JTextField();
        Inativar = new javax.swing.JButton();
        Cidade = new javax.swing.JTextField();
        CEP = new javax.swing.JFormattedTextField(Constante.CepMask);

        setClosable(true);
        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Cadastro Cliente/Fornecedor");

        jLabel1.setText("Razão Social:");

        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        jLabel2.setText("Fantasia:");

        jLabel3.setText("CNPJ:");

        jLabel4.setText("Telefone:");

        jLabel5.setText("CEP:");

        jLabel6.setText("Nº:");

        jLabel7.setText("Endereço:");

        jLabel8.setText("UF: ");

        UF.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                UFActionPerformed(evt);
            }
        });

        jLabel9.setText("Cidade:");

        Salvar.setText("Salvar");
        Salvar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SalvarActionPerformed(evt);
            }
        });

        jLabel11.setText("Login:");

        jLabel12.setText("Senha:");

        jLabel13.setText("Confirmar senha:");

        CNPJ.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CNPJActionPerformed(evt);
            }
        });

        jLabel14.setText("E-mail:");

        Email.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                EmailActionPerformed(evt);
            }
        });

        Inativar.setText("Inativar");
        Inativar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                InativarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel7)
                    .addComponent(jLabel4)
                    .addComponent(jLabel3)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(jLabel11)
                    .addComponent(jLabel12)
                    .addComponent(jLabel9))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(Inativar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(Salvar))
                    .addComponent(RazaoSocial)
                    .addComponent(Fantasia)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(Login, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 142, Short.MAX_VALUE)
                            .addComponent(Senha))
                        .addGap(12, 12, 12)
                        .addComponent(jLabel13)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(ConfirmarSenha, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(Endereco, javax.swing.GroupLayout.PREFERRED_SIZE, 253, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel8)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(UF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 11, Short.MAX_VALUE)
                        .addComponent(jLabel5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(CEP, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(Cidade, javax.swing.GroupLayout.DEFAULT_SIZE, 205, Short.MAX_VALUE)
                            .addComponent(Telefone, javax.swing.GroupLayout.DEFAULT_SIZE, 205, Short.MAX_VALUE)
                            .addComponent(CNPJ))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addComponent(jLabel14)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGap(34, 34, 34)
                                .addComponent(jLabel6)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(Numero, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(179, 179, 179))
                            .addComponent(Email))))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(RazaoSocial, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(Fantasia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(CNPJ, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(Telefone, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel14)
                    .addComponent(Email, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(Numero, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel9)
                    .addComponent(Cidade, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(Endereco, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel8)
                    .addComponent(UF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(CEP, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5))
                .addGap(36, 36, 36)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel11)
                    .addComponent(Login, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel12)
                    .addComponent(Senha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel13)
                    .addComponent(ConfirmarSenha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 23, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Salvar)
                    .addComponent(Inativar))
                .addContainerGap())
        );

        for(UfEnum uf : UfEnum.values()){
            this.UF.addItem(uf);
        }

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void CNPJActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CNPJActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_CNPJActionPerformed

    private void UFActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_UFActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_UFActionPerformed

    private void EmailActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_EmailActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_EmailActionPerformed

    private void SalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SalvarActionPerformed
        if (Arrays.equals(Senha.getPassword(), ConfirmarSenha.getPassword())){ //verefica se as senhas são iquais
            ReturnValidate validacaoView = this.validaFornecedorView(); //Chama as valida dos campos
            if (validacaoView.isValid()){ 
                Fornecedor forn = new Fornecedor(); //Cria um objeto 
                
                forn.setRazao(RazaoSocial.getText());
                forn.setFantasia(Fantasia.getText());
                forn.setCnpj(CNPJ.getText());
                forn.setTelefone(Telefone.getText());
                forn.setEmail(Email.getText());
                forn.setCep(CEP.getText());
                forn.setNumero(Numero.getText());
                forn.setEndereço(Endereco.getText());
                forn.setUf((UfEnum) UF.getSelectedItem());
                forn.setCidade(Cidade.getText());
                forn.setLogin(Login.getText());
                forn.setSenha(Senha.getPassword());
                forn.setSenha(ConfirmarSenha.getPassword());
                
                forn.setCodigo(this.codigo);
                
                ReturnValidate retorno = FornecedorController.InsereFornecedor(forn); //Joga para o Controller Inserir
                if (retorno.isValid()) {
                    this.dispose();
                } else {
                    JOptionPane.showMessageDialog(this, retorno.getMessage());
                }
            } else {
                JOptionPane.showMessageDialog(this, validacaoView.getMessage());
            }
        }else {
            JOptionPane.showMessageDialog(this, "As senhas não conferem!");
        }
    }//GEN-LAST:event_SalvarActionPerformed

    private void InativarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_InativarActionPerformed
        if (ativo) {                                                                // verifica se esta ativo
            if (JOptionPane.showConfirmDialog(this, "Deseja mesmo inativar?") == 0) {
                ReturnValidate retorno = FornecedorController.Inativar(this.codigo); //Joga para o Controller Inativar
                if (retorno.isValid()) {
                    this.dispose();
                } else {
                    JOptionPane.showMessageDialog(this, "Um erro ocorreu!\n" + retorno.getMessage());
                }
            }
        } else {                                                                //Joga para o Controller Ativar         
            ReturnValidate retorno = FornecedorController.Reativar(this.codigo);
            if (retorno.isValid()) {
                this.dispose();
            } else {
                JOptionPane.showMessageDialog(this, "Um erro ocorreu!\n" + retorno.getMessage());
            }
        }
    }//GEN-LAST:event_InativarActionPerformed
                   
    
    private ReturnValidate validaFornecedorView(){  //Validações dos campos
        String retorno = "";
        if (Util.isNullOrEmpty(RazaoSocial.getText())){
            retorno += "Campo 'Razao Social' não pode ser vazio\n";
        }
        
        if (!Util.ValidateCnpj(CNPJ.getText().replace(".", "").replace("-", "").replace("/", ""))) {
            retorno += "CNPJ inválido\n";
        }
        
        if (Util.isNullOrEmpty(Telefone.getText().replace("(", "").replace(")", "").replace("-", ""))){
            retorno += "Campo 'Telefone' não pode ser vazio\n";
        }
        
        if (Util.isNullOrEmpty(CEP.getText().replace("-", ""))){
            retorno += "Campo 'CEP' não pode ser vazio\n";
        }
        
        if (Util.isNullOrEmpty(Endereco.getText())){
            retorno += "Campo 'Endereco' não pode ser vazio\n";
        }
        
        if (Util.isNullOrEmpty(Numero.getText())){
            retorno += "Campo 'Numero' não pode ser vazio\n";
        }
        
        if (Util.isNullOrEmpty(Cidade.getText())){
            retorno += "Campo 'Cidade' não pode ser vazio\n";
        }
        
        return new ReturnValidate(retorno);
    }
    
    private void setEditableScreen(Boolean editable) { //Se o Objeto estiver Inativo(bloqueia a edição) 
        RazaoSocial.setEditable(editable);             // Se o Objeto estiver Ativo(Permite a edição)
        Fantasia.setEditable(editable);
        CNPJ.setEditable(editable);
        Telefone.setEditable(editable);
        Email.setEditable(editable);
        CEP.setEditable(editable);
        Numero.setEnabled(editable);
        Endereco.setEditable(editable);
        UF.setEditable(editable);
        Cidade.setEditable(editable);
        CEP.setEnabled(editable);
        Email.setEnabled(editable);
        Senha.setEnabled(editable);
        ConfirmarSenha.setEnabled(editable);
        Login.setEnabled(editable);
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
            java.util.logging.Logger.getLogger(FornecedorCadastro.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FornecedorCadastro.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FornecedorCadastro.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FornecedorCadastro.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FornecedorCadastro().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JFormattedTextField CEP;
    private javax.swing.JFormattedTextField CNPJ;
    private javax.swing.JTextField Cidade;
    private javax.swing.JPasswordField ConfirmarSenha;
    private javax.swing.JTextField Email;
    private javax.swing.JTextField Endereco;
    private javax.swing.JTextField Fantasia;
    private javax.swing.JButton Inativar;
    private javax.swing.JTextField Login;
    private javax.swing.JTextField Numero;
    private javax.swing.JTextField RazaoSocial;
    private javax.swing.JButton Salvar;
    private javax.swing.JPasswordField Senha;
    private javax.swing.JFormattedTextField Telefone;
    private javax.swing.JComboBox UF;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    // End of variables declaration//GEN-END:variables
}
