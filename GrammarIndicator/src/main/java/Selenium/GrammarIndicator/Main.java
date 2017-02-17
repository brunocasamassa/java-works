import java.io.FileNotFoundException;
import java.awt.Dimension;
import java.io.File;
import java.io.IOException;
import java.util.Collection;
import java.util.HashMap;
import java.util.Scanner;
import java.util.Stack;

import javax.swing.JFrame;

import org.apache.commons.collections15.BidiMap;
import org.apache.commons.collections15.bidimap.DualHashBidiMap;

import edu.uci.ics.jung.algorithms.layout.TreeLayout;
import edu.uci.ics.jung.algorithms.layout.CircleLayout;
import edu.uci.ics.jung.algorithms.layout.Layout;
import edu.uci.ics.jung.algorithms.layout.PolarPoint;import edu.uci.ics.jung.graph.DirectedSparseGraph;
import edu.uci.ics.jung.graph.Graph;
import edu.uci.ics.jung.graph.SparseMultigraph;
import edu.uci.ics.jung.graph.event.GraphEvent.Vertex;
import edu.uci.ics.jung.graph.util.EdgeType;
import edu.uci.ics.jung.visualization.BasicVisualizationServer;
import edu.uci.ics.jung.visualization.decorators.ToStringLabeller;

public class Main {

	/**
	 * 
	 * @param args
	 * @throws IOException
	 * 
	 */

	// BEGIN DEEP SEARCH

	Stack<Word> pilha;

	public void buscaLargura(Graph<Word, Relacao> g1, Word n0) {
		int camadas = 1;
		int cont = 0;
		Graph<Word, Relacao> g2 = new SparseMultigraph<Word, Relacao>();
		HashMap<Integer, Word> visitados = new HashMap<Integer, Word>();
		pilha = new Stack<Word>();
		pilha.add(n0);
		g2.addVertex(n0);
		Word n = pilha.firstElement();
		marcarVisitado(n, visitados);
		while (!pilha.isEmpty()) {
			Word no_tmp = pilha.pop();
			Collection<Word> adjacencias = g1.getNeighbors(no_tmp);
			System.out.println(adjacencias);
			for (Word adjacente : adjacencias) {
				if (!foiVisitado(adjacente, visitados)) {
					marcarVisitado(adjacente, visitados);
					Relacao word_type = new Relacao("");
					g2.addVertex(adjacente);
					g2.addEdge(word_type, no_tmp, adjacente, EdgeType.DIRECTED);
					// System.out.println(visitados);
					if (cont < camadas) {
						pilha.push(adjacente);
						cont++;
					}

				}
			}
		}
		renderiza(g2);
	}

	private void renderiza(Graph<Word, Relacao> g1) {
		// RENDERIZA GRAFO
		Layout<Word, Relacao> layout = new CircleLayout<Word, Relacao>(g1);
		layout.setSize(new Dimension(800, 600)); // sets the initial size of the
													// space
		// The BasicVisualizationServer<V,E> is parameterized by the edge types

		BasicVisualizationServer<Word, Relacao> vv = new BasicVisualizationServer<Word, Relacao>(layout);

		vv.setPreferredSize(new Dimension(800, 600)); // Sets the viewing area
														// size
		vv.getRenderContext().setVertexLabelTransformer(new ToStringLabeller());
		vv.getRenderContext().setEdgeLabelTransformer(new ToStringLabeller());
		vv.getRenderContext().setLabelOffset(20);

		JFrame frame = new JFrame("WORD INDICATOR");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().add(vv);
		frame.pack();
		frame.setVisible(true);

	}

	boolean foiVisitado(Word adjacente, HashMap<Integer, Word> visitados) {

		return visitados.containsKey(adjacente.getId());

	}

	private void marcarVisitado(Word n, HashMap<Integer, Word> visitados) {
		visitados.put(n.getId(), n);

	}

	// DEEP SEARCH END
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		Scanner scan = null;

		Stack<Word> words = new Stack<Word>();
		Stack<String> wordsString = new Stack<String>();
		// CRIA GRAFO
		// Read txt

		try {
			scan = new Scanner(
					
					//new File("C:\\Users\\Auryon.AURYON-PC\\workspace\\Copy of GRAPHS_JUNG\\Classe0.txt"));
							new File("C:\\Users\\Auryon.AURYON-PC\\Documents\\GitHub\\java-works\\Graphs_JUNG\\teste.txt"));
			// scan = new Scanner(new
			// File("C:\\Users\\Auryon.AURYON-PC\\Desktop\\flatWiki.txt"));

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}

		Graph<Word, Relacao> g = new SparseMultigraph<Word, Relacao>();
		Relacao word_type = new Relacao(" ");
		String s = scan.next();
		System.out.println(s);
		int i = 1;
		Word word = new Word(s);
		word.setId(i);
		words.push(word);
		wordsString.push(s);
		g.addVertex(word);
		Collection<Word> nos = null;
		BidiMap<Integer, String> bLista = new DualHashBidiMap<Integer, String>();
		HashMap<Integer, Word> lista = new HashMap<Integer, Word>();
			//ESTOU CRIANDO O GRAFO AQUI
		while (scan.hasNextLine()) {
			try {
				s = scan.next();
				//LOGICAS PARA CASOS REPETIDOS
				
				if (!wordsString.contains(s)) {
					word = new Word(s);
					i++;
					word.setId(i);
					lista.put(word.getId(), word);
					word_type = new Relacao("");
					g.addVertex(word);
					g.addEdge(word_type, words.lastElement(), word, EdgeType.DIRECTED);
					words.push(word);
					lista.put(i,word);	
					bLista.put(i, s);
				} else {
					int t = bLista.getKey(s);
					Word word2 = lista.get(t);//preciso da chave do nó);
					int verify = word2.getId();
					word = lista.get(verify);
					word_type = new Relacao("");
					g.addEdge(word_type, words.lastElement(), word, EdgeType.DIRECTED);
					words.push(word);
				}
				wordsString.push(s);
				;
			} catch (Exception e) {
			}
			;
			
			//TERMINA GRAFO
			/**/

			// System.out.println(g);
			// System.out.println(words.size());
		}
		;
		Main busca = new Main();
		// Collection<Word> vertices = words;
		System.out.println(g); 
		//VERIFICA NÓ DE PARTIDA (INPUT DO USUARIO)
		System.out.println("SELECIONE A PALAVRA PELO ID:  " + lista); 
		//VERIFICA ID DO HASHMAP DA CLASSE GRAMATICAL
		int trigger = 21; 
		Word target = lista.get(trigger);
		// System.out.println(vertices.stream());
		// System.out.println(vertices);
		Word p = target; // parametro busca	
		// Word p = vertices.iterator().next();
		System.out.println("TARGET: " + p);

		busca.buscaLargura(g, p);

		// TERMINA GRAFO

	}

}
