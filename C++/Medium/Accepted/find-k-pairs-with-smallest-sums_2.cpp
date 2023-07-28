class Solution {
public:
    vector<vector<int>> kSmallestPairs(vector<int>& nums1, vector<int>& nums2, int k) {
        
        int m = nums1.size();
        int n = nums2.size();
        vector<vector<int>> ans;
        if (m == 0 || n == 0 || k == 0) {
            return ans;
        }
        auto cmp = [&nums1, &nums2](const pair<int, int>& a, const pair<int, int>& b) {
            return nums1[a.first] + nums2[a.second] > nums1[b.first] + nums2[b.second];
        };
        priority_queue<pair<int, int>, vector<pair<int, int>>, decltype(cmp)> pq(cmp);
        pq.push({0, 0});
        while (!pq.empty() && k--) {
            auto [i, j] = pq.top();
            pq.pop();
            ans.push_back({nums1[i], nums2[j]});
            if (j == 0 && i + 1 < m) {
                pq.push({i + 1, j});
            }
            if (j + 1 < n) {
                pq.push({i, j + 1});
            }
        }
        return ans;
    }
};