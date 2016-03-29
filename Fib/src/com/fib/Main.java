package com.fib;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.wb.swt.SWTResourceManager;

public class Main {

	private static Label lblFib;
	private static int count = 0;
	private static final int MAX_FIB = 50000;

	private static int fib_r(int nth) {
		if (nth == 0)
			return 0;
		if (nth == 1)
			return 1;
		return fib_r(nth-2) + fib_r(nth-1);
	}

	private static int fib_e(int nth) {
		int f0 = 1;
		int f1 = 1;
		int tmp = f1;
		if (nth == 0)
			return f0;
		if (nth == 1)
			return f1;
		for (int i = 2; i < nth; i++)
		{
			tmp = f0 + f1;

			f0 = f1;
			f1 = tmp;
		}
		return tmp;


	}
	public static void main(String[] args) {
		Display display = new Display ();
		Shell shlFibonacci = new Shell(display);
		shlFibonacci.setText("fibonacci");

		lblFib = new Label(shlFibonacci, SWT.NONE);
		lblFib.setAlignment(SWT.CENTER);
		lblFib.setFont(SWTResourceManager.getFont("Segoe MDL2 Assets", 26, SWT.BOLD));
		lblFib.setBounds(0, 0, 432, 253);
		lblFib.setText("1");

		//shell.pack();
		shlFibonacci.open ();
		while (!shlFibonacci.isDisposed ()) {
			if (!display.readAndDispatch ()) {
				int f = fib_e(count++);
				if (count == ((int)(Math.random() * MAX_FIB)))
					count = 0;
				lblFib.setText(String.format("%d", f));

				display.sleep ();
			}
		}
		display.dispose ();
	}
}

