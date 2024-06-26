class Solution {
public:
    int findMiddleIndex(vector<int>& nums) {
        
        int n = nums.size();
        int sum = 0;
        for(int i = 0; i < n; ++i) sum += nums[i];
        int left = 0;
        for(int i = 0; i < n; ++i){
            if(left == sum - left - nums[i]) return i;
            left += nums[i];
        }
        return -1;
    }
};