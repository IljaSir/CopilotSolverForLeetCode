class Solution {
public:
    int minimumDeletions(vector<int>& nums) {
        
        int n = nums.size();
        vector<int> min(n);
        vector<int> max(n);
        min[0] = nums[0];
        max[n-1] = nums[n-1];
        
        for(int i=1; i<n; i++) {
            min[i] = min(min[i-1], nums[i]);
        }
        
        for(int i=n-2; i>=0; i--) {
            max[i] = max(max[i+1], nums[i]);
        }
        
        int ans = INT_MAX;
        for(int i=0; i<n; i++) {
            int curr = 0;
            if(i > 0) {
                curr += i - (lower_bound(min.begin(), min.begin() + i, nums[i]) - min.begin());
            }
            if(i < n - 1) {
                curr += n - i - 1 - (lower_bound(max.begin() + i + 1, max.end(), nums[i]) - max.begin());
            }
            ans = min(ans, curr);
        }
        return ans;
    }
};