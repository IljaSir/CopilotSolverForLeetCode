class Solution {
public:
    int minimumDeletions(vector<int>& nums) {
        
        int n = nums.size();
        vector<int> min(n, INT_MAX);
        vector<int> max(n, INT_MIN);
        min[0] = nums[0];
        max[n-1] = nums[n-1];
        for(int i = 1; i < n; i++)
            min[i] = min(min[i-1], nums[i]);
        for(int i = n-2; i >= 0; i--)
            max[i] = max(max[i+1], nums[i]);
        int ans = INT_MAX;
        for(int i = 0; i < n; i++){
            int left = i;
            int right = n - i - 1;
            int l = left == 0 ? INT_MIN : min[left-1];
            int r = right == 0 ? INT_MAX : max[i+1];
            if(l < nums[i] && nums[i] < r)
                ans = min(ans, left + right);
        }
        return ans;
    }
};