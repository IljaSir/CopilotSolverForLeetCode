class Solution {
public:
    vector<vector<int>> kClosest(vector<vector<int>>& points, int k) {
        
        vector<vector<int>> ans;
        auto cmp = [](vector<int> &a, vector<int> &b) { return a[0] * a[0] + a[1] * a[1] > b[0] * b[0] + b[1] * b[1]; };
        priority_queue<vector<int>, vector<vector<int>>, decltype(cmp)> pq(cmp);
        for (auto &p : points) {
            pq.push(p);
            if (pq.size() > k) pq.pop();
        }
        while (!pq.empty()) {
            ans.push_back(pq.top());
            pq.pop();
        }
        return ans;
    }
};