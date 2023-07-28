class Solution {
public:
    int smallestChair(vector<vector<int>>& times, int targetFriend) {
        
        int n = times.size();
        vector<int> chairs(n);
        for (int i = 0; i < n; ++i) {
            chairs[i] = i;
        }
        vector<pair<int, int>> events;
        for (int i = 0; i < n; ++i) {
            events.emplace_back(times[i][0], i);
            events.emplace_back(times[i][1], i);
        }
        sort(events.begin(), events.end());
        set<int> occupied;
        for (auto& event : events) {
            int time = event.first;
            int idx = event.second;
            if (time < times[idx][1]) {
                occupied.insert(chairs[idx]);
            } else {
                occupied.erase(chairs[idx]);
                chairs[idx] = *occupied.begin();
                if (idx == targetFriend) {
                    return chairs[idx];
                }
            }
        }
        return -1;
    }
};