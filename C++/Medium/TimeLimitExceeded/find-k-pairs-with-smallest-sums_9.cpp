class Solution {
public:
    vector<vector<int>> kSmallestPairs(vector<int>& nums1, vector<int>& nums2, int k) {
        
        vector<vector<int>> result;
        priority_queue<pair<int, int>> q;
        for(int i = 0; i < nums1.size(); i++) {
            for(int j = 0; j < nums2.size(); j++) {
                if(q.size() < k) {
                    q.push({nums1[i] + nums2[j], i});
                } else if(nums1[i] + nums2[j] < q.top().first) {
                    q.pop();
                    q.push({nums1[i] + nums2[j], i});
                }
            }
        }
        while(!q.empty()) {
            result.push_back({nums1[q.top().second], q.top().first - nums1[q.top().second]});
            q.pop();
        }
        return result;
    }
};