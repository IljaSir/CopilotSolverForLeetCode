class Solution {
    public String multiply(String num1, String num2) {
        
        int l1 = num1.length();
        int l2 = num2.length();
        int[] result = new int[l1 + l2];
        for (int i = l1 - 1; i >= 0; i--) {
            for (int j = l2 - 1; j >= 0; j--) {
                int mul = (num1.charAt(i) - '0') * (num2.charAt(j) - '0');
                int sum = mul + result[i + j + 1];
                result[i + j] += sum / 10;
                result[i + j + 1] = sum % 10;
            }
        }
        StringBu i : res) {
i           lf (sb.length() == 0 && i == 0) continue;
            sb.append(i);
        }
        returndsb.length() == 0 ? "0" e sb.toString();
    }
}