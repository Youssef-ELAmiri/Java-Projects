package Application;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableColumnModel;

import Classe_Info.*;
import DataBase.*;

public class GUI extends JFrame implements ActionListener{
	
	JPanel welcomP,addClassP,showClassP,showStudentP,addStudentP,addStudentTabbedP,addNoteTabbedP;
	JButton addClassB ,showClassB ,showStudentB,returnB,class_name_b,pro_mod_name_b,add_student_b,addStudentB,valider,returnB2;
	JMenuBar bmenu;
	
	public GUI() {
		
		ClasseDB DB = new ClasseDB();
		
		 // Initialisation g閚閞ale
        this.setTitle("Gestion des Etudiants ENSA");
        int x = Toolkit.getDefaultToolkit().getScreenSize().width;
        int y = Toolkit.getDefaultToolkit().getScreenSize().height;
        this.setSize(x/2, y/2);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        
        //Bar des Menu
        bmenu = new JMenuBar();
        Font menufont = new Font("Seguo UI",Font.PLAIN,20);
        bmenu.setPreferredSize(new Dimension(x/2,40));
        JMenu file = new JMenu("Fichier");
        file.setFont(menufont);
        file.setPreferredSize(new Dimension(70, 25));
        JMenu about = new JMenu("About");
        about.setFont(menufont);
        about.setPreferredSize(new Dimension(65, 25));
        JMenu retourne = new JMenu("Retourne");
        retourne.setFont(menufont);
        retourne.setPreferredSize(new Dimension(95, 25));
        JMenuItem Import = new JMenuItem("Importer une base de don閑s");
        Import.setFont(menufont);
        JMenuItem export = new JMenuItem("Exporter une base de don閑s");
        export.setFont(menufont);
        JMenuItem liste = new JMenuItem("Cr閑r une liste des etudiants (.txt)");
        liste.setFont(menufont);
        JMenuItem exit = new JMenuItem("Exit");
        exit.setFont(menufont);
        JMenuItem contact = new JMenuItem("Contactez-nous");
        contact.setFont(menufont);
        JMenuItem version = new JMenuItem("Version");
        version.setFont(menufont);
        JMenuItem welcomPage = new JMenuItem("La page d'accueil");
        welcomPage.setFont(menufont);
        
        file.add(Import);
        file.add(export);
        file.add(liste);
        file.addSeparator(); 
        file.add(exit);

        about.add(contact);
        about.addSeparator(); 
        about.add(version);
        
        retourne.add(welcomPage);

        bmenu.add(file);
        bmenu.add(about);
        bmenu.add(retourne);
        
        this.setJMenuBar(bmenu);
        
        
        welcomP = new JPanel();
        addClassP = new JPanel();
        showClassP = new JPanel();
        showStudentP = new JPanel();
        addStudentP = new JPanel();
        addStudentTabbedP = new JPanel();
        addNoteTabbedP = new JPanel();
        
        //Panel de Bienvenue
	   welcomP.setLayout(null);
	   welcomP.setBackground(new Color(250, 250, 240));
	   JLabel welcomlabel = new JLabel("Bienvenue dans l'Administration de Gestion des Etudiants");
	   welcomlabel.setBounds((x/2-800)/2, 60, 800, 30);
	   welcomlabel.setForeground(Color.blue);
	   Font welcomfont = new Font("Seguo UI", Font.BOLD, 27);
	   Font welcomBfont = new Font("Seguo UI", Font.PLAIN, 24);
	   welcomlabel.setFont(welcomfont);
	   addClassB = new JButton("Cr閑r une Classe");
	   addClassB.setBounds((x/2-700)/2, 150, 700, 70);
	   addClassB.addActionListener(this);
	   addClassB.setFont(welcomBfont);
	   showClassB = new JButton("Afficher les classes");
	   showClassB.setBounds((x/2-700)/2, 230, 700, 70);
	   showClassB.addActionListener(this);
	   showClassB.setFont(welcomBfont);
	   showStudentB = new JButton("Afficher les 閠udiants");
	   showStudentB.setBounds((x/2-700)/2, 310, 700, 70);
	   showStudentB.addActionListener(this);
	   showStudentB.setFont(welcomBfont);
	   welcomP.add(welcomlabel);
	   welcomP.add(addClassB);
	   welcomP.add(showClassB);
	   welcomP.add(showStudentB);
	   this.add(welcomP);
	    
        //Panel d'ajout des classes
	   	Font ordinaryfont = new Font("Seguo UI",Font.PLAIN,20);
	   	addClassP.setLayout(new BorderLayout());
	   	addClassP.setBackground(new Color(250, 250, 240));
	   	JPanel retrunP = new JPanel();
	   	retrunP.setBackground(new Color(250, 250, 240));
	   	retrunP.setLayout(null);
//	   	JButton returnB = new JButton("Retourne");
//	   	returnB.setBounds(00,0,200,50);
//	   	returnB.addActionListener(this);
//	   	Font retfont = new Font("Arial",Font.PLAIN,30);
//	   	returnB.setFont(retfont);
	   	JLabel class_name_l = new JLabel("Nom de classe : ");
	   	class_name_l.setFont(ordinaryfont);
	   	class_name_l.setBounds(150,70,200,30);
	   	JTextField class_name_t = new JTextField();
	   	class_name_t.setFont(ordinaryfont);
	   	class_name_t.setBounds(370,70,300,40);
	   	JButton class_name_b = new JButton("+");
	   	class_name_b.setFont(ordinaryfont);
	   	class_name_b.addActionListener(this);
	   	class_name_b.setBounds(690,65,50,50);
	   	JLabel add_module_l = new JLabel("--------------------------------------------------------Ajouter un module------------------------------------------------------------");
	   	add_module_l.setFont(ordinaryfont);
	   	add_module_l.setBounds(0,150,x/2,30);
	   	JLabel prof_name_l = new JLabel("Nom de classe : ");
	   	JLabel module_name_l = new JLabel("Nom de module : ");
	   	prof_name_l.setFont(ordinaryfont);
	   	prof_name_l.setBounds(150,220,200,30);
	   	module_name_l.setFont(ordinaryfont);
	   	module_name_l.setBounds(150,270,200,30);
	   	JTextField prof_name_t = new JTextField();
	   	JTextField module_name_t = new JTextField();
	   	prof_name_t.setFont(ordinaryfont);
	   	prof_name_t.setBounds(370,220,300,40);
	   	module_name_t.setFont(ordinaryfont);
	   	module_name_t.setBounds(370,270,300,40);
	   	JButton pro_mod_name_b = new JButton("+");
	   	pro_mod_name_b.setFont(ordinaryfont);
	   	pro_mod_name_b.setBounds(690,240,50,50);
	   	pro_mod_name_b.addActionListener(this);
	   	
	   	addClassP.add(class_name_l);
	   	addClassP.add(class_name_t);
	   	addClassP.add(class_name_b);
	   	addClassP.add(add_module_l);
	   	addClassP.add(prof_name_l);
	   	addClassP.add(prof_name_t);
	   	addClassP.add(module_name_l);
	   	addClassP.add(module_name_t);
	   	addClassP.add(pro_mod_name_b);
	   	addClassP.add(retrunP);
//	   	this.add(addClassP);
	   	
	   	//Panel d'affichage des classes
	   	showClassP.setLayout(new BorderLayout());
	   	showClassP.setBackground(new Color(250, 250, 240));
	   	DefaultTableModel module_model = new DefaultTableModel();
        JTable module_table = new JTable(module_model);
	   	JScrollPane scroll_table_class = new JScrollPane(module_table);
	   	scroll_table_class.setBounds(100,70,x/2-200,280);
        module_model.addColumn("Nom de Filiere");
        module_model.addColumn("Nombre d'閠udiants");
        module_table.setRowHeight(20);
//        module_table.setRowHeight(20); 
        module_table.setFont(ordinaryfont);
        JTableHeader tableHeader = module_table.getTableHeader();
        tableHeader.setFont(new Font("Seguo UI", Font.BOLD, 18)); 
        tableHeader.setBackground(new Color(200, 200, 255)); 
        tableHeader.setForeground(Color.BLACK);  
        tableHeader.setPreferredSize(new Dimension(100, 40));
        module_table.setRowHeight(50);
        JButton add_student_b = new JButton("Ajouter des 閠udiants");
        add_student_b.setFont(welcomBfont);
        add_student_b.setBounds(((x/2/2-440/2)),370,440,50);
        add_student_b.addActionListener(this);
	   	
        showClassP.add(scroll_table_class);
        showClassP.add(add_student_b);
	   	showClassP.add(retrunP);
//	   	this.add(showClassP);
	   	
	   	//Panel d'affichage des 閠udiants
	   	showStudentP.setLayout(new BorderLayout());
	   	showStudentP.setBackground(new Color(250, 250, 240));
	   	DefaultTableModel module_model2 = new DefaultTableModel();
        JTable module_table2 = new JTable(module_model2);
	   	JScrollPane scroll_table_student = new JScrollPane(module_table2);
	   	scroll_table_student.setBounds(50,100,x/2-100,310);
        module_model2.addColumn("Nbr");
        module_model2.addColumn("Nom Complet");
        module_model2.addColumn("Date de naissance");
        module_model2.addColumn("Email");

        module_table2.setFont(ordinaryfont);
        module_table2.setRowHeight(20);
        JTableHeader tableHeader2 = module_table2.getTableHeader();
        tableHeader2.setFont(new Font("Seguo UI", Font.BOLD, 15)); 
        tableHeader2.setBackground(new Color(200, 200, 255)); 
        tableHeader2.setForeground(Color.BLACK);  
        tableHeader2.setPreferredSize(new Dimension(100, 40));
        module_table2.setRowHeight(50);
        
        JLabel class_student_l = new JLabel("La classe : ");
        class_student_l.setFont(ordinaryfont);
        class_student_l.setBounds(100,50,200,30);
        JTextField class_student_t = new JTextField();
        class_student_t.setFont(ordinaryfont);
        class_student_t.setBounds(320,45,250,40);
        JButton choose_classe_b = new JButton("Afficher");
        choose_classe_b.setFont(welcomBfont);
        choose_classe_b.setBounds(590,45,120,40);
        
        showStudentP.add(class_student_t);
        showStudentP.add(class_student_l);
        showStudentP.add(choose_classe_b);
        showStudentP.add(scroll_table_student);
        showStudentP.add(retrunP);
//        this.add(showStudentP);
        
        
        //Panel d'ajout des 閠udiants

        addStudentP.setLayout(new BorderLayout());
	   	addStudentP.setBackground(new Color(250, 250, 240));
	   	JTabbedPane TP = new JTabbedPane();
	   	addStudentTabbedP.setLayout(null);
	   	addNoteTabbedP.setLayout(null);
	   	TP.setBounds(0,50,940,400);
	   	TP.addTab("Ajouter Etudiant", addStudentTabbedP);
		TP.addTab("Ajouter Note", addNoteTabbedP);
		TP.setFont(ordinaryfont);
        TP.setForeground(Color.black);
        TP.setBackground(Color.WHITE);
        
        //Student Panel
        JLabel class_l = new JLabel("La classe : ");
        class_l.setFont(ordinaryfont);
        class_l.setBounds(140,5,250,30);
        JTextField class_t = new JTextField();
        class_t.setFont(ordinaryfont);
        class_t.setBounds(410,5,370,40);
        JLabel nbr_l = new JLabel("Nbr : ");
        nbr_l.setFont(ordinaryfont);
        nbr_l.setBounds(140,50,250,30);
        JLabel fname_l = new JLabel("Nom complet : ");
        fname_l.setFont(ordinaryfont);
        fname_l.setBounds(140,110,250,30);
        JLabel date_l = new JLabel("Date de naissance : ");
        date_l.setFont(ordinaryfont);
        date_l.setBounds(140,160,250,30);
        JLabel email_l = new JLabel("Email : ");
        email_l.setFont(ordinaryfont);
        email_l.setBounds(140,210,250,30);
        
        JTextField nbr_t = new JTextField();
        nbr_t.setFont(ordinaryfont);
        nbr_t.setBounds(410,60,370,40);
        JTextField fname_t = new JTextField();
        fname_t.setFont(ordinaryfont);
        fname_t.setBounds(410,110,370,40);
        
        JTextField year_t = new JTextField();
        year_t.setFont(ordinaryfont);
        year_t.setBounds(410,160,100,40);
        
        JTextField month_t = new JTextField();
        month_t.setFont(ordinaryfont);
        month_t.setBounds(520,160,100,40);
        
        JTextField day_t = new JTextField();
        day_t.setFont(ordinaryfont);
        day_t.setBounds(630,160,100,40);
        
        JTextField email_t = new JTextField();
        email_t.setFont(ordinaryfont);
        email_t.setBounds(410,210,370,40);
        
        JButton addStudentB = new JButton("Ajouter l'閠udiant");
        addStudentB.setFont(welcomBfont);
        addStudentB.setBounds(((x/2/2-440/2)),270,440,50);
        addStudentB.addActionListener(this);
        
        //Note panel

        JComboBox<String> modules = new JComboBox();
        modules.setFont(ordinaryfont);
        modules.setBackground(Color.LIGHT_GRAY);
        modules.setBounds(x/2/2-100,25,200,40);
        JLabel exam_l = new JLabel("Note d'exame : ");
        exam_l.setFont(ordinaryfont);
        exam_l.setBounds(140,85,200,30);
        JLabel tp_l = new JLabel("Note de TP : ");
        tp_l.setFont(ordinaryfont);
        tp_l.setBounds(140,135,200,30);
        
        JTextField exam_t = new JTextField();
        exam_t.setFont(ordinaryfont);
        exam_t.setBounds(360,85,370,40);
        JTextField tp_t = new JTextField();
        tp_t.setFont(ordinaryfont);
        tp_t.setBounds(360,145,370,40);
//        JTextField checkby_nbr_t = new JTextField();
//        checkby_nbr_t.setFont(ordinaryfont);
//        checkby_nbr_t.setBounds(260,200,180,40);
        JTextField checkby_name_t = new JTextField();
        checkby_name_t.setFont(ordinaryfont);
        checkby_name_t.setBounds(360,200,250,40);
        
//        JLabel nbr_checker = new JLabel("Classe :");
//        nbr_checker.setFont(ordinaryfont);
//        nbr_checker.setBounds(140,205,100,30);
        JLabel name_checker = new JLabel("Nom : ");
        name_checker.setFont(ordinaryfont);
        name_checker.setBounds(200,205,150,30);

        
        JButton valider = new JButton("Valider");
        valider.setFont(welcomBfont);
        valider.setBounds(((x/2/2-440/2)),260,440,50);
        valider.addActionListener(this);
        
        addNoteTabbedP.add(modules);
        addNoteTabbedP.add(exam_l);
        addNoteTabbedP.add(tp_l);
        addNoteTabbedP.add(exam_t);
        addNoteTabbedP.add(tp_t);
//        addNoteTabbedP.add(nbr_checker);
        addNoteTabbedP.add(name_checker);
//        addNoteTabbedP.add(checkby_nbr_t);
        addNoteTabbedP.add(checkby_name_t);
        addNoteTabbedP.add(valider);
        
        addStudentTabbedP.add(class_l);
        addStudentTabbedP.add(class_t);
        addStudentTabbedP.add(nbr_l);
        addStudentTabbedP.add(fname_l);
        addStudentTabbedP.add(date_l);
        addStudentTabbedP.add(email_l);
        addStudentTabbedP.add(nbr_t);
        addStudentTabbedP.add(fname_t);
        addStudentTabbedP.add(year_t);
        addStudentTabbedP.add(month_t);
        addStudentTabbedP.add(day_t);
        addStudentTabbedP.add(email_t);
        addStudentTabbedP.add(addStudentB);
        addStudentP.add(TP);
	    addStudentP.add(retrunP);
//	    this.add(addStudentP);
	    
	    
	    
	    addClassB.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				getContentPane().removeAll();
		        add(addClassP);
		        revalidate();
		        repaint();
			}
		});
	    showClassB.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				 getContentPane().removeAll();
				 ArrayList<Classe> classes = new ArrayList<Classe>();
				 classes = DB.getClasses();
				 if (classes.isEmpty()) {
				     JOptionPane.showMessageDialog(null, "Aucune classe disponible.");
				 } else {
				     DefaultTableModel model = (DefaultTableModel) module_table.getModel();
				     model.setRowCount(0); 

				     for (Classe classe : classes) {
				         int nbrEtudiants = DB.getNbrLigne(classe.getFiliere_name());
				         
				        
				         model.addRow(new Object[]{classe.getFiliere_name(), nbrEtudiants});
				     }
				 }
			        add(showClassP);  
			        revalidate();
			        repaint();
			}
		});
	    
	    showStudentB.addActionListener(new ActionListener() {
	        @Override
	        public void actionPerformed(ActionEvent e) {
	            getContentPane().removeAll();
	            add(showStudentP);
	            revalidate();
	            repaint();
	        }
	    });
	    
	    choose_classe_b.addActionListener(new ActionListener() {
	        @Override
	        public void actionPerformed(ActionEvent e) {
	            String className = class_student_t.getText().trim(); 

	            if (className.isEmpty()) {
	                JOptionPane.showMessageDialog(null, "Veuillez saisir un nom de classe.");
	                return;  
	            }

	            ArrayList<Etudiant> etudiants = DB.getEtudiants(new Classe(className));

	            if (etudiants.isEmpty()) {
	                JOptionPane.showMessageDialog(null, "Aucun 閠udiant dans cette classe.");
	            } else {
	                Object[][] data = new Object[etudiants.size()][5];
	                for (int i = 0; i < etudiants.size(); i++) {
	                    Etudiant etudiant = etudiants.get(i);
	                    data[i][0] = etudiant.getNbr();
	                    data[i][1] = etudiant.getFullname();
	                    data[i][2] = etudiant.getDate_de_naissance();  
	                    data[i][3] = etudiant.getEmail();
	                   
	                }

	                module_model2.setDataVector(data, new String[]{"Nbr", "Nom Complet", "Date de Naissance", "Email"});
	            }

	            revalidate();
	            repaint();
	        }
	    });


	    
	    welcomPage.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				getContentPane().removeAll();
		        add(welcomP);
		        revalidate();
		        repaint();
			}
		});
	    add_student_b.addActionListener(new ActionListener() {
	        @Override
	        public void actionPerformed(ActionEvent e) {
	            int selectedRow = module_table.getSelectedRow();
	            if (selectedRow != -1) {
	                String selectedClass = module_table.getValueAt(selectedRow, 0).toString();
	                ArrayList<String> listModules = DB.getModulesForClass(selectedClass);

	                if (!listModules.isEmpty()) {
	                    modules.removeAllItems();
	                    for (String module : listModules) {
	                        modules.addItem(module);

	    	                getContentPane().removeAll();
	    	                add(addStudentP);
	    	                revalidate();
	    	                repaint();
	                    }
	                } else {
	                    JOptionPane.showMessageDialog(null, "Aucun module trouv� pour cette classe.");
	                    
	                }

	            } else {
	                JOptionPane.showMessageDialog(null, "Aucune classe s閘ectionn閑!");
	            }
	        }
	    });


	    class_name_b.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				
				DB.creerclasse(class_name_t.getText());
			}
		});
	    pro_mod_name_b.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				DB.ajouterModule(module_name_t.getText(),prof_name_t.getText());
			}
		});
	    addStudentB.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				DB.ajouterEtudiant(class_t.getText(), Integer.valueOf(nbr_t.getText()), fname_t.getText(), new Date(Integer.valueOf(day_t.getText()),Integer.valueOf(month_t.getText()),  Integer.valueOf(year_t.getText())), email_t.getText());
			}
		});
	    valider.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				int selectedRow = module_table.getSelectedRow();
				String selectedClass = module_table.getValueAt(selectedRow, 0).toString();
				DB.ajouterNote(selectedClass, String.valueOf(modules.getSelectedItem()) , Float.valueOf(exam_t.getText()), Float.valueOf(tp_t.getText()), checkby_name_t.getText().toString());
			}
		});
	    
        Import.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null, "Element en train de d関eloppement! merci de votre compr閔ension");
			}
		});
        export.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null, "Element en train de d関eloppement! merci de votre compr閔ension");
			}
		});
        liste.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null, "Element en train de d関eloppement! merci de votre compr閔ension");
			}
		});
        exit.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null, "Element en train de d関eloppement! merci de votre compr閔ension");
			}
		});
        contact.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(
					    null,
					    "<html><body style='text-align: center; font-size: 12px;'>"
					    + "Propri閠aire : EL-AMIRI YOUSSEF ISEIA1 ENSAFES<br>"
					    + "Whatsapp : 0691947676<br>"
					    + "Num閞o : 0708866350<br>"
					    + "All Rights Reserved."
					    + "</body></html>",
					    "Informations",
					    JOptionPane.INFORMATION_MESSAGE
					);
			}
		});
        version.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null, "Element en train de d関eloppement! merci de votre compr閔ension");
			}
		});

		this.setVisible(true);
	}
	
	
public static void main(String[] args){	
		new GUI();
	}

@Override
public void actionPerformed(ActionEvent arg0) {
	
}
//Created by EL-AMIRI YOUSSEF 
}
