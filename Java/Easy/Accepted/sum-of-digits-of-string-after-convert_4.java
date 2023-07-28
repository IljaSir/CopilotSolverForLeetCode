class Solution {
    public int getLucky(String s, int k) {
        
        int[] num = new int[s.length()];
        for (int i = 0; i < s.length(); i++) {
            num[i] = s.charAt(i) - 'a' + 1;
        }
        int sum = 0;
        for (int i = 0; i < num.length; i++) {
            while (num[i] > 0) {
                sum += num[i] % 10;
                num[i] /= 10;
            }
        }
        for (int i = 1; i < k; i++) {
            int tmp = sum;
            sum = 0;
            while (tmp > 0) {
                sum += tmp % 10;
                tmp /= 10;
            }
        }
        return sum;
    }
}