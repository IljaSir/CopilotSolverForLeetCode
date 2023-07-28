class Solution {
public:
    vector<string> watchedVideosByFriends(vector<vector<string>>& watchedVideos, vector<vector<int>>& friends, int id, int level) {
        
        vector<string> res;
        unordered_map<string, int> m;
        queue<int> q;
        q.push(id);
        int l = 0;
        vector<int> visited(friends.size(), 0);
        visited[id] = 1;
        while (!q.empty()) {
            int n = q.size();
            for (int i = 0; i < n; i++) {
                int t = q.front(); q.pop();
                if (l == level) {
                    for (string s : watchedVideos[t]) {
                        m[s]++;
                    }
                }
                else {
                    for (int f : friends[t]) {
                        if (visited[f] == 0) {
                            visited[f] = 1;
                            q.push(f);
                        }
                    }
                }
            }
            l++;
        }
        vector<pair<int, string>> v;
        for (auto it = m.begin(); it != m.end(); it++) {
            v.push_back({it->second, it->first});
        }
        sort(v.begin(), v.end());
        for (auto p : v) {
            res.push_back(p.second);
        }
        return res;
    }
};