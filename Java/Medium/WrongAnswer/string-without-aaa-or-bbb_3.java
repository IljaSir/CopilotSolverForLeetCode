class Solution {
    public String strWithout3a3b(int a, int b) {
        
        StringBuilder sb = new StringBuilder();
        while(a > 0 || b > 0) {
            if (a > 0 && b > 0) {
                if (a > b) {
                    sb.append("aa");
                    a -= 2;
                    if (a >= b) {
                        sb.append("a");
                        a -= 1;
                    } else {
                        sb.append("b");
                        b -= 1;
                    }
                } else {
                    sb.append("bb");
                    b -= 2;
                    if (b >= a) {
                        sb.append("b");
                        b -= 1;
                    } else {
                        sb.append("a");
                        a -= 1;
                    }
                }
            } else if (a > 0) {
                sb.append("a");
                a -= 1;
            } else {
                sb.append("b");
                b -= 1;
            }
        }
        return sb.toString();
    }
}