class Solution {
public:
    bool canFormArray(vector<int>& arr, vector<vector<int>>& pieces) {
        
        unordered_map<int, vector<int>> m;
        for (auto& v : pieces) {
            m[v[0]] = v;
        }
        int i = 0;
        while (i < arr.size()) {
            if (m.count(arr[i]) == 0) {
                return false;
            }
            auto& v = m[arr[i]];
            for (auto j : v) {
                if (j != arr[i]) {
                    return false;
                }
                ++i;
            }
        }
        return true;
    }
};