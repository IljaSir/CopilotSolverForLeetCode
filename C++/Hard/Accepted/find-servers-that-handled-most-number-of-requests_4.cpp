class Solution {
public:
    vector<int> busiestServers(int k, vector<int>& arrival, vector<int>& load) {
        
        vector<int> res;
        int n = arrival.size();
        priority_queue<pair<int, int>, vector<pair<int, int>>, greater<pair<int, int>>> pq;
        set<int> avail;
        for (int i = 0; i < k; i++) avail.insert(i);
        vector<int> cnt(k, 0);
        for (int i = 0; i < n; i++) {
            int t = arrival[i];
            int l = load[i];
            while (!pq.empty() && pq.top().first <= t) {
                avail.insert(pq.top().second);
                pq.pop();
            }
            if (avail.empty()) continue;
            auto it = avail.lower_bound(i % k);
            if (it == avail.end()) it = avail.begin();
            int s = *it;
            cnt[s]++;
            pq.push({t + l, s});
            avail.erase(s);
        }
        int mx = *max_element(cnt.begin(), cnt.end());
        for (int i = 0; i < k; i++) {
            if (cnt[i] == mx) res.push_back(i);
        }
        return res;
    }
};