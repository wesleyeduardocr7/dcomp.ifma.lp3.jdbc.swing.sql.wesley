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
import java.util.ArrayList;

public class PainelListarDisciplina extends JPanel {

	/**
	 *
	 */
	private static final long serialVersionUID = 1L;

    JTable jTable1;
    JScrollPane jScrollPane1;
    ControleDisciplina controleDisciplina;
    DisciplinaDAO DisciplinaDAO;
    Connection connection;

	public void cria(){



		this.setVisible(true);
		this.setLayout(null);

        JLabel nomeDisciplina = new JLabel();
        this.add(nomeDisciplina);
        nomeDisciplina.setText("Listar Disciplina");
        nomeDisciplina.setBounds(570, 50, 300, 50);
        Font f0 = new Font("SansSerif", Font.BOLD, 25);
        nomeDisciplina.setFont(f0);
        nomeDisciplina.setForeground(Color.black);

        JLabel id = new JLabel();
        this.add(id);
        id.setText("ID");
        id.setBounds(285, 100, 100, 50);
        Font f20 = new Font("SansSerif", Font.BOLD, 15);
        id.setFont(f20);
        id.setForeground(Color.black);

        JLabel nome = new JLabel();
        this.add(nome);
        nome.setText("Nome");
        nome.setBounds(500, 100, 100, 50);
        Font f21 = new Font("SansSerif", Font.BOLD, 15);
        nome.setFont(f21);
        nome.setForeground(Color.black);

        JLabel ementa = new JLabel();
        this.add(ementa);
        ementa.setText("Ementa");
        ementa.setBounds(735, 100, 100, 50);
        Font f25 = new Font("SansSerif", Font.BOLD, 15);
        ementa.setFont(f25);
        nome.setForeground(Color.black);


        JLabel endereco = new JLabel();
        this.add(endereco);
        endereco.setText("CargaHr");
        endereco.setBounds(950, 100, 100, 50);
        Font f22 = new Font("SansSerif", Font.BOLD, 15);
        endereco.setFont(f22);
        endereco.setForeground(Color.black);


        JButton botaoListarDisciplinas = new JButton();
        botaoListarDisciplinas.addActionListener(new botaoListarDisciplinas());
        this.add(botaoListarDisciplinas);
        botaoListarDisciplinas.setText("Atualizar");
        botaoListarDisciplinas.setBounds(450, 570, 180, 35);
        Font f7 = new Font("SansSerif", Font.BOLD, 25);
        botaoListarDisciplinas.setFont(f7);
        botaoListarDisciplinas.setForeground(Color.black);


        JButton botaoLimparLista = new JButton();
        botaoLimparLista.addActionListener(new botaolimparLista());
        this.add(botaoLimparLista);
        botaoLimparLista.setText("Limpar");
        botaoLimparLista.setBounds(650, 570, 180, 35);
        Font f8 = new Font("SansSerif", Font.BOLD, 25);
        botaoLimparLista.setFont(f8);
        botaoLimparLista.setForeground(Color.black);


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

        jTable1.setBounds(200,140,900,400);



	}


    private class botaoListarDisciplinas implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent actionEvent) {


            DefaultTableModel dtm = (DefaultTableModel) jTable1.getModel();

            dtm.setNumRows(0);

            iniciaConexao();
            inicialControle();

            try {

                ArrayList<Disciplina>  listaDisciplinas = (ArrayList<Disciplina>) controleDisciplina.listarDisciplinas();

                for (Disciplina Disciplina : listaDisciplinas ){

                    dtm.addRow(new String[]{Integer.toString(Disciplina.getId()),Disciplina.getNome(),Disciplina.getEmenta(), Disciplina.getCargahr()});

                }


            } catch (SQLException e) {
                System.out.println(e);
            }

        }
    }


    private class botaolimparLista implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent actionEvent) {

            DefaultTableModel dtm = (DefaultTableModel) jTable1.getModel();

            dtm.setNumRows(0);


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

	