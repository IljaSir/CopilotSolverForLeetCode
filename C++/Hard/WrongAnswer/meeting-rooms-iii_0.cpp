class Solution {
public:
    int mostBooked(int n, vector<vector<int>>& meetings) {
        
        vector<int> starts, ends;
        for (auto m : meetings) {
            starts.push_back(m[0]);
            ends.push_back(m[1]);
        }
        sort(starts.begin(), starts.end());
        sort(ends.begin(), ends.end());
        int i = 0, j = 0, cnt = 0, maxCnt = 0, res = 0;
        while (i < starts.size()) {
            if (starts[i] < ends[j]) {
                ++i;
                ++cnt;
                if (cnt > maxCnt) {
                    maxCnt = cnt;
                    res = i - 1;
                }
            } else {
                ++j;
                --cnt;
            }
        }
        return starts[res];
    }
};