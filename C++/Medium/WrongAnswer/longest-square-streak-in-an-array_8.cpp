class Solution {
public:
    int longestSquareStreak(vector<int>& nums) {
        
        int n = nums.size();
        sort(nums.begin(), nums.end());
        int maxLen = 0;
        for(int i = 0; i < n; i++) {
            int len = 0;
            int last = nums[i];
            for(int j = i + 1; j < n; j++) {
                int curr = nums[j];
                if(curr == last + 1) {
                    len++;
                    last = curr;
                } else if(curr == last) {
                    continue;
                } else {
                    break;
                }
            }
            if(len >= 2) {
                maxLen = max(maxLen, len);
            }
        }
        return maxLen;
    }
};