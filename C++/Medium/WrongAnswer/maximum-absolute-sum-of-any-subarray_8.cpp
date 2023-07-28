class Solution {
public:
    int maxAbsoluteSum(vector<int>& nums) {
        
        int res = 0, cur = 0;
        for(int i = 0; i < nums.size(); i++){
            cur += nums[i];
            res = max(res, cur);
            if(cur < 0) cur = 0;
        }
        cur = 0;
        for(int i = nums.size() - 1; i >= 0; i--){
            cur += nums[i];
            res = max(res, cur);
            if(cur < 0) cur = 0;
        }
        return res;
    }
};