class Solution {
    public String solveEquation(String equation) {
        
        String[] parts = equation.split("=");
        int[] left = evaluate(parts[0]);
        int[] right = evaluate(parts[1]);
        if (left[0] == right[0] && left[1] == right[1]) {
            return "Infinite solutions";
        } else if (left[0] == right[0]) {
            return "No solution";
        } else {
            return "x=" + (right[1] - left[1]) / (left[0] - right[0]);
        }
    }
    private int[] evaluate(String exp) {
        int[] res = new int[2];
        int num = 0;
        int sign = 1;
        for (int i = 0; i < exp.length(); i++) {
            char c = exp.charAt(i);
            if (c == '+' || c == '-') {
                res[1] += sign * num;
                num = 0;
                sign = c == '+' ? 1 : -1;
            } else if (c == 'x') {
                res[0] += sign * (num == 0 ? 1 : num);
                num = 0;
            } else {
                num = num * 10 + c - '0';
            }
        }
        res[1] += sign * num;
        return res;
    }
}