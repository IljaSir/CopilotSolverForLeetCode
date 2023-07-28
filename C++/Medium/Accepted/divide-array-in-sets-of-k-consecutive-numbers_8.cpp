class Solution {
public:
    bool isPossibleDivide(vector<int>& nums, int k) {
        
        if(nums.size()%k!=0) return false;
        map<int,int> mp;
        for(int i=0;i<nums.size();i++){
            mp[nums[i]]++;
        }
        int count=0;
        for(auto it:mp){
            if(it.second>0){
                for(int i=0;i<k;i++){
                    if(mp.find(it.first+i)==mp.end() || mp[it.first+i]<it.second) return false;
                    mp[it.first+i]-=it.second;
                }
            }
        }
        return true;
    }
};