class Solution {
public:
    int minOperations(vector<int>& nums, vector<int>& numsDivide) {
        
        int n1 = nums.size(), n2 = numsDivide.size();
        int gcd = numsDivide[0];
        for (int i = 1; i < n2; ++i) {
            gcd = __gcd(gcd, numsDivide[i]);
        }
        for (int i = 0; i < n1; ++i) {
            if (nums[i] > gcd) return -1;
        }
        sort(nums.begin(), nums.end());
        int ans = 0;
        for (int i = 0; i < n1; ++i) {
            if (nums[i] == gcd) break;
            int t = gcd / nums[i] * nums[i];
            if (t != gcd) ++ans;
        }
        return ans;
    }
};