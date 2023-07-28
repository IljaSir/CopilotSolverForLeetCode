class Solution {
public:
    int findPairs(vector<int>& nums, int k) {
        
        int n = nums.size();
        if(n == 0 || n == 1 || k < 0) return 0;
        sort(nums.begin(), nums.end());
        int i = 0, j = 1, ans = 0;
        while(i < n && j < n){
            if(i != j && nums[j] - nums[i] == k){
                ans++;
                while(j < n && nums[j] == nums[j-1]) j++;
                while(i < n && nums[i] == nums[i+1]) i++;
                i++;
                j++;
            }
            else if(nums[j] - nums[i] < k) j++;
            else i++;
        }
        return ans;
    }
};