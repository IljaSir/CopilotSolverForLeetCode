class Solution {
    public String solveEquation(String equation) {
        
        String[] eq = equation.split("=");
        String[] left = eq[0].split("(?=[+-])");
        String[] right = eq[1].split("(?=[+-])");
        int[] leftEq = parseEquation(left);
        int[] rightEq = parseEquation(right);
        leftEq[0] -= rightEq[0];
        leftEq[1] = rightEq[1] - leftEq[1];
        if (leftEq[0] == 0 && leftEq[1] == 0) {
            return "Infinite solutions";
        } else if (leftEq[0] == 0) {
            return "No solution";
        } else {
            return "x=" + leftEq[1] / leftEq[0];
        }
    }
    
    private int[] parseEquation(String[] eq) {
        int[] res = new int[2];
        for (String s : eq) {
            if (s.equals("+x") || s.equals("x")) {
                res[0]++;
            } else if (s.equals("-x")) {
                res[0]--;
            } else if (s.contains("x")) {
                res[0] += Integer.parseInt(s.substring(0, s.length() - 1));
            } else {
                res[1] += Integer.parseInt(s);
            }
        }
        return res;
    }
}