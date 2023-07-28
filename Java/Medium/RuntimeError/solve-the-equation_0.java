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

    public int[] parse(String s) {
        int[] res = new int[2];
        int n = s.length();
        int i = 0;
        int sign = 1;
        while (i < n) {
            if (s.charAt(i) == '+' || s.charAt(i) == '-') {
                sign = s.charAt(i) == '+' ? 1 : -1;
                i++;
            } else {
                int j = i;
                while (j < n && Character.isDigit(s.charAt(j))) {
                    j++;
                }
                int num = Integer.parseInt(s.substring(i, j));
                if (j < n && s.charAt(j) == 'x') {
                    res[0] += num * sign;
                    j++;
                } else {
                    res[1] += num * sign;
                }
                i = j;
            }
        }
        return res;
    }
}