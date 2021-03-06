package br.edu.ufabc.progradweb.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.edu.ufabc.progradweb.jdbc.AlunoBD;
import br.edu.ufabc.progradweb.modelo.Aluno;

@WebServlet("/altera")
public class AlteraServlet extends HttpServlet {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		PrintWriter out = resp.getWriter();
		// obtem parametros do request
		Long ID = Long.parseLong(req.getParameter("ID"));
		String nome = req.getParameter("nome");
		String email = req.getParameter("email");
		String endereco = req.getParameter("endereco");
		// instancia objeto Aluno
		Aluno aluno = new Aluno();
		aluno.setId(ID);
		aluno.setNome(nome);
		aluno.setEmail(email);
		aluno.setEndereco(endereco);
		AlunoBD bd = new AlunoBD();
		bd.altera(aluno); // salva no BD
		// escreve a pagina que sera enviada como resposta
		out.println("<html>");
		out.println("<body>");
		out.println("<h2>Aluno " + aluno.getNome() + " alterado com sucesso!<h2>");
		out.println("</body>");
		out.println("</html>");
	}
}
