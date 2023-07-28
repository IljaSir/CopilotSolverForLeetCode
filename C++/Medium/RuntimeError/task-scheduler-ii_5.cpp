class Solution {
public:
    long long taskSchedulerII(vector<int>& tasks, int space) {
        
        map<int, int> count;
        for (int task: tasks) {
            count[task]++;
        }
        priority_queue<pair<int, int>> pq;
        for (auto& it: count) {
            pq.push({it.second, it.first});
        }
        multiset<pair<int, int>> ms;
        int days = 0;
        while (!pq.empty() || !ms.empty()) {
            if (ms.empty()) {
                days += pq.top().first;
                ms.insert({days + space, pq.top().second});
                pq.pop();
            }
            else {
                auto it = ms.begin();
                days = max(days, it->first);
                int freq = it->second;
                ms.erase(it);
                if (--freq > 0) {
                    pq.push({freq, it->second});
                }
            }
        }
        return days;
    }
};