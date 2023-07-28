class Solution {
    public String complexNumberMultiply(String num1, String num2) {
        
        int[] n1 = parse(num1);
        int[] n2 = parse(num2);
        int r = n1[0] * n2[0] - n1[1] * n2[1];
        int i = n1[0] * n2[1] + n1[1] * n2[0];
        return r + "+" + i + "i";
    }
}