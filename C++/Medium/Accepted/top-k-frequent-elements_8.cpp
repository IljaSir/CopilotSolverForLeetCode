class Solution {
public:
    vector<int> topKFrequent(vector<int>& nums, int k) {
        
        map<int, int> freq;
        for(auto n: nums){
            freq[n]++;
        }
        vector<vector<int>> vec(nums.size()+1);
        for(auto p: freq){
            vec[p.second].push_back(p.first);
        }
        vector<int> result;
        for(int i=nums.size(); i>=0; i--){
            if(vec[i].size()>0){
                for(auto n: vec[i]){
                    result.push_back(n);
                    if(result.size()==k) return result;
                }
            }
        }
        return result;
    }
};