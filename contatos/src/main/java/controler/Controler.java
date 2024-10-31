package controler;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.itextpdf.text.Document;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;

import model.DAO;
import model.JavaBeans;

// TODO: Auto-generated Javadoc
/**
 * The Class Controler. TALVEZ INSERIR O CONTROLER COM SUFIXO PET
 */
@WebServlet(urlPatterns = { "/Controler", "/main", "/insert", "/select", "/update", "/delete", "/report", 
										"/mainAnimais", "/insertAnimais", "/selectAnimais", "/updateAnimais",
																"/deleteAnimais", "/reportAnimais"})
public class Controler extends HttpServlet {
	
	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;
	
	/** The dao. */
	DAO dao = new DAO();
	
	/** The contato. */
	JavaBeans contato = new JavaBeans();
	
	/** The animais. */
	JavaBeans animais = new JavaBeans();

	/**
	 * Instantiates a new controler.
	 */
	public Controler() {
		super();
	}

	/**
	 * Do get.
	 *
	 * @param request the request
	 * @param response the response
	 * @throws ServletException the servlet exception
	 * @throws IOException Signals that an I/O exception has occurred.
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String action = request.getServletPath();
		if (action.equals("/main")) {
			contatos(request, response);
		} else if (action.equals("/insert")) {
			adicionarContato(request, response);
		} else if (action.equals("/select")) {
			listarContato(request, response);
		} else if (action.equals("/update")) {
			editarContato(request, response);
		} else if (action.equals("/delete")) {
			removerContato(request, response);
		} else if (action.equals("/report")) {
			gerarRelatorio(request, response);
		} else {
			response.sendRedirect("index.html");
		}
	}

	/**
	 * Contatos.
	 *
	 * @param request the request
	 * @param response the response
	 * @throws ServletException the servlet exception
	 * @throws IOException Signals that an I/O exception has occurred.
	 */
	protected void contatos(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		ArrayList<JavaBeans> lista = dao.listarContatos();
		request.setAttribute("contatos", lista);
		RequestDispatcher rd = request.getRequestDispatcher("contatos.jsp");
		rd.forward(request, response);
	}

	/**
	 * Adicionar contato.
	 *
	 * @param request the request
	 * @param response the response
	 * @throws ServletException the servlet exception
	 * @throws IOException Signals that an I/O exception has occurred.
	 */
	protected void adicionarContato(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		contato.setNome(request.getParameter("nome"));
		contato.setFone(request.getParameter("fone"));
		contato.setEmail(request.getParameter("email"));
		contato.setApoiador(request.getParameter("apoiador"));
		dao.inserirContato(contato);
		response.sendRedirect("agradecimento.html");
	}

	/**
	 * Listar contato.
	 *
	 * @param request the request
	 * @param response the response
	 * @throws ServletException the servlet exception
	 * @throws IOException Signals that an I/O exception has occurred.
	 */
	protected void listarContato(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		contato.setIdcon(request.getParameter("idcon"));
		dao.selecionarContato(contato);
		request.setAttribute("idcon", contato.getIdcon());
		request.setAttribute("nome", contato.getNome());
		request.setAttribute("fone", contato.getEmail());
		request.setAttribute("email", contato.getFone());
		request.setAttribute("apoiador", contato.getApoiador());
		RequestDispatcher rd = request.getRequestDispatcher("editar.jsp");
		rd.forward(request, response);
	}

	/**
	 * Editar contato.
	 *
	 * @param request the request
	 * @param response the response
	 * @throws ServletException the servlet exception
	 * @throws IOException Signals that an I/O exception has occurred.
	 */
	protected void editarContato(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		contato.setIdcon(request.getParameter("idcon"));
		contato.setNome(request.getParameter("nome"));
		contato.setFone(request.getParameter("fone"));
		contato.setEmail(request.getParameter("email"));
		contato.setApoiador(request.getParameter("apoiador"));
		dao.alterarContato(contato);
		response.sendRedirect("main");
	}

	/**
	 * Remover contato.
	 *
	 * @param request the request
	 * @param response the response
	 * @throws ServletException the servlet exception
	 * @throws IOException Signals that an I/O exception has occurred.
	 */
	protected void removerContato(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		contato.setIdcon(request.getParameter("idcon"));
		dao.deletarContato(contato);
		response.sendRedirect("main");
	}

	/**
	 * Gerar relatorio.
	 *
	 * @param request the request
	 * @param response the response
	 * @throws ServletException the servlet exception
	 * @throws IOException Signals that an I/O exception has occurred.
	 */
	protected void gerarRelatorio(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Document documento = new Document();
		try {
			response.setContentType("apllication/pdf");
			response.addHeader("Content-Disposition", "inline; filename=" + "contatos.pdf");
			PdfWriter.getInstance(documento, response.getOutputStream());
			documento.open();
			documento.add(new Paragraph("Lista de contatos:"));
			documento.add(new Paragraph(" "));
			PdfPTable tabela = new PdfPTable(4);
			PdfPCell col1 = new PdfPCell(new Paragraph("Nome"));
			PdfPCell col2 = new PdfPCell(new Paragraph("Fone"));
			PdfPCell col3 = new PdfPCell(new Paragraph("Email"));
			PdfPCell col4 = new PdfPCell(new Paragraph("Apoiador"));
			tabela.addCell(col1);
			tabela.addCell(col2);
			tabela.addCell(col3);
			tabela.addCell(col4);
			ArrayList<JavaBeans> lista = dao.listarContatos();
			for (int i = 0; i < lista.size(); i++) {
				tabela.addCell(lista.get(i).getNome());
				tabela.addCell(lista.get(i).getFone());
				tabela.addCell(lista.get(i).getEmail());
				tabela.addCell(lista.get(i).getApoiador());
			}
			documento.add(tabela);
			documento.close();
		} catch (Exception e) {
			System.out.println(e);
			documento.close();
		}
	}
	
	
	
	
	
	
	
	/* Controller de ANIMAIS */


	/**
	 * Instantiates a new controler.
	 *
	 * @param request the request
	 * @param response the response
	 * @throws ServletException the servlet exception
	 * @throws IOException Signals that an I/O exception has occurred.
	 */ 
	/* public Animais() {
		super();
	} */ 

	/**
	 * Do get.
	 *
	 * @param request the request
	 * @param response the response
	 * @throws ServletException the servlet exception
	 * @throws IOException Signals that an I/O exception has occurred.
	 */
	protected void doGet2(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String action = request.getServletPath();
		if (action.equals("/mainAnimais")) {
			animais(request, response);
		} else if (action.equals("/insertAnimais")) {
			adicionarAnimais(request, response);
		} else if (action.equals("/selectAnimais")) {
			listarAnimais(request, response);
		} else if (action.equals("/updateAnimais")) {
			editarAnimais(request, response);
		} else if (action.equals("/deleteAnimais")) {
			removerAnimais(request, response);
		} else if (action.equals("/reportAnimais")) {
			gerarRelatorio(request, response);
		} else {
			response.sendRedirect("index.html"); /* Aqui deve precisar mudar */
		}
	}

	
	
	/**
	 * Animais.
	 *
	 * @param request the request
	 * @param response the response
	 * @throws ServletException the servlet exception
	 * @throws IOException Signals that an I/O exception has occurred.
	 */
	protected void animais(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		ArrayList<JavaBeans> listaAnimais = dao.listarAnimais();
		
		// teste de recebimento
	//	for (int i = 0; i < listaAnimais.size(); i++) {
	//		System.out.println(listaAnimais.get(i).getIdpet());
	//		System.out.println(listaAnimais.get(i).getNomepet());
	//		System.out.println(listaAnimais.get(i).getEspecie());
	//		System.out.println(listaAnimais.get(i).getIdade());
	//		System.out.println(listaAnimais.get(i).getSexo());
	//		System.out.println(listaAnimais.get(i).getSituacao());
	//	}
		
		request.setAttribute("animais", listaAnimais);
		RequestDispatcher rd = request.getRequestDispatcher("animais.jsp");
		rd.forward(request, response);
	}

	/**
	 * Adicionar animais.
	 *
	 * @param request the request
	 * @param response the response
	 * @throws ServletException the servlet exception
	 * @throws IOException Signals that an I/O exception has occurred.
	 */
	protected void adicionarAnimais(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		animais.setNomepet(request.getParameter("nomepet"));
		animais.setEspecie(request.getParameter("especie"));
		animais.setIdade(request.getParameter("idade"));
		animais.setSexo(request.getParameter("sexo"));
		animais.setSituacao(request.getParameter("situacao"));
		dao.inserirAnimais(animais);
		response.sendRedirect("mainAnimais"); /* Mudar*/
	}

	/**
	 * Listar animais.
	 *
	 * @param request the request
	 * @param response the response
	 * @throws ServletException the servlet exception
	 * @throws IOException Signals that an I/O exception has occurred.
	 */
	protected void listarAnimais(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		animais.setIdcon(request.getParameter("idpet"));
		dao.selecionarAnimais(animais);
		request.setAttribute("idpet", animais.getIdpet());
		request.setAttribute("nomepet", animais.getNomepet());
		request.setAttribute("especie", animais.getEspecie());
		request.setAttribute("idade", animais.getIdade());
		request.setAttribute("sexo", animais.getSexo());
		request.setAttribute("situacao", animais.getSituacao());
		RequestDispatcher rd = request.getRequestDispatcher("editaranimais.jsp"); /* MUDAR EDITAR */ 
		rd.forward(request, response);
	}

	/**
	 * Editar animais.
	 *
	 * @param request the request
	 * @param response the response
	 * @throws ServletException the servlet exception
	 * @throws IOException Signals that an I/O exception has occurred.
	 */
	protected void editarAnimais(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		contato.setIdpet(request.getParameter("idpet"));
		animais.setNomepet(request.getParameter("nomepet"));
		animais.setEspecie(request.getParameter("especie"));
		animais.setIdade(request.getParameter("idade"));
		animais.setSexo(request.getParameter("sexo"));
		animais.setSituacao(request.getParameter("situacao"));
		dao.alterarAnimais(animais);
		response.sendRedirect("mainAnimais"); /* Mudar*/

	}

	/**
	 * Remover animais.
	 *
	 * @param request the request
	 * @param response the response
	 * @throws ServletException the servlet exception
	 * @throws IOException Signals that an I/O exception has occurred.
	 */
	protected void removerAnimais(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		animais.setIdcon(request.getParameter("idpet")); /* MUDAR */
		dao.deletarAnimais(animais);
		response.sendRedirect("mainAnimais");
	}

	/**
	 * Gerar relatorio.
	 *
	 * @param request the request
	 * @param response the response
	 * @throws ServletException the servlet exception
	 * @throws IOException Signals that an I/O exception has occurred.
	 */
	protected void gerarRelatoriopet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Document documento = new Document();
		try {
			response.setContentType("apllication/pdf");
			response.addHeader("Content-Disposition", "inline; filename=" + "animais.pdf");
			PdfWriter.getInstance(documento, response.getOutputStream());
			documento.open();
			documento.add(new Paragraph("Lista de animais:"));
			documento.add(new Paragraph(" "));
			PdfPTable tabela = new PdfPTable(6);
			PdfPCell col1 = new PdfPCell(new Paragraph("Idpet"));
			PdfPCell col2 = new PdfPCell(new Paragraph("Nome do pet"));
			PdfPCell col3 = new PdfPCell(new Paragraph("Especie"));
			PdfPCell col4 = new PdfPCell(new Paragraph("Idade"));
			PdfPCell col5 = new PdfPCell(new Paragraph("Sexo"));
			PdfPCell col6 = new PdfPCell(new Paragraph("Situacao"));
			tabela.addCell(col1);
			tabela.addCell(col2);
			tabela.addCell(col3);
			tabela.addCell(col4);
			tabela.addCell(col5);
			tabela.addCell(col6);
			ArrayList<JavaBeans> lista = dao.listarAnimais();
			for (int i = 0; i < lista.size(); i++) {
				tabela.addCell(lista.get(i).getIdpet());
				tabela.addCell(lista.get(i).getNomepet());
				tabela.addCell(lista.get(i).getEspecie());
				tabela.addCell(lista.get(i).getIdade());
				tabela.addCell(lista.get(i).getSexo());
				tabela.addCell(lista.get(i).getSituacao());
			}
			documento.add(tabela);
			documento.close();
		} catch (Exception e) {
			System.out.println(e);
			documento.close();
		}
	}
	
}
