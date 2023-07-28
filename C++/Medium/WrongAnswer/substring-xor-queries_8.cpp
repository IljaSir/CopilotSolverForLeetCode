class Solution {
public:
    vector<vector<int>> substringXorQueries(string s, vector<vector<int>>& queries) {
        
        vector<vector<int>> ans;
        vector<int> xor_arr;
        int xor_val = 0;
        for (auto c : s) {
            xor_val ^= c - '0';
            xor_arr.push_back(xor_val);
        }
        for (auto q : queries) {
            if (q[0] == 0) {
                ans.push_back({0, xor_arr[q[1]]});
            } else {
                ans.push_back({q[0], xor_arr[q[1]] ^ xor_arr[q[0] - 1]});
            }
        }
        return ans;
    }
};