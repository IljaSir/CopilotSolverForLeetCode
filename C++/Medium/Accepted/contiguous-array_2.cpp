class Solution {
public:
    int findMaxLength(vector<int>& nums) {
        
        unordered_map<int, int> m;
        m[0] = -1;
        int sum = 0, max_len = 0;
        for (int i = 0; i < nums.size(); i++) {
            sum += nums[i] == 0 ? -1 : 1;
            if (m.find(sum) != m.end()) {
                max_len = max(max_len, i - m[sum]);
            } else {
                m[sum] = i;
            }
        }
        return max_len;
    }
};