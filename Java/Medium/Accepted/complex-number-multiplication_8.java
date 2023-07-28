class Solution {
    public String complexNumberMultiply(String num1, String num2) {
        
        int[] n1 = parseNumber(num1);
        int[] n2 = parseNumber(num2);
        int a = n1[0] * n2[0] - n1[1] * n2[1];
        int b = n1[0] * n2[1] + n1[1] * n2[0];
        return a + "+" + b + "i";
    }
    
    public int[] parseNumber(String num) {
        int[] res = new int[2];
        int i = 0;
        while (num.charAt(i) != '+') {
            i++;
        }
        res[0] = Integer.parseInt(num.substring(0, i));
        res[1] = Integer.parseInt(num.substring(i + 1, num.length() - 1));
        return res;
    }
}