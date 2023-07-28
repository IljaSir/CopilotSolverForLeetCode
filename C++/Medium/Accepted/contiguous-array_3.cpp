class Solution {
public:
    int findMaxLength(vector<int>& nums) {
        
        unordered_map<int, int> m;
        int sum = 0;
        int maxLen = 0;
        for (int i = 0; i < nums.size(); i++) {
            sum += (nums[i] == 1) ? 1 : -1;
            if (sum == 0) {
                maxLen = i + 1;
            } else if (m.find(sum) != m.end()) {
                maxLen = max(maxLen, i - m[sum]);
            } else {
                m[sum] = i;
            }
        }
        return maxLen;
    }
};