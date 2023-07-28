class Solution {
public:
    int numberOfSubarrays(vector<int>& nums, int k) {
        
        int n = nums.size();
        int odd[n+1];
        int count = 0;
        for (int i = 0; i < n; i++) {
            odd[i] = count;
            if (nums[i] % 2 != 0) {
                count++;
            }
        }
        odd[n] = count;
        int ret = 0;
        for (int i = 0; i < n; i++) {
            if (odd[i] + k <= odd[n]) {
                int j = i;
                while (odd[j] < odd[i] + k) {
                    j++;
                }
                int left = j - i;
                int right = 1;
                while (j < n && nums[j] % 2 == 0) {
                    j++;
                    right++;
                }
                ret += left * right;
                i = j - 1;
            }
        }
        return ret;
    }
};