class Solution {
public:
    int maxNonOverlapping(vector<int>& nums, int target) {
        
        int n = nums.size();
        int ans = 0;
        unordered_map<int, int> m;
        m[0] = -1;
        int sum = 0;
        for (int i = 0; i < n; ++i) {
            sum += nums[i];
            if (m.count(sum - target)) {
                int idx = m[sum - target];
                if (idx == -1 || i - idx > 1) {
                    ans++;
                    m.clear();
                    m[0] = i;
                }
            } else {
                m[sum] = i;
            }
        }
        return ans;
    }
};