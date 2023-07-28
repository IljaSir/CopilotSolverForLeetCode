class Solution {
public:
    vector<int> kWeakestRows(vector<vector<int>>& mat, int k) {
        
        priority_queue<pair<int, int>> pq;
        for (int i = 0; i < mat.size(); ++i) {
            pq.push({-accumulate(mat[i].begin(), mat[i].end(), 0), -i});
            if (pq.size() > k) pq.pop();
        }
        vector<int> res;
        while (!pq.empty()) {
            res.push_back(-pq.top().second);
            pq.pop();
        }
        return res;
    }
};