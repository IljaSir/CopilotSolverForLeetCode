class Solution {
public:
    long long countFairPairs(vector<int>& nums, int lower, int upper) {
        
        long long ans = 0;
        sort(nums.begin(), nums.end());
        int n = nums.size();
        for (int i = 0; i < n; i++) {
            int l = i + 1, r = n - 1;
            while (l < r) {
                int sum = nums[i] + nums[l];
                if (sum > upper) {
                    r--;
                } else if (sum < lower) {
                    l++;
                } else {
                    int j = r;
                    while (j > l && nums[i] + nums[j] >= lower) {
                        j--;
                    }
                    ans += r - j;
                    l++;
                }
            }
        }
        return ans;
    }
};