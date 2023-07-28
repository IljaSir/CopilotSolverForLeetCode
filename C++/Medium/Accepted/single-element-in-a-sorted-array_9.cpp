class Solution {
public:
    int singleNonDuplicate(vector<int>& nums) {
        
        int n = nums.size();
        int l = 0, r = n-1;
        while(l<=r){
            int m = l+(r-l)/2;
            if(m>0 && nums[m]==nums[m-1]){
                if((m-1)%2) r = m-2;
                else l = m+1;
            }
            else if(m<n-1 && nums[m]==nums[m+1]){
                if(m%2) r = m-1;
                else l = m+2;
            }
            else return nums[m];
        }
        return -1;
    }
};