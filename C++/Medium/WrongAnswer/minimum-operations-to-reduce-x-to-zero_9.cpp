class Solution {
public:
    int minOperations(vector<int>& nums, int x) {
        
        int n = nums.size();
        int sum = 0;
        int res = INT_MIN;
        int l = 0, r = 0;
        while(r < n){
            sum += nums[r];
            while(sum > x && l <= r){
                sum -= nums[l++];
            }
            if(sum == x) res = max(res, r - l + 1);
            r++;
        }
        return res == INT_MIN ? -1 : n - res;
    }
};