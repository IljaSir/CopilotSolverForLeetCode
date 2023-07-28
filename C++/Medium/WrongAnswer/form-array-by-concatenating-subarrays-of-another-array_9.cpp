class Solution {
public:
    bool canChoose(vector<vector<int>>& groups, vector<int>& nums) {
        
        int i=0;
        for(auto g:groups){
            int j=0;
            while(i<nums.size() && j<g.size()){
                if(nums[i]==g[j]){
                    i++;
                    j++;
                }else{
                    i++;
                }
            }
            if(j<g.size()) return false;
        }
        return true;
    }
};