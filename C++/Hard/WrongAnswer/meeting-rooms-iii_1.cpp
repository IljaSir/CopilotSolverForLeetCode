class Solution {
public:
    int mostBooked(int n, vector<vector<int>>& meetings) {
        
        vector<int> starts, ends;
        for (auto meeting : meetings) {
            starts.push_back(meeting[0]);
            ends.push_back(meeting[1]);
        }
        sort(starts.begin(), starts.end());
        sort(ends.begin(), ends.end());
        int ans = 0, cur = 0;
        for (int i = 0, j = 0; i < starts.size(); ++i) {
            while (ends[j] <= starts[i]) {
                ++j;
                --cur;
            }
            ++cur;
            ans = max(ans, cur);
        }
        return ans;
    }
};