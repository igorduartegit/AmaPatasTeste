package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

// TODO: Auto-generated Javadoc
/**
 * The Class DAO.
 */
public class DAO {
	
	/** The driver. */
	private String driver = "com.mysql.cj.jdbc.Driver";
	
	/** The url. */
	private String url = "jdbc:mysql://127.0.0.1:3306/amapatas?useTimezone=true&serverTimezone=UTC";
	
	/** The user. */
	private String user = "root";
	
	/** The password. */
	private String password = "1234";

	/**
	 * Conectar.
	 *
	 * @return the connection
	 */
	private Connection conectar() {
		Connection con = null;
		try {
			Class.forName(driver);
			con = DriverManager.getConnection(url, user, password);
			return con;
		} catch (Exception e) {
			System.out.println(e);
			return null;
		}
	}

	/**
	 * Inserir contato.
	 *
	 * @param contato the contato
	 */
	public void inserirContato(JavaBeans contato) {
		String create = "insert into contatos (nome,fone,email, apoiador) values (?,?,?,?)";
		try {
			Connection con = conectar();
			PreparedStatement pst = con.prepareStatement(create);
			pst.setString(1, contato.getNome());
			pst.setString(2, contato.getFone());
			pst.setString(3, contato.getEmail());
			pst.setString(4, contato.getApoiador());
			pst.executeUpdate();
			con.close();
		} catch (Exception e) {
			System.out.println(e);
		}
	}

	/**
	 * Listar contatos.
	 *
	 * @return the array list
	 */
	public ArrayList<JavaBeans> listarContatos() {
		ArrayList<JavaBeans> contatos = new ArrayList<>();
		String read = "select * from contatos order by nome";
		try {
			Connection con = conectar();
			PreparedStatement pst = con.prepareStatement(read);
			ResultSet rs = pst.executeQuery();
			while (rs.next()) {
				String idcon = rs.getString(1);
				String nome = rs.getString(2);
				String fone = rs.getString(3);
				String email = rs.getString(4);
				String apoiador = rs.getString(5);
				contatos.add(new JavaBeans(idcon, nome, fone, email, apoiador));
			}
			con.close();
			return contatos;
		} catch (Exception e) {
			System.out.println(e);
			return null;
		}
		
	}
	
	/**
	 * Selecionar contato.
	 *
	 * @param contato the contato
	 */
	public void selecionarContato(JavaBeans contato) {
		String read2 ="select * from contatos where idcon = ?";
		try {
			Connection con = conectar();
			PreparedStatement pst = con.prepareStatement(read2);
			pst.setString(1,  contato.getIdcon());
			ResultSet rs = pst.executeQuery();
			while (rs.next()) {
				contato.setIdcon(rs.getString(1));
				contato.setNome(rs.getString(2));
				contato.setFone(rs.getString(3));
				contato.setEmail(rs.getString(4));
				contato.setApoiador(rs.getString(5));
			}
			con.close();
		} catch (Exception e) {
			System.out.println(e);
		}
	}
	
	/**
	 * Alterar contato.
	 *
	 * @param contato the contato
	 */
	public void alterarContato(JavaBeans contato) {
		String update = "update contatos set nome=?, fone=?, email=?, apoiador=? where idcon=?";
		try {
			Connection con = conectar();
			PreparedStatement pst = con.prepareStatement(update);
			pst.setString(1,  contato.getNome());
			pst.setString(2,  contato.getFone());
			pst.setString(3,  contato.getEmail());
			pst.setString(4,  contato.getApoiador());
			pst.setString(5,  contato.getIdcon());
			pst.executeUpdate();
			con.close();
		} catch (Exception e) {
			System.out.println(e);
		}
	}
	
	/**
	 * Deletar contato.
	 *
	 * @param contato the contato
	 */
	public void deletarContato(JavaBeans contato) {
		String delete = "delete from contatos where idcon=?";
				try {
					Connection con = conectar();
					PreparedStatement pst = con.prepareStatement(delete);
					pst.setString(1,  contato.getIdcon());
					pst.executeUpdate();
					con.close();
				} catch (Exception e) {
					System.out.println(e);
				}
	}
	
	
	
	
	
	
	/** CRUD CREATE **/
	
	/**
	 * Inserir animais.
	 *
	 * @param animais the animais
	 */
	public void inserirAnimais(JavaBeans animais) {
		String createAnimal = "insert into animais (nomepet, especie, idade, sexo, situacao) values (?,?,?,?,?)";
		try {
			Connection con = conectar(); /* abrir a conexão com o banco de dados MYSQL */
			PreparedStatement pst = con.prepareStatement(createAnimal); /* Prepara a query para conexão com o BD */ 
			pst.setString(1, animais.getNomepet()); /*substitui as interrogações pelos métodos JavaBeans */
			pst.setString(2, animais.getEspecie());
			pst.setString(3, animais.getIdade());
			pst.setString(4, animais.getSexo());
			pst.setString(5, animais.getSituacao());
			pst.executeUpdate();
			con.close();
		} catch (Exception e) {
			System.out.println(e);
		}
	}

	/**
	 * Listar animais.
	 *
	 * @return the array list
	 */
	public ArrayList<JavaBeans> listarAnimais() {
		ArrayList<JavaBeans> animais = new ArrayList<>();
		String read3 = "select * from animais order by nome";
		try {
			Connection con = conectar();
			PreparedStatement pst = con.prepareStatement(read3);
			ResultSet rs = pst.executeQuery();
			while (rs.next()) {
				String idpet = rs.getString(1);
				String nomepet = rs.getString(2);
				String especie = rs.getString(3);
				String idade = rs.getString(4);
				String sexo = rs.getString(5);
				String situacao = rs.getString(6);
				animais.add(new JavaBeans(idpet, nomepet, especie, idade, sexo, situacao));
			}
			con.close();
			return animais;
		} catch (Exception e) {
			System.out.println(e);
			return null;
		}
		
	}
	
	/**
	 * Selecionar contato.
	 *
	 * @param animais the animais
	 */
	public void selecionarAnimais(JavaBeans animais) {
		String read4 ="select * from animais where idcon = ?";
		try {
			Connection con = conectar();
			PreparedStatement pst = con.prepareStatement(read4);
			pst.setString(1,  animais.getIdpet());
			ResultSet rs = pst.executeQuery();
			while (rs.next()) {
				animais.setIdpet(rs.getString(1));
				animais.setNomepet(rs.getString(2));
				animais.setEspecie(rs.getString(3));
				animais.setIdade(rs.getString(4));
				animais.setSexo(rs.getString(5));
				animais.setSituacao(rs.getString(6));
			}
			con.close();
		} catch (Exception e) {
			System.out.println(e);
		}
	}
	
	/**
	 * Alterar contato.
	 *
	 * @param animais the animais
	 */
	public void alterarAnimais(JavaBeans animais) {
		String create = "update animais set nomepet=?, especie=?, idade=?, sexo=?, situacao=? where idpet=?";
		try {
			Connection con = conectar();
			PreparedStatement pst = con.prepareStatement(create);
			pst.setString(1,  animais.getNomepet());
			pst.setString(2,  animais.getEspecie());
			pst.setString(3,  animais.getIdade());
			pst.setString(4,  animais.getSexo());
			pst.setString(5,  animais.getSituacao());
			pst.executeUpdate();
			con.close();
		} catch (Exception e) {
			System.out.println(e);
		}
	}
	
	/**
	 * Deletar contato.
	 *
	 * @param animais the animais
	 */
	public void deletarAnimais(JavaBeans animais) {
		String deleteAnimais = "delete from animais where idpet=?";
				try {
					Connection con = conectar();
					PreparedStatement pst = con.prepareStatement(deleteAnimais);
					pst.setString(1,  animais.getIdpet());
					pst.executeUpdate();
					con.close();
				} catch (Exception e) {
					System.out.println(e);
				}
	}
}
