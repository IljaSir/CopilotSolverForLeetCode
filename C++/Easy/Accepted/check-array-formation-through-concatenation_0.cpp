class Solution {
public:
    bool canFormArray(vector<int>& arr, vector<vector<int>>& pieces) {
        
        unordered_map<int, int> m;
        for (int i = 0; i < pieces.size(); ++i) {
            m[pieces[i][0]] = i;
        }
        int i = 0;
        while (i < arr.size()) {
            if (m.count(arr[i]) == 0) {
                return false;
            }
            int j = 0;
            int index = m[arr[i]];
            while (j < pieces[index].size() && i < arr.size() && arr[i] == pieces[index][j]) {
                ++i;
                ++j;
            }
            if (j != pieces[index].size()) {
                return false;
            }
        }
        return true;
    }
};