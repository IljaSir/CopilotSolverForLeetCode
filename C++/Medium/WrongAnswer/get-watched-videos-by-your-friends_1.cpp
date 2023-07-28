class Solution {
public:
    vector<string> watchedVideosByFriends(vector<vector<string>>& watchedVideos, vector<vector<int>>& friends, int id, int level) {
        
        int n = watchedVideos.size();
        vector<int> dist(n, INT_MAX);
        dist[id] = 0;
        queue<int> q;
        q.push(id);
        while (!q.empty()) {
            int u = q.front(); q.pop();
            for (int v : friends[u]) {
                if (dist[v] == INT_MAX) {
                    dist[v] = dist[u] + 1;
                    q.push(v);
                }
            }
        }
        vector<string> res;
        unordered_map<string, int> cnt;
        for (int i = 0; i < n; ++i) {
            if (dist[i] == level) {
                for (string video : watchedVideos[i]) {
                    ++cnt[video];
                }
            }
        }
        sort(res.begin(), res.end(), [&](string& a, string& b) {
            if (cnt[a] == cnt[b]) {
                return a < b;
            }
            return cnt[a] < cnt[b];
        });
        return res;
    }
};