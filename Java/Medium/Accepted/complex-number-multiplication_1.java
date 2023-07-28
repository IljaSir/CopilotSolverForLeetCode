class Solution {
    public String complexNumberMultiply(String num1, String num2) {
        
        int[] n1 = parse(num1);
        int[] n2 = parse(num2);
        int real = n1[0] * n2[0] - n1[1] * n2[1];
        int imag = n1[0] * n2[1] + n1[1] * n2[0];
        return real + "+" + imag + "i";
    }

    private int[] parse(String num) {
        int[] n = new int[2];
        int i = 0;
        while (num.charAt(i) != '+') {
            i++;
        }
        n[0] = Integer.parseInt(num.substring(0, i));
        n[1] = Integer.parseInt(num.substring(i + 1, num.length() - 1));
        return n;
    }
}