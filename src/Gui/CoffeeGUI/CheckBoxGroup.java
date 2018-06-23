package Gui.CoffeeGUI;

import java.awt.*;
import java.util.*;
import javax.swing.*;

public class CheckBoxGroup
{
    private Set<GroupButtonModel> models = new HashSet<GroupButtonModel>();
    private int groupSize;

    public CheckBoxGroup(int groupSize)
    {
        this.groupSize = groupSize;
    }

    public void register(JCheckBox checkBox)
    {
        ButtonModel groupModel = new GroupButtonModel();
        groupModel.setSelected ( checkBox.getModel().isSelected() );
        checkBox.setModel( groupModel );
    }


    private class GroupButtonModel extends JToggleButton.ToggleButtonModel
    {
        @Override
        public void setSelected(boolean selected)
        {
            if (!selected)
            {
                models.remove( this );
                super.setSelected( selected );
                return;
            }

            //  Check number of currently selected check boxes

            if (models.size() == groupSize)
            {
                System.out.println("Only " + groupSize + " items can be selected");
            }
            else
            {
                models.add( this );
                super.setSelected( selected );
            }

        }
    }

    public static void createAndShowGUI()
    {
        JPanel panel = new JPanel();
        CheckBoxGroup group = new CheckBoxGroup(3);

        for (int i = 0; i < 10; i++)
        {
            JCheckBox checkBox = new JCheckBox( String.valueOf(i) );
            panel.add( checkBox );
            group.register( checkBox );
        }

        JFrame frame = new JFrame("Check Box Group");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add( panel );
        frame.setLocationByPlatform( true );
        frame.pack();
        frame.setVisible( true );
    }

    public static void main(String[] args)
    {
        EventQueue.invokeLater(new Runnable()
        {
            public void run()
            {
                createAndShowGUI();
            }
        });
    }
}