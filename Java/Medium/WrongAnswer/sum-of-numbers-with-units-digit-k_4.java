class Solution {
    public int minimumNumbers(int num, int k) {
        
        if (num == 0) {
            return 0;
        }
        if (num < k) {
            return -1;
        }
        int count = 0;
        while (num > 0) {
            if (num < k) {
                count += 1;
                num = 0;
            } else {
                count += num / k;
                num = num % k;
            }
        }
        return count;
    }
}