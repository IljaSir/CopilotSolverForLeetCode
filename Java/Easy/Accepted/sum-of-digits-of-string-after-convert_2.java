class Solution {
    public int getLucky(String s, int k) {
        
        int sum = 0;
        for (int i = 0; i < s.length(); i++) {
            int num = s.charAt(i) - 'a' + 1;
            while (num > 0) {
                sum += num % 10;
                num /= 10;
            }
        }

        while (--k > 0) {
            int temp = sum;
            sum = 0;
            while (temp > 0) {
                sum += temp % 10;
                temp /= 10;
            }
        }

        return sum;
    }
}