import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

public class ToolBar 
{
	private JPanel toolBarPanel;
	private JLabel label1               = new JLabel("[ø�Ϥu��]");
	private final String[] options      = new String[]{"����","���u","����","�x��","�ꨤ�x��"};
	private JComboBox selectTools       = new JComboBox(options);
	private JRadioButton smallRButton   = new JRadioButton("�p",true);
	private JRadioButton middleRButton  = new JRadioButton("��",false);
	private JRadioButton largeRButton   = new JRadioButton("�j",false);
	private ButtonGroup sizeButtonGroup     = new ButtonGroup();
	private JLabel label2               = new JLabel("[����j�p]");
	private JCheckBox fillUpCheckBox    = new JCheckBox("��");
	private JButton foregroundButton    = new JButton("�e����");
	private JButton backgroundButton    = new JButton("�I����");
	private JButton clearViewButton     = new JButton("�M���e��");
	private boolean isFull =true;
	
	public ToolBar()
	{
		toolBarPanel = new JPanel();
		toolBarPanel.setLayout(new BoxLayout(toolBarPanel,BoxLayout.Y_AXIS));
		//toolBarPanel.setBackground(new Color(0, 212, 255));
		
		//ø�Ϥu���rlabel
		toolBarPanel.add(label1);
		
		//�U�Կ��ComboBox
		selectTools.setMaximumRowCount(options.length);
		selectTools.addItemListener(new ComboBoxHandler());
		toolBarPanel.add(selectTools);
		
		//����j�p��rlabel
		toolBarPanel.add(label2);
		
		//����j�p�ﶵRadioButton
		sizeButtonGroup.add(smallRButton);
		sizeButtonGroup.add(middleRButton);
		sizeButtonGroup.add(largeRButton);
		toolBarPanel.add(smallRButton);
		toolBarPanel.add(middleRButton);
		toolBarPanel.add(largeRButton);
		smallRButton.addItemListener(new RadioButtonHandler());
		middleRButton.addItemListener(new RadioButtonHandler());
		largeRButton.addItemListener(new RadioButtonHandler());
		
		//��CheckBox
		toolBarPanel.add(fillUpCheckBox);
		fillUpCheckBox.addItemListener(new CheckBoxHandler());
		
		//�T�ӫ��s
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
	
	//ComboBox��Listener
	private class ComboBoxHandler implements ItemListener
	{
		public void itemStateChanged(ItemEvent event)
		{
			if(event.getStateChange() == ItemEvent.SELECTED)
			{
				JOptionPane.showMessageDialog(null, "�A�I��F: "+event.getItem().toString(),"�T��",JOptionPane.PLAIN_MESSAGE);
			}
		}
	}
	
	//RadioButton��Listener
	private class RadioButtonHandler implements ItemListener
	{
		public void itemStateChanged(ItemEvent event) 
		{
			if(event.getStateChange() == ItemEvent.SELECTED)
			{
				String output = "";
				output = smallRButton.isSelected()?"�p":(middleRButton.isSelected()?"��":"�j");
				JOptionPane.showMessageDialog(null, "�A�I��F: "+output,"�T��",JOptionPane.PLAIN_MESSAGE);
			}
		}	
	}
	
	//CheckBox��Listener
	private class CheckBoxHandler implements ItemListener
	{
		
		public void itemStateChanged(ItemEvent event) 
		{
			if(isFull)
			{
				isFull =false;
				System.out.println("�A��ܤF��");
			}
			else
			{
				isFull=true;
				System.out.println("�A�����F��");
			}
			
		}
	}
	
	//JButton��Listener
	private class ButtonHandler implements ActionListener
	{
		@Override
		public void actionPerformed(ActionEvent event) 
		{
			JOptionPane.showMessageDialog(null, "�A�I��F: "+event.getActionCommand(),"�T��",JOptionPane.PLAIN_MESSAGE);
		}
	}
}