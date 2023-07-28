class Solution {
public:
    vector<int> findAllPeople(int n, vector<vector<int>>& meetings, int firstPerson) {
        
        vector<int> res;
        vector<int> time(n, INT_MAX);
        vector<bool> visited(n, false);
        time[firstPerson] = 0;
        for (int i = 0; i < meetings.size(); ++i) {
            int x = meetings[i][0], y = meetings[i][1], t = meetings[i][2];
            if (time[x] <= t && time[y] > t) {
                time[y] = t;
            }
            if (time[y] <= t && time[x] > t) {
                time[x] = t;
            }
        }
        for (int i = 0; i < n; ++i) {
            if (time[i] != INT_MAX) {
                res.push_back(i);
            }
        }
        return res;
    }
};