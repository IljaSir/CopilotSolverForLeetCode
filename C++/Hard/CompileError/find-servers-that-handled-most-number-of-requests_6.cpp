class Solution {
public:
    vector<int> busiestServers(int k, vector<int>& arrival, vector<int>& load) {
        
        vector<int> busy(k);
        vector<int> count(k);
        int n = arrival.size();
        set<int> free;
        for (int i = 0; i < k; ++i) {
            free.insert(i);
        }
        for (int i = 0; i < n; ++i) {
            int start = arrival[i];
            int end = start + load[i];
            while (!busy.empty() && busy.front() <= start) {
                free.insert(busy.front() % k);
                busy.pop_front();
            }
            if (free.empty()) {
                continue;
            }
            auto it = free.lower_bound(i % k);
            if (it == free.end()) {
                it = free.begin();
            }
            int id = *it;
            free.erase(it);
            busy.push_back(end);
            ++count[id];
        }
        int maxCount = *max_element(count.begin(), count.end());
        vector<int> ans;
        for (int i = 0; i < k; ++i) {
            if (count[i] == maxCount) {
                ans.push_back(i);
            }
        }
        return ans;
    }
};