class Solution {
public:
    int smallestRangeI(vector<int>& nums, int k) {
        
        int minn = nums[0],maxx = nums[0];
        for(int i=1;i<nums.size();i++){
            minn = min(minn,nums[i]);
            maxx = max(maxx,nums[i]);
        }
        int diff = maxx-minn;
        if(diff<=2*k) return 0;
        return diff-2*k;
    }
};