class Solution {
public:
    int countDistinct(vector<int>& nums, int k, int p) {
        
        int n = nums.size();
        int ans = 0;
        int count = 0;
        int i = 0;
        int j = 0;
        while (i < n) {
            if (nums[i] % p == 0) {
                count++;
            }
            while (count > k) {
                if (nums[j] % p == 0) {
                    count--;
                }
                j++;
            }
            ans += i - j + 1;
            i++;
        }
        return ans;
    }
};