class Solution {
public:
    vector<int> rearrangeArray(vector<int>& nums) {
        
        sort(nums.begin(),nums.end());
        int n = nums.size();
        vector<int>ans(n);
        for(int i=0;i<n/2;i++){
            ans[2*i] = nums[i];
            ans[2*i+1] = nums[n/2+i];
        }
        if(n%2 == 1){
            ans[n-1] = nums[n-1];
        }
        return ans;
    }
};