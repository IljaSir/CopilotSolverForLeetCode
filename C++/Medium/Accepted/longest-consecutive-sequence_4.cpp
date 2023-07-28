class Solution {
public:
    int longestConsecutive(vector<int>& nums) {
        
        unordered_set<int> s(nums.begin(), nums.end());
        int ans = 0;
        for (int i = 0; i < nums.size(); i++) {
            if (s.find(nums[i]) != s.end()) {
                int left = nums[i] - 1, right = nums[i] + 1;
                while (s.find(left) != s.end()) {
                    s.erase(left);
                    left--;
                }
                while (s.find(right) != s.end()) {
                    s.erase(right);
                    right++;
                }
                ans = max(ans, right - left - 1);
            }
        }
        return ans;
    }
};