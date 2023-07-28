class Solution {
public:
    vector<int> minInterval(vector<vector<int>>& intervals, vector<int>& queries) {
        
        // sort intervals by left
        // sort queries by value
        // iterate queries and find min interval for each query
        // return min interval
        sort(intervals.begin(), intervals.end(), [](const vector<int>& a, const vector<int>& b) {
            return a[0] < b[0];
        });
        sort(queries.begin(), queries.end());
        vector<int> ans;
        vector<vector<int>> q;
        for (int i = 0; i < queries.size(); ++i) {
            q.push_back({queries[i], i});
        }
        sort(q.begin(), q.end(), [](const vector<int>& a, const vector<int>& b) {
            return a[0] < b[0];
        });
        int qId = 0;
        multiset<int> s;
        for (int i = 0; i < queries.size(); ++i) {
            while (qId < intervals.size() && intervals[qId][0] <= queries[i]) {
                s.insert(intervals[qId][1] - intervals[qId][0] + 1);
                ++qId;
            }
            while (!s.empty() && *s.begin() < queries[i]) {
                s.erase(s.begin());
            }
            if (s.empty()) {
                ans.push_back(-1);
            } else {
                ans.push_back(*s.begin());
            }
        }
        return ans;
    }
};