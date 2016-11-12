import java.io.FileNotFoundException;
import java.awt.Dimension;
import java.io.File;
import java.io.IOException;
import java.util.Scanner;
import java.util.Stack;

import javax.swing.JFrame;

import edu.uci.ics.jung.algorithms.layout.TreeLayout;
import edu.uci.ics.jung.algorithms.layout.CircleLayout;
import edu.uci.ics.jung.algorithms.layout.Layout;
import edu.uci.ics.jung.algorithms.layout.PolarPoint;
import edu.uci.ics.jung.graph.DirectedSparseGraph;
import edu.uci.ics.jung.graph.Graph;
import edu.uci.ics.jung.graph.SparseMultigraph;
import edu.uci.ics.jung.graph.util.EdgeType;
import edu.uci.ics.jung.visualization.BasicVisualizationServer;
import edu.uci.ics.jung.visualization.decorators.ToStringLabeller;

public class Main {
	
	/**
	 * @param args
	 * @throws IOException
	 */
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		Scanner scan = null;

		Stack<Word> words = new Stack<Word>();

		// Read txt
		try {
			scan = new Scanner(new File("C:\\Users\\Auryon.AURYON-PC\\Documents\\GitHub\\java-works\\Graphs_JUNG\\teste.txt"));

			// scan = new Scanner(new File("C:\\Users\\Auryon.AURYON-PC\\Desktop\\flatWiki.txt"));

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}

		Graph<Word, Relacao> g = new SparseMultigraph<Word, Relacao>();
		
		Relacao word_type = new Relacao("connect");
		String s = scan.next();
		Word word = new Word(s);
		words.push(word);
		g.addVertex(word);

		while (scan.hasNextLine()) {
			System.out.println(scan);
			s = scan.next();
			System.out.println(s);
			word = new Word(s);
			g.addVertex(word);
			try {
				word_type = new Relacao("connect");
				g.addEdge(word_type,words.lastElement(),word,EdgeType.DIRECTED);
				words.push(word);
				
			} catch (Exception e) {

			}
			;

			System.out.println(g);
			System.out.println(words.size());
		}

		Layout<Word, Relacao> layout = new CircleLayout<Word, Relacao>(g);
		layout.setSize(new Dimension(300,300)); // sets the initial size of the
												// space
		// The BasicVisualizationServer<V,E> is parameterized by the edge types
		BasicVisualizationServer<Word, Relacao> vv = new BasicVisualizationServer<Word, Relacao>(layout);

		vv.setPreferredSize(new Dimension(350, 350)); // Sets the viewing area
														// size
		vv.getRenderContext().setVertexLabelTransformer(new ToStringLabeller());
		vv.getRenderContext().setEdgeLabelTransformer(new ToStringLabeller());
		vv.getRenderContext().setLabelOffset(20);

		JFrame frame = new JFrame("Simple Graph View");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().add(vv);
		frame.pack();
		frame.setVisible(true);

	}
}
