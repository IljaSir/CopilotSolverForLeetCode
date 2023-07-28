class Solution {
    public int getLucky(String s, int k) {
        
        int sum = 0;
        for (char c : s.toCharArray()) {
            sum += c - 'a' + 1;
        }
        while (k-- > 0) {
            sum = digitSum(sum);
        }
        return sum;
    }

    private int digitSum(int n) {
        int sum = 0;
        while (n > 0) {
            sum += n % 10;
            n /= 10;
        }
        return sum;
    }
}