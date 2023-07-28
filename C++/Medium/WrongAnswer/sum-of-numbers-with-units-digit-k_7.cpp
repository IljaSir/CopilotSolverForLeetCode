class Solution {
public:
    int minimumNumbers(int num, int k) {
        
        if (k == 0) {
            if (num == 0) {
                return 0;
            }
            return -1;
        }
        int ans = 0;
        while (num) {
            ans += num / 10 + (num % 10 >= k);
            num /= 10;
        }
        return ans;
    }
};