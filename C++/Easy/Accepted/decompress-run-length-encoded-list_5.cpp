class Solution {
public:
    vector<int> decompressRLElist(vector<int>& nums) {
        
        vector<int> res;
        for (int i = 0; i < nums.size(); i += 2) {
            int freq = nums[i], val = nums[i+1];
            for (int j = 0; j < freq; ++j) {
                res.push_back(val);
            }
        }
        return res;
    }
};