class Solution {
public:
    vector<int> intersection(vector<vector<int>>& nums) {
        
        vector<int> res;
        for(int i = 0; i < nums.size(); i++){
            for(int j = 0; j < nums[i].size(); j++){
                bool flag = true;
                for(int k = 0; k < nums.size(); k++){
                    if(i == k) continue;
                    if(find(nums[k].begin(), nums[k].end(), nums[i][j]) == nums[k].end()){
                        flag = false;
                        break;
                    }
                }
                if(flag) res.push_back(nums[i][j]);
            }
        }
        sort(res.begin(), res.end());
        res.erase(unique(res.begin(), res.end()), res.end());
        return res;
    }
};