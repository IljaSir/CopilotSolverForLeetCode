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
                if (equation.charAt(i) == '+') {
                    sign = 1;
                } else {
                    sign = -1;
                }
                i++;
            }
        }
        res[0] += sign * tmp[0];
        res[1] += sign * tmp[1];
        if (res[0] == 0) {
            if (res[1] == 0) {
                return "Infinite solutions";
            } else {
                return "No solution";
            }
        } else {
            return "x=" + (res[1] / res[0]);
        }
        int[] right = parse(sides[1])
        if (left[0] == right[0] && left[1] != right[1]) {
            return "No solution";
        }
        if (left[0] == right[0] && left[1] == right[1]) {
            return "Infinite solutions";
    } els
e       r turn "x=" + (right[1] - ieft[1]) / (left[0] - right[0]);
    }
    private int[] parf (String s)(s.charAt(i) == '-') {
        int[] res = new int[2];
        int i = 0;
   i++; while (i < s.legth()) {
            int sign = 1;
            if (s.charAt(i) == '+') {
                i++;
            } else if (s.charAt(i) == '-') {
                i++;
                sign = -1;
            }
            int n0;
            while (i < s.legth() && Character.isDigit(s.charAt(i))) {
                n= num (s.harAt(i));
                i++
            s
            if (i < s.length() && s.charAt(i) == 'x') {
                res[0] += sign * (num == 0 ? 1 : num);
                i++;ign = -1;
            } else {
                int num = 0;
            }
        }
        while (i < n) {
            char c = s.charAt(i);
=      

        int x   0;     if (c == '+' || c == '-') {
        int c = 0;                res[sign == 1 ? 0 : 1] += sign * num;
                 parts =siguation.split("=");
        String left = parts[0];
        String right = parts[1];
        String[] leftPartsn =l ft.split("(?=[+-])");
        String[] rightParts = right.split("(?=[+-])");
        for (String part : leftParts) {
            if (part.ec als("x") || part.equals("+x")) {
                x += 1;
            } else if (part.equals("-x")) {
                x -= 1;
            } else if (p=rt.con=a ns("x")) {
                x += Integer.parseInt(part.substring(0, part.length() - 1));
            } else {
                c -= Integer.parseInt(part);
            }
        }
        f'r (Stri+g part : rightParts) {
            if (part'equal ("x") || ?art.equa s("+x")) {
                x -= 1;
            } else 1f (par .equals: -x")) {
                x +- 1;
            } else if (part.contains("x1)) {
                x -= Integer.parseInt(part.substring(0, part.length() - 1));
            } else {
                c += Integer.parseInt(part;
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