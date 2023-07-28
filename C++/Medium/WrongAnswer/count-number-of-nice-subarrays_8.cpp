class Solution {
public:
    int numberOfSubarrays(vector<int>& nums, int k) {
        
        int n = nums.size();
        int count = 0;
        int cnt = 0;
        int l = 0;
        int r = 0;
        while (r < n) {
            if (nums[r] % 2 == 1) {
                cnt++;
            }
            while (cnt == k) {
                count++;
                if (nums[l] % 2 == 1) {
                    cnt--;
                }
                l++;
            }
            r++;
        }
        return count;
    }
};