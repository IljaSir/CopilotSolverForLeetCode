class Solution {
public:
    vector<string> watchedVideosByFriends(vector<vector<string>>& watchedVideos, vector<vector<int>>& friends, int id, int level) {
        
        vector<int> visited(friends.size(), 0);
        visited[id] = 1;
        queue<int> q;
        q.push(id);
        int curLevel = 0;
        while (!q.empty()) {
            int size = q.size();
            for (int i = 0; i < size; i++) {
                int cur = q.front();
                q.pop();
                if (curLevel == level) {
                    unordered_map<string, int> m;
                    for (string s : watchedVideos[cur]) {
                        m[s]++;
                    }
                    for (int f : friends[cur]) {
                        if (!visited[f]) {
                            for (string s : watchedVideos[f]) {
                                m[s]++;
                            }
                        }
                    }
                    vector<pair<string, int>> v;
                    for (auto it = m.begin(); it != m.end(); it++) {
                        v.push_back(make_pair(it->first, it->second));
                    }
                    sort(v.begin(), v.end(), [](pair<string, int> a, pair<string, int> b) {
                        if (a.second == b.second) {
                            return a.first < b.first;
                        }
                        return a.second < b.second;
                    });
                    vector<string> res;
                    for (int i = 0; i < v.size(); i++) {
                        res.push_back(v[i].first);
                    }
                    return res;
                }
                for (int f : friends[cur]) {
                    if (!visited[f]) {
                        visited[f] = 1;
                        q.push(f);
                    }
                }
            }
            curLevel++;
        }
        return {};
    }
};