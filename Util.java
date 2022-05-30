import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.SystemColor;
import javax.swing.JTextField;
public class Util {

	
	public Util() {

	}

	public static void changeWarning(Component mngObject) {
		mngObject.setFont(new Font("Tahoma", Font.BOLD, 18));
		mngObject.setForeground(Color.RED);
		mngObject.setBackground(SystemColor.info);
	}

	public static void changeInput(Component mngObject) {
		mngObject.setFont(new Font("Tahoma", Font.BOLD, 18));
		mngObject.setForeground(Color.BLUE);
		mngObject.setBackground(SystemColor.WHITE);
		mngObject.setBounds(86, 63, 398, 39);
		((JTextField)mngObject).setColumns(10);

	}

	
}
