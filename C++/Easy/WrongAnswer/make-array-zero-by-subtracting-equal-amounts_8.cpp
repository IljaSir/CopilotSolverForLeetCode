class Solution {
public:
    int minimumOperations(vector<int>& nums) {
        
        int n = nums.size();
        sort(nums.begin(), nums.end());
        int ans = 0;
        int prev = 0;
        for (int i = 0; i < n; i++) {
            int curr = nums[i];
            if (curr == prev) continue;
            ans += (curr - prev) * (n - i);
            prev = curr;
        }
        return ans;
    }
};