class Solution {
    public String solveEquation(String equation) {
        
        int[] left = solve(equation.substring(0, equation.indexOf('=')));
        int[] right = solve(equation.substring(equation.indexOf('=') + 1));
        int x = left[0] - right[0];
        int num = right[1] - left[1];
        if (x == 0 && num == 0) {
            return "Infinite solutions";
        } else if (x == 0 && num != 0) {
            return "No solution";
        } else {
            return "x=" + num / x;
        }
    }
    
    private int[] solve(String exp) {
        String[] tokens = exp.split("(?=[-+])");
        int x = 0, num = 0;
        for (String token : tokens) {
            if (token.equals("+x") || token.equals("x")) {
                x++;
            } else if (token.equals("-x")) {
                x--;
            } else if (token.contains("x")) {
                x += Integer.parseInt(token.substring(0, token.indexOf("x")));
            } else {
                num += Integer.parseInt(token);
            }
        }
        return new int[]{x, num};
    }
}