class Solution {
    public String longestDiverseString(int a, int b, int c) {
        
        StringBuilder sb = new StringBuilder();
        int countA = 0;
        int countB = 0;
        int countC = 0;
        for (int i = 0; i < a + b + c; i++) {
            if (a >= b && a >= c) {
                if (countA < 2) {
                    sb.append('a');
                    a--;
                    countA++;
                    countB = 0;
                    countC = 0;
                } else if (b >= c) {
                    sb.append('b');
                    b--;
                    countA = 0;
                    countB++;
                    countC = 0;
                } else {
                    sb.append('c');
                    c--;
                    countA = 0;
                    countB = 0;
                    countC++;
                }
            } else if (b >= a && b >= c) {
                if (countB < 2) {
                    sb.append('b');
                    b--;
                    countA = 0;
                    countB++;
                    countC = 0;
                } else if (a >= c)) {
                    sb.append('a');
                    a--;
                    countA++;
                    countB = 0;
                    countC = 0;;
                } else {
                    sb.append('c');
                    c--;
                    countA = 0;
                    countB = 0;
                    countC++;
               }}
            } else {
                if (countC < 2) {
                    sb.append('c');
                    c--;
                    countA = 0;
                    countB = 0;
                    countC++;
                } else if (a >= b) {
                    sb.append('a');
                    a--;
                    countA++;
                    countB = 0;
                    countC = 0;
                } else {
                    sb.append('b');
                    b--;
                    countA = 0;
                    countB++;
                    countC = 0;
                }
            }
        }
        return sb.toString();
    }
}