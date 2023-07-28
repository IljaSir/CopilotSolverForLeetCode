class Solution {
public:
    vector<int> arrayRankTransform(vector<int>& arr) {
        
        vector<int> res;
        if (arr.size() == 0) return res;
        vector<int> sorted(arr);
        sort(sorted.begin(), sorted.end());
        unordered_map<int, int> rank;
        rank[sorted[0]] = 1;
        int r = 1;
        for (int i = 1; i < sorted.size(); i++) {
            if (sorted[i] != sorted[i-1]) {
                rank[sorted[i]] = ++r;
            }
        }
        for (int i = 0; i < arr.size(); i++) {
            res.push_back(rank[arr[i]]);
        }
        return res;
    }
};