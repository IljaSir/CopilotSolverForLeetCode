class Solution {
public:
    int minimumDeletions(vector<int>& nums) {
        
        int n = nums.size();
        vector<int> left(n);
        vector<int> right(n);
        left[0] = nums[0];
        for(int i = 1; i < n; i++) {
            left[i] = min(left[i-1], nums[i]);
        }
        right[n-1] = nums[n-1];
        for(int i = n-2; i >= 0; i--) {
            right[i] = max(right[i+1], nums[i]);
        }
        int res = n;
        for(int i = 0; i < n; i++) {
            if(i == 0) {
                res = min(res, n - (upper_bound(right.begin()+i+1, right.end(), left[i]) - right.begin()));
            } else if(i == n-1) {
                res = min(res, n - (lower_bound(left.begin(), left.begin()+i, right[i]) - left.begin()));
            } else {
                int l = lower_bound(left.begin(), left.begin()+i, right[i]) - left.begin();
                int r = upper_bound(right.begin()+i+1, right.end(), left[i]) - right.begin();
                res = min(res, n - (i - l + r - i - 1));
            }
        }
        return res;
    }
};