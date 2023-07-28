class Solution {
public:
    int minOperations(vector<int>& nums, int x) {
        
        int n=nums.size();
        unordered_map<int,int> mp;
        int sum=0;
        for(int i=0;i<n;i++){
            sum+=nums[i];
            mp[sum]=i;
        }
        if(sum==x) return n;
        if(sum<x) return -1;
        int ans=-1;
        for(int i=0;i<n;i++){
            int diff=sum-x-nums[i];
            if(diff<0) break;
            if(mp.count(diff)){
                ans=max(ans,mp[diff]-i);
            }
        }
        if(ans!=-1) ans=n-ans-1;
        return ans;
    }
};