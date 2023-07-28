class Solution {
public:
    int smallestChair(vector<vector<int>>& times, int targetFriend) {
        
        vector<pair<int, int>> events;
        for (int i = 0; i < times.size(); ++i) {
            events.emplace_back(times[i][0], i);
            events.emplace_back(times[i][1], i);
        }
        sort(events.begin(), events.end());
        set<int> chairs;
        for (int i = 0; i < times.size(); ++i) {
            chairs.insert(i);
        }
        unordered_map<int, int> occupied;
        for (auto& e : events) {
            int t = e.first;
            int i = e.second;
            if (times[i][0] == t) {
                int chair = *chairs.begin();
                chairs.erase(chairs.begin());
                occupied[chair] = i;
            } else {
                for (auto it = occupied.begin(); it != occupied.end(); ++it) {
                    if (it->second == i) {
                        chairs.insert(it->first);
                        occupied.erase(it);
                        break;
                    }
                }
            }
            if (i == targetFriend) {
                for (auto& p : occupied) {
                    if (p.second == i) {
                        return p.first;
                    }
                }
            }
        }
        return -1;
    }
};