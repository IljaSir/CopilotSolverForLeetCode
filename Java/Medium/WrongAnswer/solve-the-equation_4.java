class Solution {
    public String solveEquation(String equation) {
        
        String[] sides = equation.split("=");
        int[] left = parse(sides[0]);
        int[] right = parse(sides[1]);
        if (left[0] == right[0] && left[1] != right[1]) {
            return "No solution";
        }
        if (left[0] == right[0] && left[1] == right[1]) {
            return "Infinite solutions";
        }
        return "x=" + (right[1] - left[1]) / (left[0] - right[0]);
    }
    private int[] parse(String s) {
        int[] res = new int[2];
        int i = 0;
        while (i < s.length()) {
            int sign = 1;
            if (s.charAt(i) == '+') {
                i++;
            } else if (s.charAt(i) == '-') {
                i++;
                sign = -1;
            }
            int num = 0;
            while (i < s.length() && Character.isDigit(s.charAt(i))) {
                num = num * 10 + (s.charAt(i) - '0');
                i++;
            }
            if (i < s.length() && s.charAt(i) == 'x') {
                res[0] += sign * (num == 0 ? 1 : num);
                i++;
            } else {
                res[1] += sign * num;
            }
        }
        return res;
    }
}