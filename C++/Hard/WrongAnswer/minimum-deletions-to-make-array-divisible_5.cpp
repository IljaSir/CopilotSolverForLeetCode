class Solution {
public:
    int minOperations(vector<int>& nums, vector<int>& numsDivide) {
        
        int n = nums.size();
        int m = numsDivide.size();
        if (n > m) return -1;
        sort(nums.begin(), nums.end());
        for (int& i : numsDivide) {
            i = __gcd(i, nums[0]);
        }
        sort(numsDivide.begin(), numsDivide.end());
        int g = numsDivide[0];
        for (int i = 1; i < m; ++i) {
            g = __gcd(g, numsDivide[i]);
        }
        if (g != nums[0]) return -1;
        int ans = 0;
        for (int i = 0; i < n; ++i) {
            if (nums[i] != nums[0]) ++ans;
        }
        return ans;
    }
};