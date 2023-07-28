class Solution {
public:
    vector<vector<int>> kSmallestPairs(vector<int>& nums1, vector<int>& nums2, int k) {
        
        vector<vector<int>> result;
        if (nums1.size() == 0 || nums2.size() == 0)
            return result;
        priority_queue<pair<int, pair<int, int>>> pq;
        for (int i = 0; i < nums1.size(); i++) {
            pq.push(make_pair(nums1[i] + nums2[0], make_pair(i, 0)));
        }
        while (k-- && !pq.empty()) {
            auto p = pq.top();
            pq.pop();
            int i = p.second.first;
            int j = p.second.second;
            result.push_back({nums1[i], nums2[j]});
            if (j + 1 < nums2.size())
                pq.push(make_pair(nums1[i] + nums2[j + 1], make_pair(i, j + 1)));
        }
        return result;
    }
};