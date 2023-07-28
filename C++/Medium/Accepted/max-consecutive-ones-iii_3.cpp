class Solution {
public:
    int longestOnes(vector<int>& nums, int k) {
        
        int i = 0, j = 0;
        int n = nums.size();
        int cnt = 0;
        int ans = 0;
        while (j < n) {
            if (nums[j] == 1) {
                cnt++;
            }
            j++;
            if (j - i - cnt > k) {
                if (nums[i] == 1) {
                    cnt--;
                }
                i++;
            }
            ans = max(ans, j - i);
        }
        return ans;
    }
};