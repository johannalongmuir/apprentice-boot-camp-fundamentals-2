package checkout;

class Receipt {

    private String text = "";
    private int numberOfA = 0;
    private int numberOfB = 0;

    String text(int total) {
        return text + "Total: " + total;
    }

    void scannedA() {
        text += "A: 50";
        if (++numberOfA % 5 == 0) {
            text += " - 30 (5 for 220)";
        }
        else {
        }
        text += "\n";
    }

    void scannedB() {
        text += "B: 30";
        if (++numberOfB % 2 == 0) {
            text += " - 15 (2 for 45)";
        }
        else {
        }
        text += "\n";
    }

    void scannedC() {
        text += "C: 20\n";
    }

    void scannedD() {
        text += "D: 15\n";
    }
}
