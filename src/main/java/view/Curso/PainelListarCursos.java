package view.Curso;

import controle.ControleCurso;
import dao.CursoDAO;
import infra.Database;
import modelo.Curso;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;

public class PainelListarCursos extends JPanel {

	/**
	 *
	 */
	private static final long serialVersionUID = 1L;

    JTable jTable1;
    JScrollPane jScrollPane1;
    ControleCurso controleCurso;
    CursoDAO CursoDAO;
    Connection connection;

	public void cria(){



		this.setVisible(true);
		this.setLayout(null);

        JLabel nomeCurso = new JLabel();
        this.add(nomeCurso);
        nomeCurso.setText("Listar Cursos");
        nomeCurso.setBounds(560, 50, 300, 50);
        Font f0 = new Font("SansSerif", Font.BOLD, 25);
        nomeCurso.setFont(f0);
        nomeCurso.setForeground(Color.black);

        JLabel id = new JLabel();
        this.add(id);
        id.setText("ID");
        id.setBounds(560, 110, 100, 50);
        Font f20 = new Font("SansSerif", Font.BOLD, 15);
        id.setFont(f20);
        id.setForeground(Color.black);

        JLabel nome = new JLabel();
        this.add(nome);
        nome.setText("Nome");
        nome.setBounds(690, 110, 100, 50);
        Font f21 = new Font("SansSerif", Font.BOLD, 15);
        nome.setFont(f21);
        nome.setForeground(Color.black);



        JButton botaoListarCursos = new JButton();
        botaoListarCursos.addActionListener(new botaoListarCursos());
        this.add(botaoListarCursos);
        botaoListarCursos.setText("Atualizar");
        botaoListarCursos.setBounds(460, 590, 150, 35);
        Font f7 = new Font("SansSerif", Font.BOLD, 25);
        botaoListarCursos.setFont(f7);
        botaoListarCursos.setForeground(Color.black);


        JButton botaoLimparLista = new JButton();
        botaoLimparLista.addActionListener(new botaolimparLista());
        this.add(botaoLimparLista);
        botaoLimparLista.setText("Limpar");
        botaoLimparLista.setBounds(680, 590, 150, 35);
        Font f8 = new Font("SansSerif", Font.BOLD, 25);
        botaoLimparLista.setFont(f8);
        botaoLimparLista.setForeground(Color.black);


        jScrollPane1 = new JScrollPane();
        jTable1 = new JTable();


       jTable1.setModel(new DefaultTableModel(
               new Object [][] {

                       {null,null},
                       {null,null},
                       {null,null},
                       {null,null},
                       {null,null},
                       {null,null},
                       {null,null},
                       {null,null},
                       {null,null},
                       {null,null},
                       {null,null},
                       {null,null},
                       {null,null},
                       {null,null},
                       {null,null},
                       {null,null},
                       {null,null},
                       {null,null},
                       {null,null},
                       {null,null},
                       {null,null},
                       {null,null},
                       {null,null},
                       {null,null},
                       {null,null},
                       {null,null},




               },
               new String [] {
                       "ID", "Nome",
               }
       ));

       jScrollPane1.setViewportView(jTable1);


       this.add(jTable1);
       this.add(jScrollPane1);

        jTable1.setBounds(500,150,300,400);



	}


    private class botaoListarCursos implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent actionEvent) {


            DefaultTableModel dtm = (DefaultTableModel) jTable1.getModel();

            dtm.setNumRows(0);

            iniciaConexao();
            inicialControle();

            try {

                ArrayList<Curso>  listaCursos = (ArrayList<Curso>) controleCurso.listarCursos();

                for (Curso Curso : listaCursos ){

                    dtm.addRow(new String[]{Integer.toString(Curso.getId()),Curso.getNome()});

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

                            {null,null},
                            {null,null},
                            {null,null},
                            {null,null},
                            {null,null},
                            {null,null},
                            {null,null},
                            {null,null},
                            {null,null},
                            {null,null},
                            {null,null},
                            {null,null},
                            {null,null},
                            {null,null},
                            {null,null},
                            {null,null},
                            {null,null},
                            {null,null},
                            {null,null},
                            {null,null},
                            {null,null},
                            {null,null},
                            {null,null},
                            {null,null},
                            {null,null},
                            {null,null},



                    },
                    new String [] {
                            "ID", "Nome",
                    }
            ));


        }
    }


    public void iniciaConexao(){

        connection = Database.getConnection();
        CursoDAO = new CursoDAO(connection);

    }


    public void inicialControle(){

        controleCurso = new ControleCurso(CursoDAO);

    }

}

	