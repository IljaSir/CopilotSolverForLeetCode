class Solution {
public:
    vector<int> xorQueries(vector<int>& arr, vector<vector<int>>& queries) {
        
        vector<int> prefixXor;
        int xorVal = 0;
        for (auto &val: arr) {
            xorVal ^= val;
            prefixXor.push_back(xorVal);
        }
        
        vector<int> result;
        for (auto &query: queries) {
            int left = query[0];
            int right = query[1];
            
            if (left == 0) {
                result.push_back(prefixXor[right]);
            } else {
                result.push_back(prefixXor[right] ^ prefixXor[left - 1]);
            }
        }
        
        return result;
    }
};