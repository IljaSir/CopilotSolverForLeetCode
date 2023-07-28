class Solution {
public:
    vector<vector<int>> kSmallestPairs(vector<int>& nums1, vector<int>& nums2, int k) {
        
        vector<vector<int>> res;
        if (nums1.empty() || nums2.empty() || k <= 0) return res;
        auto comp = [&nums1, &nums2](const pair<int, int>& a, const pair<int, int>& b) {
            return nums1[a.first] + nums2[a.second] > nums1[b.first] + nums2[b.second];
        };
        priority_queue<pair<int, int>, vector<pair<int, int>>, decltype(comp)> q(comp);
        q.push({0, 0});
        while (!q.empty() && k > 0) {
            auto p = q.top();
            q.pop();
            res.push_back({nums1[p.first], nums2[p.second]});
            if (p.first + 1 < nums1.size()) q.push({p.first + 1, p.second});
            if (p.first == 0 && p.second + 1 < nums2.size()) q.push({p.first, p.second + 1});
            k--;
        }
        return res;
    }
};