class Solution {
public:
    vector<vector<int>> kSmallestPairs(vector<int>& nums1, vector<int>& nums2, int k) {
        
        vector<vector<int>> res;
        if (nums1.size() == 0 || nums2.size() == 0 || k == 0) {
            return res;
        }
        priority_queue<pair<int, pair<int, int>>> pq;
        for (int i = 0; i < nums1.size(); i++) {
            pq.push(make_pair(-nums1[i] - nums2[0], make_pair(i, 0)));
        }
        while (k > 0 && !pq.empty()) {
            auto item = pq.top();
            pq.pop();
            res.push_back({nums1[item.second.first], nums2[item.second.second]});
            if (item.second.second + 1 < nums2.size()) {
                pq.push(make_pair(-nums1[item.second.first] - nums2[item.second.second + 1], make_pair(item.second.first, item.second.second + 1)));
            }
            k--;
        }
        return res;
    }
};