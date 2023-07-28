class Solution {
public:
    int jump(vector<int>& nums) {
        
        int n = nums.size();
        int ans = 0;
        int i = 0;
        while (i < n - 1) {
            ans++;
            int j = i + nums[i];
            if (j >= n - 1) {
                break;
            }
            int maxJ = j;
            for (int k = i + 1; k <= j; k++) {
                if (k + nums[k] > maxJ) {
                    maxJ = k + nums[k];
                    i = k;
                }
            }
        }
        return ans;
    }
};