class Solution {
public:
    vector<int> sortEvenOdd(vector<int>& nums) {
        
        int n = nums.size();
        sort(nums.begin(),nums.end());
        vector<int> ans(n,0);
        for(int i=0;i<n;i+=2)
        {
            ans[i] = nums[i/2];
        }
        for(int i=1;i<n;i+=2)
        {
            ans[i] = nums[n/2+(i-1)/2];
        }
        return ans;
    }
};