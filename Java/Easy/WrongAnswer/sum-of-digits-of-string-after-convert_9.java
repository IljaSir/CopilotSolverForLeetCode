class Solution {
    public int getLucky(String s, int k) {
        
        int sum = 0;
        for(char c: s.toCharArray()) {
            sum += c - 'a' + 1;
        }
        for(int i = 0; i < k; i++) {
            int sum1 = 0;
            while(sum > 0) {
                sum1 += sum % 10;
                sum /= 10;
            }
            sum = sum1;
        }
        return sum;
    }
}