class Solution {
public:
    long long countSubarrays(vector<int>& nums, int minK, int maxK) {
        
        int n = nums.size();
        vector<int> left(n, 0);
        vector<int> right(n, 0);
        for (int i = 0; i < n; i++) {
            int l = i - 1;
            int r = i + 1;
            while (l >= 0 && nums[l] >= minK && nums[l] <= maxK) {
                l--;
            }
            while (r < n && nums[r] >= minK && nums[r] <= maxK) {
                r++;
            }
            left[i] = i - l;
            right[i] = r - i;
        }
        long long ans = 0;
        for (int i = 0; i < n; i++) {
            ans += left[i] * right[i];
        }
        return ans;
    }
};