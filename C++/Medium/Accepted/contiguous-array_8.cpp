class Solution {
public:
    int findMaxLength(vector<int>& nums) {
        
        int n = nums.size();
        if (n == 0 || n == 1) {
            return 0;
        }
        unordered_map<int, int> m;
        m[0] = -1;
        int sum = 0;
        int res = 0;
        for (int i = 0; i < n; i++) {
            sum += (nums[i] == 1) ? 1 : -1;
            if (m.find(sum) != m.end()) {
                res = max(res, i - m[sum]);
            } else {
                m[sum] = i;
            }
        }
        return res;
    }
};