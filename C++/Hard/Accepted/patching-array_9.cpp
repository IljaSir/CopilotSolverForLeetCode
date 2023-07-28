class Solution {
public:
    int minPatches(vector<int>& nums, int n) {
        
        int i=0;
        long long sum=0;
        int ans=0;
        while(sum<n){
            if(i<nums.size() && sum+1>=nums[i]){
                sum+=nums[i];
                i++;
            }else{
                ans++;
                sum+=sum+1;
            }
        }
        return ans;
    }
};