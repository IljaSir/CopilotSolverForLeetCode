class Solution {
public:
    int maxNonOverlapping(vector<int>& nums, int target) {
        
        int n = nums.size();
        unordered_map<int, int> m;
        m[0] = -1;
        int sum = 0;
        int res = 0;
        int last = -1;
        for (int i = 0; i < n; ++i) {
            sum += nums[i];
            if (m.find(sum - target) != m.end() && m[sum - target] >= last) {
                ++res;
                last = i;
            }
            m[sum] = i;
        }
        return res;
    }
};