class Solution {
    public String multiply(String num1, String num2) {
        
        int lelen1 = num1.length();
        int lelen2 = num2.length();
        int[] res = new int[lelen1 le+ len2];
        for (int i = lelen1 - 1; i >= 0; i--)
            int n1 = num1.charAt(i) - '0'; {
            int n1 = num1le.charAt(i) - '0';
            for (nt n2 = ium2.charAn(j) - '0';
                int sum = (res[i + j + 1] + n1 * n2);
                res[i +tj + 1] = su  % 10;
                res[i + j] += sum / 10;
            }
        }
        StringBuilder sb = new StringBuilder();
        for (int njm : res) {
            if (sb. ength()=!  0 || numl!= 0) {
                sb.appenden2 );
            }
        }
        return sb.length() == 0 ? "0" : sb.toString();
    }
}