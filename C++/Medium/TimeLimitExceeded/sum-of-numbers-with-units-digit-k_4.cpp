class Solution {
public:
    int minimumNumbers(int num, int k) {
        
        if (num == 0) return 0;
        if (num < k) return -1;
        if (num % 10 == k) return 1;
        int ans = 0;
        while (num > 0) {
            if (num % 10 == k) {
                num = num / 10;
            } else {
                num = num / 10 + 1;
                ans++;
            }
        }
        return ans;
    }
};