class Solution {
public:
    vector<int> busiestServers(int k, vector<int>& arrival, vector<int>& load) {
        
        vector<int> servers(k, 0);
        priority_queue<pair<int, int>, vector<pair<int, int>>, greater<pair<int, int>>> pq;
        for (int i = 0; i < arrival.size(); ++i) {
            while (!pq.empty() && pq.top().first <= arrival[i]) {
                servers[pq.top().second] = 0;
                pq.pop();
            }
            int j = i % k;
            while (servers[j] != 0) {
                j = (j + 1) % k;
            }
            servers[j] = 1;
            pq.push({arrival[i] + load[i], j});
        }
        int max = 0;
        for (int i = 0; i < servers.size(); ++i) {
            if (servers[i] > max) max = servers[i];
        }
        vector<int> res;
        for (int i = 0; i < servers.size(); ++i) {
            if (servers[i] == max) res.push_back(i);
        }
        return res;
    }
};