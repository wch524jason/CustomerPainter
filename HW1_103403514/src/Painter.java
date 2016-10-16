//姓名:吳承翰  學號:103403514 系級:資管系
import javax.swing.*;
import java.awt.*;

public class Painter 
{
	private static JFrame painterFrame = new JFrame();
	private static JLabel statusLabel = new JLabel("Mouse outside JPanel");
	
	//設定在painterFrame中位置的參數
	private static GridBagConstraints posParam = new GridBagConstraints();
	
	public static void main(String[] args) 
	{
		Painter painter = new Painter();
		painter.setView();
	}
	
	public void setView()
	{
		painterFrame.setLayout(new GridBagLayout());
		
		//把ToolbarPanel加入painterFrame
		ToolBar toolbar = new ToolBar();
		Painter.setPanelParams(0, 0, 1, 1, 0, 0, GridBagConstraints.BOTH, GridBagConstraints.WEST);
		painterFrame.add(toolbar.getToolBarPanel(), posParam);
				
		//把CanvasPanel加入painterFrame
		Canvas canvas = new Canvas();
		Painter.setPanelParams(1, 0, 1, 1, 1, 1, GridBagConstraints.BOTH, GridBagConstraints.EAST);
		painterFrame.add(canvas.getCanvasPanel(),posParam);
				
		//把StatusColumnLabel加入painterFrame
		Painter.setPanelParams(0, 1, 2, 1, 1, 1, GridBagConstraints.BOTH, GridBagConstraints.CENTER);
		painterFrame.add(statusLabel,posParam);
				
		painterFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		painterFrame.setSize(400,400);
		painterFrame.setVisible(true);
	}
	
	public static void setPanelParams(int gridx,int gridy,int gridwidth,int gridheight,int weightx,int weighty,int fillConstant,int anchorConstant)
	{
		posParam.gridx = gridx;
		posParam.gridy = gridy;
		posParam.gridwidth = gridwidth;
		posParam.gridheight = gridheight;
		posParam.weightx = weightx;
		posParam.weighty = weighty;
		posParam.fill = fillConstant;
		posParam.anchor = anchorConstant;
	}
	
	public static JLabel getStatusLabel()
	{
		return statusLabel;
	}
}
