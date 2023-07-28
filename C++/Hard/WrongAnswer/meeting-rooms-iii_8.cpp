class Solution {
public:
    int mostBooked(int n, vector<vector<int>>& meetings) {
        
        int res = 0;
        vector<int> rooms(n);
        for (auto &m : meetings) {
            int start = m[0], end = m[1];
            for (int i = 0; i < n; ++i) {
                if (rooms[i] <= start) {
                    rooms[i] = end;
                    res = max(res, i);
                    break;
                }
            }
        }
        return res;
    }
};