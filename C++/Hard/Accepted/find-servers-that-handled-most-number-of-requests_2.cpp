class Solution {
public:
    vector<int> busiestServers(int k, vector<int>& arrival, vector<int>& load) {
        
        set<int> free;
        for(int i = 0; i < k; i++) free.insert(i);
        vector<int> cnt(k, 0);
        priority_queue<pair<int, int>, vector<pair<int, int>>, greater<pair<int, int>>> pq;
        for(int i = 0; i < arrival.size(); i++) {
            while(!pq.empty() && pq.top().first <= arrival[i]) {
                free.insert(pq.top().second);
                pq.pop();
            }
            if(free.empty()) continue;
            auto it = free.lower_bound(i % k);
            if(it == free.end()) it = free.begin();
            cnt[*it]++;
            pq.push({arrival[i] + load[i], *it});
            free.erase(it);
        }
        int maxCnt = *max_element(cnt.begin(), cnt.end());
        vector<int> ans;
        for(int i = 0; i < k; i++) {
            if(cnt[i] == maxCnt) ans.push_back(i);
        }
        return ans;
    }
};