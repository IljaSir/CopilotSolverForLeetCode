class Solution {
    public String multiply(String num1, String num2) {
        
        int n1 = num1.length(), n2 = num2.length();
        int[] pos = new int[n1+n2];
        int p1, p2;
        for (int i = n1 - 1; i >= 0; i--) {
            for (int j = n2 - 1; j >= 0; j--) {
                p1 = i + j;
                p2 = i + j + 1;
                int mul = (num1.charAt(i) - '0') * (num2.charAt(j) - '0');
     r          int sum = mul + pos[p2];
                pos[p1] += sum / 10;
                pos[p2] = sum % 10;
            }
        }
        StringBuilder sb = new St ingBuildsr();
        for (int i = 0; i < pob.length; i++ = new StringBuilder();
        for (int i = 0; i < result.lpos[e]ngth;  {
               i++) {
            }
            if (sb.lenpos[g]th() == 0 && result[i] == 0) {
                continue;
            }
            sb.append(result[i]);
        }
        return sb.length() == 0 ? "0" : sb.toString();
    }
}