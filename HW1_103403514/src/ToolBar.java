import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

public class ToolBar 
{
	private JPanel toolBarPanel;
	private JLabel label1               = new JLabel("[繪圖工具]");
	private final String[] options      = new String[]{"筆刷","直線","橢圓形","矩形","圓角矩形"};
	private JComboBox selectTools       = new JComboBox(options);
	private JRadioButton smallRButton   = new JRadioButton("小",true);
	private JRadioButton middleRButton  = new JRadioButton("中",false);
	private JRadioButton largeRButton   = new JRadioButton("大",false);
	private ButtonGroup sizeButtonGroup     = new ButtonGroup();
	private JLabel label2               = new JLabel("[筆刷大小]");
	private JCheckBox fillUpCheckBox    = new JCheckBox("填滿");
	private JButton foregroundButton    = new JButton("前景色");
	private JButton backgroundButton    = new JButton("背景色");
	private JButton clearViewButton     = new JButton("清除畫面");
	private boolean isFull =true;
	
	public ToolBar()
	{
		toolBarPanel = new JPanel();
		toolBarPanel.setLayout(new BoxLayout(toolBarPanel,BoxLayout.Y_AXIS));
		//toolBarPanel.setBackground(new Color(0, 212, 255));
		
		//繪圖工具文字label
		toolBarPanel.add(label1);
		
		//下拉選單ComboBox
		selectTools.setMaximumRowCount(options.length);
		selectTools.addItemListener(new ComboBoxHandler());
		toolBarPanel.add(selectTools);
		
		//筆刷大小文字label
		toolBarPanel.add(label2);
		
		//筆刷大小選項RadioButton
		sizeButtonGroup.add(smallRButton);
		sizeButtonGroup.add(middleRButton);
		sizeButtonGroup.add(largeRButton);
		toolBarPanel.add(smallRButton);
		toolBarPanel.add(middleRButton);
		toolBarPanel.add(largeRButton);
		smallRButton.addItemListener(new RadioButtonHandler());
		middleRButton.addItemListener(new RadioButtonHandler());
		largeRButton.addItemListener(new RadioButtonHandler());
		
		//填滿CheckBox
		toolBarPanel.add(fillUpCheckBox);
		fillUpCheckBox.addItemListener(new CheckBoxHandler());
		
		//三個按鈕
		toolBarPanel.add(foregroundButton);
		toolBarPanel.add(backgroundButton);
		toolBarPanel.add(clearViewButton);
		foregroundButton.addActionListener(new ButtonHandler());
		backgroundButton.addActionListener(new ButtonHandler());
		clearViewButton.addActionListener(new ButtonHandler());
	}
	
	public JPanel getToolBarPanel()
	{
		return toolBarPanel;
	}
	
	//ComboBox的Listener
	private class ComboBoxHandler implements ItemListener
	{
		public void itemStateChanged(ItemEvent event)
		{
			if(event.getStateChange() == ItemEvent.SELECTED)
			{
				JOptionPane.showMessageDialog(null, "你點選了: "+event.getItem().toString(),"訊息",JOptionPane.PLAIN_MESSAGE);
			}
		}
	}
	
	//RadioButton的Listener
	private class RadioButtonHandler implements ItemListener
	{
		public void itemStateChanged(ItemEvent event) 
		{
			if(event.getStateChange() == ItemEvent.SELECTED)
			{
				String output = "";
				output = smallRButton.isSelected()?"小":(middleRButton.isSelected()?"中":"大");
				JOptionPane.showMessageDialog(null, "你點選了: "+output,"訊息",JOptionPane.PLAIN_MESSAGE);
			}
		}	
	}
	
	//CheckBox的Listener
	private class CheckBoxHandler implements ItemListener
	{
		
		public void itemStateChanged(ItemEvent event) 
		{
			if(isFull)
			{
				isFull =false;
				System.out.println("你選擇了填滿");
			}
			else
			{
				isFull=true;
				System.out.println("你取消了填滿");
			}
			
		}
	}
	
	//JButton的Listener
	private class ButtonHandler implements ActionListener
	{
		@Override
		public void actionPerformed(ActionEvent event) 
		{
			JOptionPane.showMessageDialog(null, "你點選了: "+event.getActionCommand(),"訊息",JOptionPane.PLAIN_MESSAGE);
		}
	}
}