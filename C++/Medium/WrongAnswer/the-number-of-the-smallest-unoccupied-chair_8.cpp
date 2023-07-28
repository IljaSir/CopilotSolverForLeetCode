class Solution {
public:
    int smallestChair(vector<vector<int>>& times, int targetFriend) {
        
        // sort by arrival time
        sort(times.begin(), times.end(), [](const auto& a, const auto& b) {
            return a[0] < b[0];
        });
        
        // min heap of leaving time
        priority_queue<int, vector<int>, greater<int>> pq;
        // all chairs are empty
        for (int i = 0; i < times.size(); i++) {
            pq.push(i);
        }
        
        // map of leaving time to chair number
        map<int, int> m;
        for (auto& time : times) {
            // get the chair number
            int chair = pq.top();
            pq.pop();
            
            // record the chair number
            m[time[1]] = chair;
            if (time[0] == times[targetFriend][0]) {
                return chair;
            }
            
            // free the chair when leaving
            while (!m.empty() && m.begin()->first <= time[0]) {
                pq.push(m.begin()->second);
                m.erase(m.begin());
            }
        }
        return -1;
    }
};