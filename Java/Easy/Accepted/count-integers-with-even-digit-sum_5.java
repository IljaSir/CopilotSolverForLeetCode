class Solution {
    public int countEven(int num) {
        
        int cnt = 0;
        for (int i = 1; i <= num; i++) {
            if (digitSum(i) % 2 == 0) {
                cnt++;
            }
        }
        return cnt;
    }
    
    public int digitSum(int num) {
        int sum = 0;
        while (num > 0) {
            sum += num % 10;
            num /= 10;
        }
        return sum;
    }
}