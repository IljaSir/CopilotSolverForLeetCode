class Solution {
public:
    bool canFormArray(vector<int>& arr, vector<vector<int>>& pieces) {
        
        unordered_map<int, int> mp;
        for (int i = 0; i < arr.size(); i++) {
            mp[arr[i]] = i;
        }
        for (auto& piece : pieces) {
            for (int i = 0; i < piece.size(); i++) {
                if (!mp.count(piece[i])) {
                    return false;
                }
                if (i == 0) {
                    continue;
                }
                if (mp[piece[i]] - mp[piece[i - 1]] != 1) {
                    return false;
                }
            }
        }
        return true;
    }
};