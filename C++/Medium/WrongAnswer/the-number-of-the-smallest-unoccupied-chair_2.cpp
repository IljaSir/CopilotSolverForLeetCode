class Solution {
public:
    int smallestChair(vector<vector<int>>& times, int targetFriend) {
        
        int n = times.size();
        map<int, int> arrive;
        map<int, int> leave;
        for (int i = 0; i < n; i++) {
            arrive[times[i][0]] = i;
            leave[times[i][1]] = i;
        }
        map<int, int> chair;
        int count = 0;
        for (auto& [time, idx]: arrive) {
            if (idx == targetFriend) {
                for (auto& [t, i]: chair) {
                    if (i == 0) {
                        return t;
                    }
                }
            }
            chair[count] = 1;
            count++;
            while (leave.count(time)) {
                int i = leave[time];
                for (auto& [t, c]: chair) {
                    if (c == i + 1) {
                        c = 0;
                    }
                }
                leave.erase(time);
            }
        }
        return -1;
    }
};