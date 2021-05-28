/***************************************************************************************
* Beautify Text Table 2
*
* @author Corin Langosch (info@netskin.com)
* v1.0  (2011/04/05)
* @author Marcelo Gennari (margenn@gmail.com)
* v2.0  (2021/05/26) +showOptionDialog +StringBuilder(faster) +integrityCheck +metrics 
*
*   Corin|Langosch|info@netskin.com
*   Marcelo|Gennari|margenn@gmail.com
*
* becomes
*
*   Corin   | Langosch | info@netskin.com
*   Marcelo | Gennari  | margenn@gmail.com
*
***************************************************************************************/

void showDialog() {
	String[] options = new String[] {"Comma (,)", "Pipe (|)", "Semicolon (;)", "Tab"};
	int optionValue = JOptionPane.showOptionDialog (
		view // parent component
		, "Choose delimiter" // message
		, "Beautify Text Table"  // title
		, JOptionPane.DEFAULT_OPTION // optionType
		, JOptionPane.PLAIN_MESSAGE // messageType
		, null // icon
		, options // options
		, options[3] // initialValue
	);

	if (optionValue == 0) { beautifyTextTable(","); }
	else if (optionValue == 1) { beautifyTextTable("|"); }
	else if (optionValue == 2) { beautifyTextTable(";"); }
	else if (optionValue == 3) { beautifyTextTable("\\t"); }
}

void beautifyTextTable(separator) {
	long startTime = System.nanoTime();
	int firstLineColumns; String msg;
	String chrRegex = ("|".indexOf(separator) >= 0) ? "\\" + separator : separator;
	String text = textArea.getSelectedText();
	if (text == null) { return; }
	// Get all text into an array
	String[] lines = text.split("\\r?\\n");
	ArrayList rows = new ArrayList();
	ArrayList column_widths = new ArrayList();
	for (int i=0; i<lines.length; i++) {
		String line = lines[i];
		String[] cols = line.split(chrRegex);
		if (i == 0) {
			firstLineColumns = cols.length;
			if (firstLineColumns <= 1) {
				msg = "Just one column. Nothing to be done.";
				Macros.message(view, msg); view.getStatus().setMessageAndClear(msg);
				return;
			}
		} else {
			if (cols.length != firstLineColumns) {
				msg = "ERROR: Line " + ++i + " contains " + cols.length + " columns. Expected: " + firstLineColumns;
				Macros.message(view, msg); view.getStatus().setMessageAndClear(msg);
				return;
			}
		}
		for (int j=0; j<cols.length; j++) {
			String col = cols[j];
			if (j > 0) {
				col = col.trim();
				cols[j] = col;
			}
			Integer width = col.length();
			if (column_widths.size() <= j) {
				column_widths.add(width);
			} else {
				if (column_widths.get(j) < width) {
					column_widths.set(j, width);
				}
			}
		}
		rows.add(cols);
	}

	// Print array back into a formatted string
	if (separator.equals("\\t")) { separator = "|"; }
	String lineSeparator = "\n";
	int lastColumn = column_widths.size() - 1;
	int someReasonableIncrement = 10240;
	StringBuilder sb = new StringBuilder(text.length() + someReasonableIncrement);
	for (int i=0; i<rows.size(); i++) {
		String[] cols = rows.get(i);
		for (int j=0; j<column_widths.size(); j++) {
			String col = cols[j];
			Integer width = column_widths.get(j);
			Integer padding = width - col.length();
			if (j == 0) {
				sb.append(col+' ');
			} else {
				if (j != lastColumn) {
					sb.append(' '+col+' ');
				} else {
					sb.append(' '+col);
				}
			}
			if (j != lastColumn) {
				for (int k = 0; k < padding; k++) {
					sb.append(" ");
				}
				sb.append(separator);
			}
		}
		sb.append(lineSeparator);
	}
	textArea.setSelectedText(sb.toString());

	long endTime = System.nanoTime();
	long totalTime = (endTime - startTime) / 1000000;
	msg = "Lines:" + rows.size() + "  Columns:" + column_widths.size() + "  Time:" + totalTime + " ms";
	view.getStatus().setMessageAndClear(msg);
}

showDialog();
