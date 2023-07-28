class Solution {
public:
    int minSwaps(vector<int>& nums) {
        
        int n = nums.size();
        int cnt = 0;
        for (int i = 0; i < n; i++) {
            cnt += nums[i];
        }
        int i = 0;
        int j = 0;
        int maxcnt = 0;
        while (j < n) {
            if (nums[j] == 1) {
                maxcnt++;
            }
            if (j - i + 1 > cnt) {
                if (nums[i] == 1) {
                    maxcnt--;
                }
                i++;
            }
            j++;
        }
        return cnt - maxcnt;
    }
};