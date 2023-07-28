class Solution {
public:
    int minimumOperations(vector<int>& nums) {
        
        sort(nums.begin(),nums.end());
        int n = nums.size();
        int res = 0;
        for(int i=0;i<n-1;i++){
            int diff = nums[i+1]-nums[i];
            if(diff>0){
                res += diff*(n-i);
            }
        }
        return res;
    }
};