package com.github.hykes.codegen.configurable.ui;

import com.github.hykes.codegen.configurable.SettingManager;
import com.github.hykes.codegen.configurable.UIConfigurable;
import com.github.hykes.codegen.configurable.model.Configs;
import com.intellij.ui.IdeBorderFactory;
import com.intellij.uiDesigner.core.GridConstraints;
import com.intellij.uiDesigner.core.GridLayoutManager;
import com.intellij.uiDesigner.core.Spacer;

import javax.swing.*;
import java.awt.*;

/**
 * @author: hehaiyang@terminus.io
 * @date: 2017/12/20
 */
public class ConfigUI implements UIConfigurable {
    private JPanel rootPanel;
    private JPanel ignorePanel;
    private JLabel ignoreLab;
    private JTextField ignoreTextField;

    private final static SettingManager settingManager = SettingManager.getInstance();

    public ConfigUI() {
        $$$setupUI$$$();
        ignoreTextField.setText(settingManager.getConfigs().getIgnoreFields());
    }

    private void createUIComponents() {
        // TODO: place custom component creation code here
        // 设置需要忽略的字段
        ignorePanel = new JPanel(new BorderLayout());
        ignorePanel.setBorder(IdeBorderFactory.createTitledBorder("The fields you want to ignore", true));

    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Test");
        frame.setContentPane(new ConfigUI().rootPanel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }

    /**
     * 是否已修改
     *
     * @return
     */
    @Override
    public boolean isModified() {
        Configs configs = settingManager.getConfigs();
        if (!configs.getIgnoreFields().equals(ignoreTextField.getText())) {
            return true;
        }
        return false;
    }

    /**
     * 应用
     */
    @Override
    public void apply() {
        settingManager.getConfigs().setIgnoreFields(ignoreTextField.getText());
    }

    /**
     * 重置
     */
    @Override
    public void reset() {
        ignoreTextField.setText(settingManager.getConfigs().getIgnoreFields());
    }

    /**
     * Method generated by IntelliJ IDEA GUI Designer
     * >>> IMPORTANT!! <<<
     * DO NOT edit this method OR call it in your code!
     *
     * @noinspection ALL
     */
    private void $$$setupUI$$$() {
        createUIComponents();
        rootPanel = new JPanel();
        rootPanel.setLayout(new GridLayoutManager(2, 1, new Insets(0, 0, 0, 0), -1, -1));
        ignorePanel.setLayout(new GridLayoutManager(1, 2, new Insets(0, 0, 0, 0), -1, -1));
        rootPanel.add(ignorePanel, new GridConstraints(0, 0, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_BOTH, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, null, null, null, 0, false));
        ignoreLab = new JLabel();
        ignoreLab.setText("IgnoreField");
        ignorePanel.add(ignoreLab, new GridConstraints(0, 0, 1, 1, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_FIXED, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        ignoreTextField = new JTextField();
        ignorePanel.add(ignoreTextField, new GridConstraints(0, 1, 1, 1, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_HORIZONTAL, GridConstraints.SIZEPOLICY_WANT_GROW, GridConstraints.SIZEPOLICY_FIXED, null, new Dimension(150, -1), null, 0, false));
        final Spacer spacer1 = new Spacer();
        rootPanel.add(spacer1, new GridConstraints(1, 0, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_VERTICAL, 1, GridConstraints.SIZEPOLICY_WANT_GROW, null, null, null, 0, false));
    }

    /**
     * @noinspection ALL
     */
    public JComponent $$$getRootComponent$$$() {
        return rootPanel;
    }
}
