class Solution {
public:
    vector<int> sortedSquares(vector<int>& nums) {
        
        vector<int> ret;
        for(auto& n: nums)
            ret.push_back(n*n);
        sort(ret.begin(), ret.end());
        return ret;
    }
};