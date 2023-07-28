class Solution {
public:
    long long taskSchedulerII(vector<int>& tasks, int space) {
        
        int n = tasks.size();
        if (n == 1) return 1;
        unordered_map<int, int> mp;
        for (int i = 0; i < n; i++) mp[tasks[i]]++;
        priority_queue<pair<int, int>> pq;
        for (auto it = mp.begin(); it != mp.end(); it++) {
            pq.push({it->second, it->first});
        }
        int cnt = 0, days = 0;
        vector<int> temp;
        while (cnt < n) {
            days++;
            int k = space + 1;
            while (k > 0 && !pq.empty()) {
                auto cur = pq.top(); pq.pop();
                temp.push_back(cur.first - 1);
                k--;
                cnt++;
            }
            for (int i = 0; i < temp.size(); i++) {
                if (temp[i] > 0) pq.push({temp[i], 0});
            }
            temp.clear();
            if (pq.empty()) break;
            if (k > 0) days += k;
        }
        return days;
    }
};