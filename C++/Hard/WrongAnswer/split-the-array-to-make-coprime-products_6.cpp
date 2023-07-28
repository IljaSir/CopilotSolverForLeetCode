class Solution {
public:
    int findValidSplit(vector<int>& nums) {
        
        int n = nums.size();
        vector<int> prefix(n + 1);
        vector<int> suffix(n + 1);
        prefix[0] = 1;
        suffix[n] = 1;
        for (int i = 0; i < n; ++i) {
            prefix[i + 1] = gcd(prefix[i], nums[i]);
            suffix[n - i - 1] = gcd(suffix[n - i], nums[n - i - 1]);
        }
        for (int i = 0; i < n; ++i) {
            if (gcd(prefix[i], suffix[i + 1]) == 1) {
                return i;
            }
        }
        return -1;
    }
    int gcd(int a, int b) {
        if (b == 0) {
            return a;
        }
        return gcd(b, a % b);
    }
};