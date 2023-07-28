class Solution {
    public String solveEquation(String equation) {
        
        int x = 0;
        int c = 0;
        String[] parts = equation.split("=");
        String left = parts[0];
        String right = parts[1];
        String[] leftParts = left.split("(?=[+-])");
        String[] rightParts = right.split("(?=[+-])");
        for (String part : leftParts) {
            if (part.equals("x") || part.equals("+x")) {
                x += 1;
            } else if (part.equals("-x")) {
                x -= 1;
            } else if (part.contains("x")) {
                x += Integer.parseInt(part.substring(0, part.length() - 1));
            } else {
                c -= Integer.parseInt(part);
            }
        }
        for (String part : rightParts) {
            if (part.equals("x") || part.equals("+x")) {
                x -= 1;
            } else if (part.equals("-x")) {
                x += 1;
            } else if (part.contains("x")) {
                x -= Integer.parseInt(part.substring(0, part.length() - 1));
            } else {
                c += Integer.parseInt(part);
            }
        }
        if (x == 0 && c == 0) {
            return "Infinite solutions";
        } else if (x == 0) {
            return "No solution";
        } else {
            return "x=" + c / x;
        }
    }
}