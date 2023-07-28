class Solution {
public:
    vector<int> arrayRankTransform(vector<int>& arr) {
        
        vector<int> res;
        map<int, int> rank;
        for (int i = 0; i < arr.size(); i++) {
            rank[arr[i]] = 0;
        }
        int r = 1;
        for (auto &it : rank) {
            it.second = r++;
        }
        for (int i = 0; i < arr.size(); i++) {
            res.push_back(rank[arr[i]]);
        }
        return res;
    }
};