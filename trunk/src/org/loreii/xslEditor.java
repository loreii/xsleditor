package org.loreii;
import java.awt.FlowLayout;

import java.awt.GraphicsConfiguration;
import java.awt.GridLayout;
import java.awt.LayoutManager;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;

import javax.swing.*;
import javax.swing.border.BevelBorder;
import javax.swing.text.StyledEditorKit;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Result;
import javax.xml.transform.Source;
import javax.xml.transform.SourceLocator;
import javax.xml.transform.Templates;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMResult;
import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.stream.StreamSource;

import jsyntaxpane.DefaultSyntaxKit;

import org.w3c.dom.Document;

/*
 * Simple XSL editor tool
Copyright (C) 2009  Lorenzo Pavesi

 * This program is free software; you can redistribute it and/or
modify it under the terms of the GNU General Public License
as published by the Free Software Foundation; either version 2
of the License, or (at your option) any later version.

This program is distributed in the hope that it will be useful,
but WITHOUT ANY WARRANTY; without even the implied warranty of
MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
GNU General Public License for more details.

You should have received a copy of the GNU General Public License
along with this program; if not, write to the Free Software
Foundation, Inc., 51 Franklin Street, Fifth Floor, Boston, MA  02110-1301, USA.
 * */
public class xslEditor extends javax.swing.JFrame {

	
	private static final String APPNAME = "XSLT Editor";


	{
		//Set Look & Feel
		try {
			javax.swing.UIManager.setLookAndFeel("com.jgoodies.looks.plastic.Plastic3DLookAndFeel");
		} catch(Exception e) {
			e.printStackTrace();
		}
	}


	private JMenuItem helpMenuItem;
	private JMenu jMenu5;
	private JEditorPane xsl;
	private JScrollPane jScrollPane1;
	private JScrollPane jScrollPane2;
	private JScrollPane jScrollPane3;
	private JButton compile;
	private JEditorPane out;
	private JEditorPane src;
	private JPanel mainPanel;
	private JMenuItem deleteMenuItem;
	private JSeparator jSeparator1;
	private JMenuItem pasteMenuItem;
	private JMenuItem copyMenuItem;
	private JMenuItem cutMenuItem;
	private JMenu jMenu4;
	private JMenuItem exitMenuItem;
	private JSeparator jSeparator2;
	private JMenuItem closeFileMenuItem;
	private JMenuItem saveAsMenuItem;
	private JMenuItem saveMenuItem;
	private JSplitPane jSplitPane1;
	private JPanel jPanel4;
	private JTextArea debug;
	private JMenuItem openFileMenuItem;
	private JMenuItem newFileMenuItem;
	private JMenu jMenu3;
	private JMenuBar jMenuBar1;

	/**
	* Auto-generated main method to display this JFrame
	*/
	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				xslEditor inst = new xslEditor();
				inst.setLocationRelativeTo(null);
				inst.setVisible(true);
			}
		});
	}
	
	public xslEditor() {
		super(APPNAME);
		initGUI();
	}
	
	private void initGUI() {
		try {
			BoxLayout thisLayout = new BoxLayout(getContentPane(), javax.swing.BoxLayout.Y_AXIS);
			getContentPane().setLayout(thisLayout);
			{
				mainPanel = new JPanel();
				GridLayout mainPanelLayout = new GridLayout(1, 1);
				mainPanelLayout.setHgap(5);
				mainPanelLayout.setVgap(5);
				mainPanelLayout.setColumns(1);
				mainPanelLayout.setRows(1);
				mainPanel.setLayout(mainPanelLayout);
				getContentPane().add(mainPanel);
				mainPanel.setMaximumSize(new java.awt.Dimension(32767, 32767));
				mainPanel.setSize(598, 9);
				mainPanel.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(0,0,0)));
				mainPanel.setPreferredSize(new java.awt.Dimension(598, 266));
				new StyledEditorKit();
				DefaultSyntaxKit.initKit();
				 
				{
					jScrollPane1 = new JScrollPane();
					mainPanel.add(jScrollPane1);
					jScrollPane1.setPreferredSize(new java.awt.Dimension(126, 198));
					{
						src = new JEditorPane();
						jScrollPane1.setViewportView(src);
						src.setText("src");
						src.setContentType("text/xml");
					
					}
					
				}
				{
					jScrollPane2 = new JScrollPane();
					mainPanel.add(jScrollPane2);
					jScrollPane2.setPreferredSize(new java.awt.Dimension(126, 198));
					{
						xsl =  new JEditorPane();
						jScrollPane2.setViewportView(xsl);
						xsl.setText("xls");
						xsl.setContentType("text/xml");
					}
				}
				{
					jScrollPane3 = new JScrollPane();
					mainPanel.add(jScrollPane3);
					jScrollPane3.setPreferredSize(new java.awt.Dimension(126, 198));
					{
						out =  new JEditorPane();
						jScrollPane3.setViewportView(out);
						out.setText("out");
						out.setContentType("text/xml");
					}
				}
			}
			{
				jPanel4 = new JPanel();
				getContentPane().add(jPanel4);
				FlowLayout jPanel4Layout = new FlowLayout();
				jPanel4.setLayout(jPanel4Layout);
				jPanel4.setPreferredSize(new java.awt.Dimension(598, 46));
				{
					compile = new JButton();
					jPanel4.add(compile);
					compile.setText("Compile");
					compile.addMouseListener(new MouseAdapter() {
						public void mouseClicked(MouseEvent evt) {
							compileMouseClicked(evt);
						}
					});
				}
				{
					
					
					{
						debug = new JTextArea();
						jPanel4.add(debug);
						debug.setPreferredSize(new java.awt.Dimension(595, 41));
						debug.setText("Debug");
					}
				}
			}
			this.setSize(608, 415);
			{
				jMenuBar1 = new JMenuBar();
				setJMenuBar(jMenuBar1);
				{
					jMenu3 = new JMenu();
					jMenuBar1.add(jMenu3);
					jMenu3.setText("File");
					{
						newFileMenuItem = new JMenuItem();
						jMenu3.add(newFileMenuItem);
						newFileMenuItem.setText("New");
					}
					{
						openFileMenuItem = new JMenuItem();
						jMenu3.add(openFileMenuItem);
						openFileMenuItem.setText("Open");
					}
					{
						saveMenuItem = new JMenuItem();
						jMenu3.add(saveMenuItem);
						saveMenuItem.setText("Save");
					}
					{
						saveAsMenuItem = new JMenuItem();
						jMenu3.add(saveAsMenuItem);
						saveAsMenuItem.setText("Save As ...");
					}
					{
						closeFileMenuItem = new JMenuItem();
						jMenu3.add(closeFileMenuItem);
						closeFileMenuItem.setText("Close");
					}
					{
						jSeparator2 = new JSeparator();
						jMenu3.add(jSeparator2);
					}
					{
						exitMenuItem = new JMenuItem();
						jMenu3.add(exitMenuItem);
						exitMenuItem.setText("Exit");
					}
				}
				{
					jMenu4 = new JMenu();
					jMenuBar1.add(jMenu4);
					jMenu4.setText("Edit");
					{
						cutMenuItem = new JMenuItem();
						jMenu4.add(cutMenuItem);
						cutMenuItem.setText("Cut");
					}
					{
						copyMenuItem = new JMenuItem();
						jMenu4.add(copyMenuItem);
						copyMenuItem.setText("Copy");
					}
					{
						pasteMenuItem = new JMenuItem();
						jMenu4.add(pasteMenuItem);
						pasteMenuItem.setText("Paste");
					}
					{
						jSeparator1 = new JSeparator();
						jMenu4.add(jSeparator1);
					}
					{
						deleteMenuItem = new JMenuItem();
						jMenu4.add(deleteMenuItem);
						deleteMenuItem.setText("Delete");
					}
				}
				{
					jMenu5 = new JMenu();
					jMenuBar1.add(jMenu5);
					jMenu5.setText("Help");
					{
						helpMenuItem = new JMenuItem();
						jMenu5.add(helpMenuItem);
						helpMenuItem.setText("Help");
					}
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	private void compileMouseClicked(MouseEvent evt) {
		System.out.println("compile.mouseClicked, event="+evt);
		String doc = xsl(src.getText(),xsl.getText());
		out.setText(doc);
	}
	

	public String xsl(String src, String xsl) {
        try {
        	ByteArrayOutputStream baos = new ByteArrayOutputStream();
        	
            // Create transformer factory
            TransformerFactory factory = TransformerFactory.newInstance();

            // Use the factory to create a template containing the xsl file
            Templates template = factory.newTemplates(new StreamSource( new ByteArrayInputStream(xsl.getBytes())));

            // Use the template to create a transformer
            Transformer xformer = template.newTransformer();

            // Prepare the input and output files
            Source source = new StreamSource( new ByteArrayInputStream(src.getBytes()));
            
// 			  Create a new document to hold the results
//            DocumentBuilder builder = DocumentBuilderFactory.newInstance().newDocumentBuilder();
//            Document doc = builder.newDocument();
           
            
            Result result = new StreamResult(baos);
            
            // Apply the xsl file to the source file and write the result to the output file
            
			xformer.transform(source,result);
            String res = new String(baos.toByteArray());
            this.debug.append(" - Transformation done\n");
            return res;
        } catch (TransformerException e) {
        	e.printStackTrace();
        	this.debug.append(e.getMessage());
            // An error occurred while applying the XSL file
            // Get location of error in input file
            SourceLocator locator = e.getLocator();
            int col = locator.getColumnNumber();
            int line = locator.getLineNumber();
            String publicId = locator.getPublicId();
            String systemId = locator.getSystemId();
            this.debug.append("\n\n"+publicId+"\n"+systemId+"\n  col : "+col+"  line:"+line+"\n");
        }
        return null;
    }
	

}
