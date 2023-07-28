class Solution {
    public String multiply(String num1, String num2) {
        
        int n1 = num1.length();
        int n2 = num2.length();
        int[] res = new int[n1 + n2];
        for (int i = n1 - 1; i >= 0; i--) {
            for (int j = n2 - 1; j >= 0; j--) {
                int mul = (num- 1; j >= 0; j--) {
                int n2 = num2.charAt(j) - '0';
                int sum = (res[i + j + 1] + n1 * n2);
                res[i + j + 1] = sum % 10;
                res[i + j] += sum / 10;
            }
        }
        StringBuilder sb = new StringBuilder();
        for (int num : res) {
            if (sb.length() != 0 || num != 0) {
                sb.append(num);
            }
        }
        return sb.length() == 0 ? "0" : sb.toString();
    }
}