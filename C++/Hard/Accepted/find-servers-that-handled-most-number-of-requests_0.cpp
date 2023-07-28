class Solution {
public:
    vector<int> busiestServers(int k, vector<int>& arrival, vector<int>& load) {
        
        set<int> available;
        for (int i = 0; i < k; i++) {
            available.insert(i);
        }
        priority_queue<pair<int, int>, vector<pair<int, int>>, greater<pair<int, int>>> finished;
        vector<int> busy(k, 0);
        for (int i = 0; i < arrival.size(); i++) {
            int start = arrival[i];
            int end = start + load[i];
            while (finished.size() && finished.top().first <= start) {
                available.insert(finished.top().second);
                finished.pop();
            }
            if (available.size() == 0) {
                continue;
            }
            int server = i % k;
            auto it = available.lower_bound(server);
            if (it == available.end()) {
                it = available.begin();
            }
            busy[*it]++;
            finished.push({end, *it});
            available.erase(it);
        }
        int max_busy = 0;
        vector<int> result;
        for (int i = 0; i < k; i++) {
            if (busy[i] > max_busy) {
                max_busy = busy[i];
                result = {i};
            } else if (busy[i] == max_busy) {
                result.push_back(i);
            }
        }
        return result;
    }
};