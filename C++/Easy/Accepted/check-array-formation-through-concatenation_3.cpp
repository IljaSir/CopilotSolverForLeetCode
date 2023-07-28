class Solution {
public:
    bool canFormArray(vector<int>& arr, vector<vector<int>>& pieces) {
        
        unordered_map<int, int> mp;
        for (int i = 0; i < arr.size(); i++) {
            mp[arr[i]] = i;
        }
        for (auto& piece : pieces) {
            if (mp.find(piece[0]) == mp.end()) {
                return false;
            }
            int pos = mp[piece[0]];
            for (auto& n : piece) {
                if (pos >= arr.size() || arr[pos] != n) {
                    return false;
                }
                pos++;
            }
        }
        return true;
    }
};