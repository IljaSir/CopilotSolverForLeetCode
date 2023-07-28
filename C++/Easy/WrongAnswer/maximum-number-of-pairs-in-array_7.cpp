class Solution {
public:
    vector<int> numberOfPairs(vector<int>& nums) {
        
        vector<int> res(2,0);
        int n = nums.size();
        if(n==1)
            return res;
        sort(nums.begin(),nums.end());
        int i=0;
        while(i<n-1){
            if(nums[i]==nums[i+1]){
                res[0]++;
                i+=2;
            }
            else
                i++;
        }
        res[1]=n-res[0]*2;
        return res;
    }
};