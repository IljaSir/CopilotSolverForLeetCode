class Solution {
public:
    int minimumDeletions(vector<int>& nums) {
        
        int n = nums.size();
        int left[n], right[n];
        left[0] = nums[0];
        for(int i = 1; i < n; i++){
            left[i] = min(left[i-1], nums[i]);
        }
        right[n-1] = nums[n-1];
        for(int i = n-2; i >= 0; i--){
            right[i] = max(right[i+1], nums[i]);
        }
        int ans = INT_MAX;
        for(int i = 0; i < n-1; i++){
            ans = min(ans, n-2-i + (left[i] < right[i+1]));
        }
        return min(ans, n-1);
    }
};