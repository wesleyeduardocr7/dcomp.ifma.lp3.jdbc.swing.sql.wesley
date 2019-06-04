package view.Disciplina;

import controle.ControleDisciplina;
import dao.DisciplinaDAO;
import infra.Database;
import modelo.Disciplina;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.SQLException;

public class PainelBuscarDisciplina extends JPanel {

	/**
	 *
	 */
	private static final long serialVersionUID = 1L;

    JTable jTable1;
    JScrollPane jScrollPane1;
    ControleDisciplina controleDisciplina;
    DisciplinaDAO DisciplinaDAO;
    Connection connection;
    JTextField id  = new JTextField();;

	public void cria(){

	    id.setText("");

		this.setVisible(true);
		this.setLayout(null);

        JLabel nomeDisciplina = new JLabel();
        this.add(nomeDisciplina);
        nomeDisciplina.setText("Buscar Disciplina");
        nomeDisciplina.setBounds(570, 50, 300, 50);
        Font f0 = new Font("SansSerif", Font.BOLD, 25);
        nomeDisciplina.setFont(f0);
        nomeDisciplina.setForeground(Color.black);

        JLabel digiteId = new JLabel();
        this.add(digiteId);
        digiteId.setText("Digite o Código:");
        digiteId.setBounds(370, 150, 300, 25);
        Font f44 = new Font("SansSerif", Font.BOLD, 20);
        digiteId.setFont(f44);
        digiteId.setForeground(Color.black);


        this.add(id);
        id.setText("");
        id.setBounds(550, 150, 300, 25);
        Font f9= new Font("SansSerif", Font.BOLD, 20);
        id.setFont(f9);
        id.setForeground(Color.black);

        JLabel id = new JLabel();
        this.add(id);
        id.setText("ID");
        id.setBounds(285, 250, 100, 50);
        Font f20 = new Font("SansSerif", Font.BOLD, 15);
        id.setFont(f20);
        id.setForeground(Color.black);

        JLabel nome = new JLabel();
        this.add(nome);
        nome.setText("Nome");
        nome.setBounds(500, 250, 100, 50);
        Font f21 = new Font("SansSerif", Font.BOLD, 15);
        nome.setFont(f21);
        nome.setForeground(Color.black);

        JLabel ementa = new JLabel();
        this.add(ementa);
        ementa.setText("Ementa");
        ementa.setBounds(735, 250, 100, 50);
        Font f25 = new Font("SansSerif", Font.BOLD, 15);
        ementa.setFont(f25);
        nome.setForeground(Color.black);


        JLabel endereco = new JLabel();
        this.add(endereco);
        endereco.setText("CargaHr");
        endereco.setBounds(950, 250, 100, 50);
        Font f22 = new Font("SansSerif", Font.BOLD, 15);
        endereco.setFont(f22);
        endereco.setForeground(Color.black);


        JButton botaoBuscarDisciplina = new JButton();
        botaoBuscarDisciplina.addActionListener(new botaoBuscarDisciplina());
        this.add(botaoBuscarDisciplina);
        botaoBuscarDisciplina.setText("Buscar");
        botaoBuscarDisciplina.setBounds(900, 150, 180, 30);
        Font f7 = new Font("SansSerif", Font.BOLD, 25);
        botaoBuscarDisciplina.setFont(f7);
        botaoBuscarDisciplina.setForeground(Color.black);


        JButton botaoLimpar = new JButton();
        botaoLimpar.addActionListener(new botaolimparLista());
        this.add(botaoLimpar);
        botaoLimpar.setText("Limpar");
        botaoLimpar.setBounds(600, 570, 180, 35);
        Font f8 = new Font("SansSerif", Font.BOLD, 25);
        botaoLimpar.setFont(f8);
        botaoLimpar.setForeground(Color.black);



        jScrollPane1 = new JScrollPane();
        jTable1 = new JTable();


       jTable1.setModel(new DefaultTableModel(
               new Object [][] {
                       {null,null,null,null},
                       {null,null,null,null},
                       {null,null,null,null},
                       {null,null,null,null},
                       {null,null,null,null},
                       {null,null,null,null},
                       {null,null,null,null},
                       {null,null,null,null},
                       {null,null,null,null},
                       {null,null,null,null},
                       {null,null,null,null},
                       {null,null,null,null},
                       {null,null,null,null},
                       {null,null,null,null},
                       {null,null,null,null},
                       {null,null,null,null},
                       {null,null,null,null},
                       {null,null,null,null},



               },
               new String [] {
                       "ID", "Nome","Ementa","CargaHr"
               }
       ));

       jScrollPane1.setViewportView(jTable1);


       this.add(jTable1);
       this.add(jScrollPane1);

       jTable1.setBounds(200,290,900,197);

	}


    private class botaoBuscarDisciplina implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent actionEvent) {


            DefaultTableModel dtm = (DefaultTableModel) jTable1.getModel();

            dtm.setNumRows(0);

            if(id.getText().equals("")){

                JOptionPane.showMessageDialog(null,"Digite um Código:");
                id.setText("");
                id.requestFocus();

                jTable1.setModel(new DefaultTableModel(
                        new Object [][] {
                                {null,null,null,null},
                                {null,null,null,null},
                                {null,null,null,null},
                                {null,null,null,null},
                                {null,null,null,null},
                                {null,null,null,null},
                                {null,null,null,null},
                                {null,null,null,null},
                                {null,null,null,null},
                                {null,null,null,null},
                                {null,null,null,null},
                                {null,null,null,null},
                                {null,null,null,null},
                                {null,null,null,null},
                                {null,null,null,null},
                                {null,null,null,null},
                                {null,null,null,null},
                                {null,null,null,null},



                        },
                        new String [] {
                                "ID", "Nome","Ementa","CargaHr"
                        }
                ));

            }else{


            int codigo = Integer.parseInt(id.getText());
            boolean achou = false;

            iniciaConexao();
            inicialControle();

                try {

                    Disciplina Disciplina = controleDisciplina.buscaDisciplina(codigo);

                    if(Disciplina!=null){

                        achou = true;

                        dtm.addRow(new String[]{Integer.toString(Disciplina.getId()),Disciplina.getNome(),Disciplina.getEmenta(), Disciplina.getCargahr()});

                    }else{
                        JOptionPane.showMessageDialog(null,"Disciplina Nao Encontrado");
                        id.setText("");
                        id.requestFocus();

                        jTable1.setModel(new DefaultTableModel(
                                new Object [][] {
                                        {null,null,null,null},
                                        {null,null,null,null},
                                        {null,null,null,null},
                                        {null,null,null,null},
                                        {null,null,null,null},
                                        {null,null,null,null},
                                        {null,null,null,null},
                                        {null,null,null,null},
                                        {null,null,null,null},
                                        {null,null,null,null},
                                        {null,null,null,null},
                                        {null,null,null,null},
                                        {null,null,null,null},
                                        {null,null,null,null},
                                        {null,null,null,null},
                                        {null,null,null,null},
                                        {null,null,null,null},
                                        {null,null,null,null},



                                },
                                new String [] {
                                        "ID", "Nome","Ementa","CargaHr"
                                }
                        ));
                    }

                } catch (SQLException e) {
                    System.out.println(e);
                }


        }

        }
    }


    private class botaolimparLista implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent actionEvent) {

            DefaultTableModel dtm = (DefaultTableModel) jTable1.getModel();

            dtm.setNumRows(0);

            id.setText("");

            jTable1.setModel(new DefaultTableModel(
                    new Object [][] {
                            {null,null,null,null},
                            {null,null,null,null},
                            {null,null,null,null},
                            {null,null,null,null},
                            {null,null,null,null},
                            {null,null,null,null},
                            {null,null,null,null},
                            {null,null,null,null},
                            {null,null,null,null},
                            {null,null,null,null},
                            {null,null,null,null},
                            {null,null,null,null},
                            {null,null,null,null},
                            {null,null,null,null},
                            {null,null,null,null},
                            {null,null,null,null},
                            {null,null,null,null},
                            {null,null,null,null},



                    },
                    new String [] {
                            "ID", "Nome","Ementa","CargaHr"
                    }
            ));


        }
    }


    public void iniciaConexao(){

        connection = Database.getConnection();
        DisciplinaDAO = new DisciplinaDAO(connection);

    }


    public void inicialControle(){

        controleDisciplina = new ControleDisciplina(DisciplinaDAO);

    }

}

	