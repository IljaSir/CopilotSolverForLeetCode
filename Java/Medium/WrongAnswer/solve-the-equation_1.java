class Solution {
    public String solveEquation(String equation) {
        
        String[] parts = equation.split("=");
        int[] left = parse(parts[0]);
        int[] right = parse(parts[1]);
        left[0] -= right[0];
        left[1] = right[1] - left[1];
        if (left[0] == 0 && left[1] == 0) {
            return "Infinite solutions";
        }
        if (left[0] == 0) {
            return "No solution";
        }
        return "x=" + left[1] / left[0];
    }

    private int[] parse(String s) {
        int[] res = new int[2];
        int n = s.length();
        if (n == 0) {
            return res;
        }
        int i = 0;
        int sign = 1;
        if (s.charAt(i) == '+') {
            i++;
        } else if (s.charAt(i) == '-') {
            i++;
            sign = -1;
        }
        int num = 0;
        while (i < n) {
            char c = s.charAt(i);
            if (c == '+' || c == '-') {
                res[sign == 1 ? 0 : 1] += sign * num;
                sign = c == '+' ? 1 : -1;
                num = 0;
            } else if (c == 'x') {
                res[sign == 1 ? 0 : 1] += sign * (num == 0 ? 1 : num);
                num = 0;
            } else {
                num = num * 10 + c - '0';
            }
            i++;
        }
        res[sign == 1 ? 0 : 1] += sign * num;
        return res;
    }
}