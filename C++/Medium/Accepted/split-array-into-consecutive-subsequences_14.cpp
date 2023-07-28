class Solution {
public:
    bool isPossible(vector<int>& nums) {
        
        map<int,int> m;
        for(int i=0;i<nums.size();i++){
            m[nums[i]]++;
        }
        map<int,int> m1;
        for(int i=0;i<nums.size();i++){
            if(m[nums[i]]==0) continue;
            if(m1[nums[i]-1]>0){
                m[nums[i]]--;
                m1[nums[i]-1]--;
                m1[nums[i]]++;
            }
            else if(m[nums[i]]>0 && m[nums[i]+1]>0 && m[nums[i]+2]>0){
                m[nums[i]]--;
                m[nums[i]+1]--;
                m[nums[i]+2]--;
                m1[nums[i]+2]++;
            }
            else{
                return false;
            }
        }
        return true;
    }
};