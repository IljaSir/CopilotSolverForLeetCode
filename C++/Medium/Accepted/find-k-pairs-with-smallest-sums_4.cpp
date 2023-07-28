class Solution {
public:
    vector<vector<int>> kSmallestPairs(vector<int>& nums1, vector<int>& nums2, int k) {
        
        vector<vector<int>> result;
        int n1 = nums1.size();
        int n2 = nums2.size();
        if (n1 == 0 || n2 == 0) return result;
        priority_queue<pair<int, pair<int, int>>> pq;
        for (int i = 0; i < n1; ++i) {
            pq.push({-nums1[i] - nums2[0], {i, 0}});
        }
        while (k > 0 && !pq.empty()) {
            auto p = pq.top();
            pq.pop();
            result.push_back({nums1[p.second.first], nums2[p.second.second]});
            if (p.second.second + 1 < n2) {
                pq.push({-nums1[p.second.first] - nums2[p.second.second + 1], {p.second.first, p.second.second + 1}});
            }
            --k;
        }
        return result;
    }
};