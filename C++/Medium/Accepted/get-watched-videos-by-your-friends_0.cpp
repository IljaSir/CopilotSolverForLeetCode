class Solution {
public:
    vector<string> watchedVideosByFriends(vector<vector<string>>& watchedVideos, vector<vector<int>>& friends, int id, int level) {
        
        int n = friends.size();
        vector<int> dist(n, INT_MAX);
        dist[id] = 0;
        queue<int> q;
        q.push(id);
        while (!q.empty()) {
            int u = q.front();
            q.pop();
            for (int v : friends[u]) {
                if (dist[v] == INT_MAX) {
                    dist[v] = dist[u] + 1;
                    q.push(v);
                }
            }
        }
        unordered_map<string, int> cnt;
        for (int i = 0; i < n; i++) {
            if (dist[i] == level) {
                for (string& video : watchedVideos[i]) {
                    cnt[video]++;
                }
            }
        }
        vector<pair<string, int>> v;
        for (auto& [video, c] : cnt) {
            v.push_back({video, c});
        }
        sort(v.begin(), v.end(), [](auto& a, auto& b) {
            if (a.second == b.second) {
                return a.first < b.first;
            }
            return a.second < b.second;
        });
        vector<string> ans;
        for (auto& [video, c] : v) {
            ans.push_back(video);
        }
        return ans;
    }
};