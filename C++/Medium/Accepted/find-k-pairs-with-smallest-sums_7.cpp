class Solution {
public:
    vector<vector<int>> kSmallestPairs(vector<int>& nums1, vector<int>& nums2, int k) {
        
        vector<vector<int>> ret;
        if (nums1.size() == 0 || nums2.size() == 0) {
            return ret;
        }
        priority_queue<pair<int, pair<int, int>>> pq;
        pq.push(make_pair(-(nums1[0] + nums2[0]), make_pair(0, 0)));
        while (k > 0 && pq.size() > 0) {
            auto p = pq.top();
            pq.pop();
            int i = p.second.first;
            int j = p.second.second;
            ret.push_back({nums1[i], nums2[j]});
            if (i + 1 < nums1.size()) {
                pq.push(make_pair(-(nums1[i + 1] + nums2[j]), make_pair(i + 1, j)));
            }
            if (i == 0 && j + 1 < nums2.size()) {
                pq.push(make_pair(-(nums1[i] + nums2[j + 1]), make_pair(i, j + 1)));
            }
            k--;
        }
        return ret;
    }
};