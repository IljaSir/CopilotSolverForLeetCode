class Solution {
    public String solveEquation(String equation) {
        
        String[] arr = equation.split("=");
        int[] left = parse(arr[0]);
        int[] right = parse(arr[1]);
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
        int i = 0;
        if (s.charAt(0) == '+' || s.charAt(0) == '-') {
            i++;
        }
        while (i < s.length()) {
            int j = i;
            while (j < s.length() && s.charAt(j) != '+' && s.charAt(j) != '-') {
                j++;
            }
            String sub = s.substring(i, j);
            if (sub.equals("x")) {
                res[0] += i > 0 && s.charAt(i - 1) == '-' ? -1 : 1;
            } else if (sub.contains("x")) {
                res[0] += (i > 0 && s.charAt(i - 1) == '-' ? -1 : 1) * Integer.parseInt(sub.substring(0, sub.length() - 1));
            } else {
                res[1] += (i > 0 && s.charAt(i - 1) == '-' ? -1 : 1) * Integer.parseInt(sub);
            }
            i = j;
        }
        return res;
    }
}