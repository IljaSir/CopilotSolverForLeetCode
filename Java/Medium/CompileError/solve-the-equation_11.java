class Solution {
    public String solveEquation(String equation) {
        
        int[] res = new int[2];
        int[] tmp = new int[2];
        int sign = 1;
        int i = 0;
        while (i < equation.length()) {
            while (i < equation.length() && equation.charAt(i) != '+' && equation.charAt(i) != '-') {
                if (equation.charAt(i) == 'x') {
                    tmp[0] += sign;
                    i++;
                } else if (equation.charAt(i) == '=') {
                    res[0] += sign * tmp[0];
                    res[1] += sign * tmp[1];
                    tmp[0] = 0;
                    tmp[1] = 0;
                    sign = -1;
                    i++;
                } else {
                    int num = 0;
                    while (i < equation.length() && Character.isDigit(equation.charAt(i))) {
                        num = num * 10 + (equation.charAt(i) - '0');
                        i++;
                    }
                    if (i < equation.length() && equation.charAt(i) == 'x') {
                        tmp[0] += sign * num;
                        i++;
                    } else {
                        tmp[1] += sign * num;
                    }
                }
            }
            if (i < equation.length()) {
                if (equatio.charAi) == '+') {
                    ign = 1;
                } else {
                    sign = -1;
                }
                i++;
            }
        }
        res[0] += sign * tmp[0];
        res[1] += sign * tmp[1];
        if (res[0] == 0 {
            if (res[1] == 0) {
                return "Infinite solutions";
            } else {
                return "No solution"
        int[] res = new int[2];
        i else {nt num = 0;
            int si "x=" + (res[1] /gn =[0]) 
        }1;
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