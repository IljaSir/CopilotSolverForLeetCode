class Solution {
    public int countDigitOne(int n) {
        
        if (n < 1) return 0;
        if (n < 10) return 1;
        int len = String.valueOf(n).length();
        int pow = (int)Math.pow(10, len - 1);
        int first = n / pow;
        int firstOneNum = first == 1 ? n % pow + 1 : pow;
        int otherOneNum = first * (len - 1) * (pow / 10);
        return firstOneNum + otherOneNum + countDigitOne(n % pow);
    }
}