class Solution {
public:
    bool canChoose(vector<vector<int>>& groups, vector<int>& nums) {
        
        int i = 0;
        while(i < groups.size()){
            bool flag = false;
            for(int j = 0; j < nums.size(); j++){
                if(nums[j] == groups[i][0]){
                    int k = 0;
                    while(k < groups[i].size() && j + k < nums.size() && nums[j + k] == groups[i][k]){
                        k++;
                    }
                    if(k == groups[i].size()){
                        i++;
                        flag = true;
                        break;
                    }
                }
            }
            if(!flag){
                return false;
            }
        }
        return true;
    }
};