class Solution {
public:
    vector<int> arrayRankTransform(vector<int>& arr) {
        
        vector<int> res;
        set<int> s;
        for (int i = 0; i < arr.size(); i++) {
            s.insert(arr[i]);
        }
        map<int, int> m;
        int rank = 1;
        for (auto it = s.begin(); it != s.end(); it++) {
            m.insert(pair<int, int>(*it, rank));
            rank++;
        }
        for (int i = 0; i < arr.size(); i++) {
            res.push_back(m[arr[i]]);
        }
        return res;
    }
};