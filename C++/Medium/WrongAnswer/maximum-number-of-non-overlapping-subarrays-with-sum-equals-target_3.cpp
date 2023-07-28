class Solution {
public:
    int maxNonOverlapping(vector<int>& nums, int target) {
        
        int n = nums.size();
        int res = 0;
        int sum = 0;
        unordered_map<int, int> m;
        m[0] = -1;
        for (int i = 0; i < n; ++i) {
            sum += nums[i];
            if (m.count(sum - target)) {
                if (m[sum - target] < i - 1) {
                    ++res;
                    m.clear();
                }
            }
            m[sum] = i;
        }
        return res;
    }
};