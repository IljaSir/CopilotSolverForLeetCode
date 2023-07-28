class Solution {
    public boolean sumOfNumberAndReverse(int num) {
        
        String s = String.valueOf(num);
        int n = s.length();
        int sum = 0;
        for(int i = 0; i < n; i++){
            int x = (int) Math.pow(10, n - i - 1);
            sum += (s.charAt(i) - '0') * (x + 1);
        }
        return num == sum;
    }
}