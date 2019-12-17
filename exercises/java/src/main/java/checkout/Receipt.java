package checkout;

class Receipt {

    private String text = "";

    String text(int total) {
        return text + "Total: " + total;
    }

    void scannedA(int numberOfA) {
        text += "A: 50";
        if (numberOfA % 5 == 0) {
            text += " - 30 (5 for 220)";
        }
        text += "\n";
    }

    void scannedB(int numberOfB) {
        text += "B: 30";
        if (numberOfB % 2 == 0) {
            text += " - 15 (2 for 45)";
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
