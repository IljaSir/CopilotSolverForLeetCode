class Solution {
public:
    int findMaxLength(vector<int>& nums) {
        
        int n = nums.size();
        int ans = 0;
        int sum = 0;
        unordered_map<int, int> m;
        m[0] = -1;
        for (int i = 0; i < n; i++) {
            sum += nums[i] == 1 ? 1 : -1;
            if (m.find(sum) != m.end()) {
                ans = max(ans, i - m[sum]);
            } else {
                m[sum] = i;
            }
        }
        return ans;
    }
};