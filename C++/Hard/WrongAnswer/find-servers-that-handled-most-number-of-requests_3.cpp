class Solution {
public:
    vector<int> busiestServers(int k, vector<int>& arrival, vector<int>& load) {
        
        set<int> available;
        for (int i = 0; i < k; ++i) available.insert(i);
        map<int, int> serverCount;
        for (int i = 0; i < arrival.size(); ++i) {
            int start = arrival[i];
            int end = start + load[i];
            auto it = available.lower_bound(i % k);
            if (it == available.end()) it = available.begin();
            if (it == available.end()) continue;
            int server = *it;
            available.erase(it);
            serverCount[server]++;
            available.insert((server + 1) % k);
            while (!available.empty() && *available.begin() < server) {
                available.erase(available.begin());
            }
        }
        vector<int> ans;
        int maxCount = 0;
        for (auto p: serverCount) {
            if (p.second > maxCount) {
                maxCount = p.second;
                ans = {p.first};
            } else if (p.second == maxCount) {
                ans.push_back(p.first);
            }
        }
        return ans;
    }
};