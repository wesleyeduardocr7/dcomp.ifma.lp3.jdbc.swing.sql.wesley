package view;


import view.Aluno.PainelBuscarAlunos;
import view.Aluno.PainelCadastrarAlunos;
import view.Aluno.PainelDeletaAluno;
import view.Aluno.PainelListarAlunos;
import view.Curso.PainelBuscarCurso;
import view.Curso.PainelCadastrarCurso;
import view.Curso.PainelDeletaCursos;
import view.Curso.PainelListarCursos;
import view.Disciplina.PainelBuscarDisciplina;
import view.Disciplina.PainelCadastroDisciplina;
import view.Disciplina.PainelDeletaDisciplina;
import view.Disciplina.PainelListarDisciplina;
import view.Professor.PainelBuscarProfessor;
import view.Professor.PainelCadastraProfessor;
import view.Professor.PainelDeletaProfessor;
import view.Professor.PainelListarProfessor;

import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.sql.SQLException;
import javax.swing.*;

@SuppressWarnings("serial")

public class GUI extends JFrame implements ActionListener{
	
	JPanel panel = new JPanel();
	JPanel painelLogin = new JPanel();
	PainelAcoes painelAcoes = new PainelAcoes();
	PainelCadastrarAlunos painelAluno = new PainelCadastrarAlunos();
	PainelCadastrarCurso painelCadastraCurso = new PainelCadastrarCurso();
	PainelCadastraProfessor painelCadastraProfessor = new PainelCadastraProfessor();
	PainelGrade painelGrade = new PainelGrade();
	PainelProfDisc painelProfDisc = new PainelProfDisc();
	PaineMatriculaAluno paineMatriculaAluno = new PaineMatriculaAluno();
	PainelListarAlunos painelListarAlunos = new PainelListarAlunos();
	PainelBuscarAlunos painelBuscarAlunos = new PainelBuscarAlunos();
	PainelDeletaAluno painelDeletaAluno = new PainelDeletaAluno();
	PainelBuscarCurso painelBuscarCurso = new PainelBuscarCurso();
	PainelDeletaCursos painelDeletaCursos = new PainelDeletaCursos();
	PainelListarCursos painelListarCursos = new PainelListarCursos();
    PainelCadastroDisciplina painelCadastroDisciplina = new PainelCadastroDisciplina();
	PainelBuscarDisciplina painelBuscarDisciplina = new PainelBuscarDisciplina();
	PainelDeletaDisciplina painelDeletaDisciplina = new PainelDeletaDisciplina();
	PainelListarDisciplina painelListarDisciplina = new PainelListarDisciplina();
    PainelDeletaProfessor painelDeletaProfessor = new PainelDeletaProfessor();
    PainelBuscarProfessor painelBuscarProfessor = new PainelBuscarProfessor();
    PainelListarProfessor painelListarProfessor = new PainelListarProfessor();
	JTextField jTextField01;
	JPasswordField jPasswordField01 ;	
	JButton botaoLogin ;
	JMenu menuArquivo = new JMenu("Arquivo");	
	JMenu menuTabela = new JMenu("Tabela");
	JMenu menuAluno = new JMenu("Aluno");
	JMenu menuCurso = new JMenu("Curso");
	JMenu menuDisciplina = new JMenu("Disciplina");
	JMenu menuProfessor = new JMenu("Professor");
	JMenu menuSPF = new JMenu("SPF");
	JMenu menuAjuda = new JMenu("Ajuda");
	JMenuBar menuBar = new JMenuBar();	
	int totalTentativasLogin = 3;
	int loginErrados = 0;



    public GUI() {

    	
        super("Wesley Eduardo - SISTEMAS DE INFORMAÇÃO ESCOLAR");
      
        this.add(panel, "Center");
        this.add(painelLogin, "Center");
        this.add(painelAcoes, "Center");
        this.add(painelAluno, "Center");
        this.add(painelCadastraCurso, "Center");
        this.add(painelCadastroDisciplina, "Center");
        this.add(painelCadastraProfessor, "Center");
        this.add(painelGrade, "Center");
        this.add(painelProfDisc, "Center");
        this.add(paineMatriculaAluno, "Center");
		this.add(painelListarAlunos, "Center");
		this.add(painelBuscarAlunos, "Center");
		this.add(painelDeletaAluno, "Center");
		this.add(painelBuscarCurso, "Center");
		this.add(painelDeletaCursos, "Center");
		this.add(painelListarCursos, "Center");
        this.add(painelBuscarDisciplina, "Center");
        this.add(painelDeletaDisciplina, "Center");
        this.add(painelListarDisciplina, "Center");
        this.add(painelBuscarProfessor, "Center");
        this.add(painelDeletaProfessor, "Center");
        this.add(painelListarProfessor, "Center");

        ActionListener listener = new AcaoMenu(panel);
        
        menuArquivo.setMnemonic('F');
        menuArquivo.setIcon(new ImageIcon("src/imagens/arquivo.png"));
        menuArquivo.add(menuItem("Sair", listener, "Sair", 'N', KeyEvent.VK_X,"src/imagens/sair.png"));
        
        menuTabela.setMnemonic('F');
        menuTabela.setIcon(new ImageIcon("src/imagens/tabela.png"));
        menuTabela.add(menuItem("Aluno", listener, "Aluno", 'L', KeyEvent.VK_A,"src/imagens/aluno.png"));
        menuTabela.setMnemonic('F');
        menuTabela.add(menuItem("Curso", listener, "Curso", 'C', KeyEvent.VK_C,"src/imagens/curso.png"));
        menuTabela.setMnemonic('F');
        menuTabela.add(menuItem("Disciplina", listener, "Disciplina", 'C', KeyEvent.VK_D,"src/imagens/disciplina.png"));
        menuTabela.setMnemonic('F');
        menuTabela.add(menuItem("Professor", listener, "Professor", 'C', KeyEvent.VK_P,"src/imagens/prof2.png"));

		menuAluno.setMnemonic('F');
		menuAluno.setIcon(new ImageIcon("src/imagens/aluno.png"));
		menuAluno.add(menuItem("Novo", listener, "NovoAluno", 'L', KeyEvent.VK_A,"src/imagens/novo.png"));
		menuAluno.setMnemonic('F');
		menuAluno.add(menuItem("Buscar", listener, "BuscarAluno", 'C', KeyEvent.VK_C,"src/imagens/buscar.png"));
		menuAluno.setMnemonic('F');
		menuAluno.add(menuItem("Deletar", listener, "DeletarAluno", 'C', KeyEvent.VK_D,"src/imagens/deletar.png"));
		menuAluno.setMnemonic('F');
		menuAluno.add(menuItem("Listar", listener, "ListarAluno", 'C', KeyEvent.VK_P,"src/imagens/listar.png"));


		menuCurso.setMnemonic('F');
		menuCurso.setIcon(new ImageIcon("src/imagens/curso.png"));
		menuCurso.add(menuItem("Novo", listener, "NovoCurso", 'L', KeyEvent.VK_A,"src/imagens/novo.png"));
		menuCurso.setMnemonic('F');
		menuCurso.add(menuItem("Buscar", listener, "BuscaCurso", 'C', KeyEvent.VK_C,"src/imagens/buscar.png"));
		menuCurso.setMnemonic('F');
		menuCurso.add(menuItem("Deletar", listener, "DeletaCurso", 'C', KeyEvent.VK_D,"src/imagens/deletar.png"));
		menuCurso.setMnemonic('F');
		menuCurso.add(menuItem("Listar", listener, "ListaCurso", 'C', KeyEvent.VK_P,"src/imagens/listar.png"));

		menuDisciplina.setMnemonic('F');
		menuDisciplina.setIcon(new ImageIcon("src/imagens/disciplina.png"));
		menuDisciplina.add(menuItem("Novo", listener, "CadastraDisciplina", 'L', KeyEvent.VK_A,"src/imagens/novo.png"));
		menuDisciplina.setMnemonic('F');
		menuDisciplina.add(menuItem("Buscar", listener, "BuscaDisciplina", 'C', KeyEvent.VK_C,"src/imagens/buscar.png"));
		menuDisciplina.setMnemonic('F');
		menuDisciplina.add(menuItem("Deletar", listener, "DeletaDisciplina", 'C', KeyEvent.VK_D,"src/imagens/deletar.png"));
		menuDisciplina.setMnemonic('F');
		menuDisciplina.add(menuItem("Listar", listener, "ListaDisciplina", 'C', KeyEvent.VK_P,"src/imagens/listar.png"));

		menuProfessor.setMnemonic('F');
		menuProfessor.setIcon(new ImageIcon("src/imagens/prof.png"));
		menuProfessor.add(menuItem("Novo", listener, "CadastraProfessor", 'L', KeyEvent.VK_A,"src/imagens/novo.png"));
		menuProfessor.setMnemonic('F');
		menuProfessor.add(menuItem("Buscar", listener, "BuscaProfessor", 'C', KeyEvent.VK_C,"src/imagens/buscar.png"));
		menuProfessor.setMnemonic('F');
		menuProfessor.add(menuItem("Deletar", listener, "DeletaProfessor", 'C', KeyEvent.VK_D,"src/imagens/deletar.png"));
		menuProfessor.setMnemonic('F');
		menuProfessor.add(menuItem("Listar", listener, "ListaProfessor", 'C', KeyEvent.VK_P,"src/imagens/listar.png"));



		menuSPF.setMnemonic('F');
        menuSPF.setIcon(new ImageIcon("src/imagens/spf.png"));
        menuSPF.add(menuItem("Grade", listener, "Grade", 'R', KeyEvent.VK_G,"src/imagens/grade.jpg"));
        menuSPF.setMnemonic('F');
        menuSPF.add(menuItem("Prof/Disc", listener, "Prof/Disc", 'R', KeyEvent.VK_Q,"src/imagens/prof.png"));
        menuSPF.setMnemonic('F');
        menuSPF.add(menuItem("Mat/Aluno", listener, "Mat/Aluno", 'R', KeyEvent.VK_W,"src/imagens/matricula.png"));
        
               
        menuAjuda.setMnemonic('E');
        menuAjuda.setIcon(new ImageIcon("src/imagens/ajuda.png"));
        menuAjuda.add(menuItem("Sobre", listener, "Sobre", '0', KeyEvent.VK_H,"src/imagens/sobre.png"));

		menuBar.add(menuAluno);
		menuBar.add(menuCurso);
		menuBar.add(menuDisciplina);
		menuBar.add(menuProfessor);
        menuBar.add(menuSPF);
        menuBar.add(menuAjuda);
        this.setJMenuBar(menuBar);
        this.setSize(500, 400);
        this.setVisible(true);
        this.setResizable(true);       
        this.setLocationRelativeTo(null);


    }


	public void painelLogin(){
    	
  	  
		escondeMenu();
		escondePaineis();

		painelLogin.setVisible(true);
		painelLogin.setLayout(null);
		this.add(painelLogin);
		
		JLabel label01 = new JLabel();
		painelLogin.add(label01);		
		label01.setIcon(new ImageIcon("src/imagens/login0x.png"));
		label01.setBounds(120,30,250,80); 
		Font f0 = new Font("SansSerif", Font.BOLD, 25);
		label01.setFont(f0);
		label01.setForeground(Color.black);

		JLabel label02 = new JLabel();
		painelLogin.add(label02);		
		label02.setText("User: ");
		label02.setIcon(new ImageIcon("src/imagens/imagens/user.png"));
		label02.setBounds(120,60,200,200);
		Font f1 = new Font("SansSerif", Font.BOLD, 20);
		label02.setFont(f1);
		label02.setForeground(Color.black);

		jTextField01 = new JTextField();
		painelLogin.add(jTextField01);
		

		
		jTextField01.setText("");
		jTextField01.setBounds(210,150,160,25); 
		Font f2 = new Font("SansSerif", Font.BOLD, 20);
		jTextField01.setFont(f2);
		jTextField01.setForeground(Color.black);
		

		jPasswordField01 = new JPasswordField();
		painelLogin.add(jPasswordField01);		
		jPasswordField01.setText("");
		jPasswordField01.setBounds(210,217,160,25); 
		Font f4 = new Font("SansSerif", Font.BOLD, 20);
		jPasswordField01.setFont(f4);
		jPasswordField01.setForeground(Color.black);

		JLabel label03 = new JLabel();
		painelLogin.add(label03);		
		label03.setText("Pass: ");
		label03.setIcon(new ImageIcon("src/imagens/senha.png"));
		label03.setBounds(120,130,200,200); 
		Font f3 = new Font("SansSerif", Font.BOLD, 20);
		label03.setFont(f3);
		label03.setForeground(Color.black);
			


		botaoLogin = new JButton();
		botaoLogin.setIcon(new ImageIcon("src/imagens/login1.png"));
		painelLogin.add(botaoLogin);
		botaoLogin.setText("Acessar");
		botaoLogin.setBounds(120,290,250,37);
		Font f5 = new Font("SansSerif", Font.BOLD, 20);
		botaoLogin.setFont(f5);
		botaoLogin.setForeground(Color.black);


		botaoLogin.addActionListener(this);

		jTextField01.requestFocus();

     }
        
    
    public void chamarPainelAcoes(){	
    	
    	
		escondePaineis();	
		mostraMenu();
		this.add(painelAcoes);
		painelAcoes.cria();
		this.setExtendedState(JFrame.MAXIMIZED_BOTH);
        
            	  		
       }
    
    
    public void painelAlunos() {
    	
    	escondePaineis();	
		mostraMenu();
		this.add(painelAluno);
		painelAluno.cria();
		this.setExtendedState(JFrame.MAXIMIZED_BOTH);

    }
    
    
	public void painelCadastraCursos() {
	    	
		escondePaineis();	
		mostraMenu();
		this.add(painelCadastraCurso);
		painelCadastraCurso.cria();
		this.setExtendedState(JFrame.MAXIMIZED_BOTH);
	        
	    	
    }


	public void chamaPainelDeleta() {

		escondePaineis();
		mostraMenu();
		this.add(painelDeletaAluno);
		painelDeletaAluno.cria();
		this.setExtendedState(JFrame.MAXIMIZED_BOTH);

	}


	public void painelDisciplina() {

            escondePaineis();
            mostraMenu();
            this.add(painelCadastroDisciplina);
            painelCadastroDisciplina.cria();
            this.setExtendedState(JFrame.MAXIMIZED_BOTH);

        }

    public void painelBuscaDisciplina() {

        escondePaineis();
        mostraMenu();
        this.add(painelBuscarDisciplina);
        painelBuscarDisciplina.cria();
        this.setExtendedState(JFrame.MAXIMIZED_BOTH);

    }


    public void painelDeletaDisciplina() {

        escondePaineis();
        mostraMenu();
        this.add(painelDeletaDisciplina);
        painelDeletaDisciplina.cria();
        this.setExtendedState(JFrame.MAXIMIZED_BOTH);

    }


    public void painelListaDisciplina() {

        escondePaineis();
        mostraMenu();
        this.add(painelListarDisciplina);
        painelListarDisciplina.cria();
        this.setExtendedState(JFrame.MAXIMIZED_BOTH);

    }



    public void painelBuscaProfessor() {

        escondePaineis();
        mostraMenu();
        this.add(painelBuscarProfessor);
        painelBuscarProfessor.cria();
        this.setExtendedState(JFrame.MAXIMIZED_BOTH);

    }


    public void painelDeletaProfessor() {

        escondePaineis();
        mostraMenu();
        this.add(painelDeletaProfessor);
        painelDeletaProfessor.cria();
        this.setExtendedState(JFrame.MAXIMIZED_BOTH);

    }


    public void painelListaProfessor() {

        escondePaineis();
        mostraMenu();
        this.add(painelListarProfessor);
        painelListarProfessor.cria();
        this.setExtendedState(JFrame.MAXIMIZED_BOTH);

    }





    public void painelProfessor() {
	    	
		escondePaineis();	
		mostraMenu();
		this.add(painelCadastraProfessor);
		painelCadastraProfessor.cria();
		this.setExtendedState(JFrame.MAXIMIZED_BOTH);
    	
    }



	public void painelGrade() throws SQLException {

		escondePaineis();	
		mostraMenu();
		this.add(painelGrade);
		painelGrade.cria();
		this.setExtendedState(JFrame.MAXIMIZED_BOTH);

    }


	public void chamaPainelBuscarAluno() {

		escondePaineis();
		mostraMenu();
		this.add(painelBuscarAlunos);
		painelBuscarAlunos.cria();
		this.setExtendedState(JFrame.MAXIMIZED_BOTH);

	}



	public void painelProfDisc() throws SQLException {
		

		escondePaineis();	
		mostraMenu();
		this.add(painelProfDisc);
		painelProfDisc.cria();
		this.setExtendedState(JFrame.MAXIMIZED_BOTH);

    }


public void painelMatAluno() throws SQLException {
					
		
		escondePaineis();		
		this.add(paineMatriculaAluno);
		paineMatriculaAluno.criaPainelMatAluno();
  
   }


	public void painelBuscarCurso() {


		escondePaineis();
		this.add(painelBuscarCurso);
		painelBuscarCurso.cria();

	}


	public void painelListarCurso() {


		escondePaineis();
		this.add(painelListarCursos);
		painelListarCursos.cria();

	}

	public void paineDeletaCurso() {


		escondePaineis();
		this.add(painelDeletaCursos);
		painelDeletaCursos.cria();

	}



	public void painelListarAlunos() {


		escondePaineis();
		this.add(painelListarAlunos);
		painelListarAlunos.cria();

	}





	public static JMenuItem menuItem(String label, ActionListener listener, String command, int mnemonic, int acceleratorKey, String url) {
    JMenuItem item = new JMenuItem(label);
    item.addActionListener(listener);
    item.setActionCommand(command);
    item.setIcon(new ImageIcon(url));
    if (mnemonic != 0) {
        item.setMnemonic((char) mnemonic);
    }
    if (acceleratorKey != 0) {
        item.setAccelerator(KeyStroke.getKeyStroke(acceleratorKey, java.awt.Event.CTRL_MASK));
    }
    return item;
}


public void escondeMenu() {
	menuBar.setVisible(false);    	
}

public void mostraMenu() {    
	menuBar.setVisible(true);  	
}



public void escondePaineis() {
  
  panel.setVisible(false);
  painelLogin.setVisible(false);
  painelAcoes.setVisible(false);
  painelAluno.setVisible(false);
  painelCadastraCurso.setVisible(false);
  painelCadastroDisciplina.setVisible(false);
  painelCadastraProfessor.setVisible(false);
  painelGrade.setVisible(false);
  painelProfDisc.setVisible(false);
  paineMatriculaAluno.setVisible(false);
  painelListarAlunos.setVisible(false);
  painelBuscarAlunos.setVisible(false);
  painelDeletaAluno.setVisible(false);
	painelBuscarCurso.setVisible(false);
	painelDeletaCursos.setVisible(false);
	painelListarCursos.setVisible(false);
    painelBuscarProfessor.setVisible(false);
    painelDeletaProfessor.setVisible(false);
    painelListarProfessor.setVisible(false);
    painelBuscarDisciplina.setVisible(false);
    painelDeletaDisciplina.setVisible(false);
    painelListarDisciplina.setVisible(false);
  
}


	@SuppressWarnings("deprecation")
	@Override
	public void actionPerformed(ActionEvent e) {		
				
		
		 if(loginErrados > 2) {
				
				JOptionPane.showMessageDialog(null, "Falha de Autenticação - Aplicaçãoo será FECHADA");
				System.exit(0);
				
			}
		
		if(jTextField01.getText().equals("")) {			
			
			JOptionPane.showMessageDialog(null, "Campo Usu�rio Vazio! ");
			jTextField01.requestFocus();			
			
		}else if(jPasswordField01.getText().equals("")) {			
			
			JOptionPane.showMessageDialog(null, "Campo Senha Vazio! ");
			jPasswordField01.requestFocus();			
			
		}else if(!jTextField01.getText().equals("admin")) {			
									
			JOptionPane.showMessageDialog(null, "Usu�rio Incorreto ! ");
			jTextField01.requestFocus();	
			jTextField01.setText("");
			loginErrados++;
			JOptionPane.showMessageDialog(null, "Quantidade de Tentativas Restantes: " + (totalTentativasLogin - loginErrados));
			
		}else if(!jPasswordField01.getText().equals("admin")) {			
			
			JOptionPane.showMessageDialog(null, "Senha Incorreta ! ");
			jPasswordField01.requestFocus();	
			jPasswordField01.setText("");
			loginErrados++;
			
			JOptionPane.showMessageDialog(null, "Quantidade de Tentativas Restantes: " + (totalTentativasLogin - loginErrados));
			
		}else {
			
			JOptionPane.showMessageDialog(null, "Login Realizado com Sucesso ! ");
			jTextField01.setText("");
			jPasswordField01.setText("");
			chamarPainelAcoes();
					
			
		}
		
		
		
	}
	
	
	
	private class AcaoMenu implements ActionListener {

	    Component parent;

	   public AcaoMenu(JPanel panel) {
	        this.parent = parent;
	    }

	    @Override
	    public void actionPerformed(ActionEvent e) {
	        JMenuItem item = (JMenuItem) e.getSource();
	        String cmd = item.getActionCommand();
	        
	       if(cmd.equals("Sair")) {
	    	  fecharAplicacao();
	    	  
	       }else if(cmd.equals("Aluno")) {

			   System.out.println("ok 1");
	    	   
	    	   	painelAlunos();
	    	   
	       }else if(cmd.equals("Curso")) {
	    	   
	    	   	painelCadastraCursos();
	    	   
	       }else if(cmd.equals("Disciplina")) {
	    	   
	    	   	painelDisciplina();
	    	   
	       }else if(cmd.equals("Professor")) {
	    	   
	    	 	    	   
	    	   	painelProfessor();
	    	   
	       }else if(cmd.equals("Grade")) {


               try {
                   painelGrade();
               } catch (SQLException ex) {
                   System.out.println(ex);
               }


           }else if(cmd.equals("Prof/Disc")) {


               try {
                   painelProfDisc();
               } catch (SQLException ex) {
                   ex.printStackTrace();
               }


           }else if(cmd.equals("Mat/Aluno")) {


               try {
                   painelMatAluno();
               } catch (SQLException ex) {
                   ex.printStackTrace();
               }


           }else if(cmd.equals("NovoAluno")) {


			   painelAlunos();


		   }else if(cmd.equals("ListarAluno")) {


			   painelListarAlunos();


		   }else if(cmd.equals("BuscarAluno")) {


			   chamaPainelBuscarAluno();


		   }else if(cmd.equals("DeletarAluno")) {


				   chamaPainelDeleta();


	       }else if(cmd.equals("NovoCurso")) {


			   painelCadastraCursos();


		   }else if(cmd.equals("BuscaCurso")) {


			   painelBuscarCurso();


		   }else if(cmd.equals("DeletaCurso")) {


			   paineDeletaCurso();


		   }else if(cmd.equals("ListaCurso")) {


			   painelListarCurso();


		   }else if(cmd.equals("CadastraDisciplina")) {


               painelDisciplina();


           }else if(cmd.equals("BuscaDisciplina")) {


               painelBuscaDisciplina();


           }else if(cmd.equals("DeletaDisciplina")) {


            painelDeletaDisciplina();


        }else if(cmd.equals("ListaDisciplina")) {


            painelListaDisciplina();


        }else if(cmd.equals("CadastraProfessor")) {


               painelProfessor();


           }else if(cmd.equals("BuscaProfessor")) {


               painelBuscaProfessor();


           }else if(cmd.equals("DeletaProfessor")) {


               painelDeletaProfessor();


           }else if(cmd.equals("ListaProfessor")) {


               painelListaProfessor();


           }else {
	    	   
	    	   JOptionPane.showMessageDialog(null,"Nome Da Aplicação - LPIII - Wesley Eduardo\nVersão 1.0\nAno: 2019");
	       }       
	     
	    }

	       
	    public void fecharAplicacao() {
	    	
	   	 switch (JOptionPane.showConfirmDialog(null, "Deseja SAIR?")) {
	   	    case 0:
	   	       System.exit(0);
	   	        break;
	   	    case 1:    	        
	   	        break;
	   	    case 2:    	       
	   	        break;    	        
	   	    }
	   	
	   }

	    
	}

	
	 public static void main(String[] args) {        
		    
	    	
	        Splash splash  = new Splash(1500);
	        splash.showSplashAndExit();  	        

	    	 @SuppressWarnings("unused")
			GUI gui = new GUI();
	    	 
	    	 gui.painelLogin();
	        
	    }    
	    
        

}
