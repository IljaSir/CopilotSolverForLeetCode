class Solution {
public:
    vector<vector<int>> kSmallestPairs(vector<int>& nums1, vector<int>& nums2, int k) {
        
        vector<vector<int>> res;
        int m = nums1.size();
        int n = nums2.size();
        if (m == 0 || n == 0) return res;
        priority_queue<pair<int, pair<int, int>>, vector<pair<int, pair<int, int>>>, greater<pair<int, pair<int, int>>>> pq; // min heap
        for (int i = 0; i < m; i++) pq.push({nums1[i] + nums2[0], {i, 0}});
        while (k-- && !pq.empty()) {
            auto p = pq.top();
            pq.pop();
            res.push_back({nums1[p.second.first], nums2[p.second.second]});
            if (p.second.second + 1 < n) {
                pq.push({nums1[p.second.first] + nums2[p.second.second + 1], {p.second.first, p.second.second + 1}});
            }
        }
        return res;
    }
};