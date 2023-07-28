class Solution {
public:
    vector<string> watchedVideosByFriends(vector<vector<string>>& watchedVideos, vector<vector<int>>& friends, int id, int level) {
        
        int n = watchedVideos.size();
        vector<bool> visited(n, false);
        queue<int> q;
        q.push(id);
        visited[id] = true;
        int depth = 0;
        while (!q.empty()) {
            int sz = q.size();
            for (int i = 0; i < sz; ++i) {
                int cur = q.front();
                q.pop();
                if (depth == level) {
                    unordered_map<string, int> mp;
                    for (const string& video : watchedVideos[cur]) {
                        ++mp[video];
                    }
                    vector<pair<int, string>> vec;
                    for (const auto& p : mp) {
                        vec.push_back({p.second, p.first});
                    }
                    sort(vec.begin(), vec.end());
                    vector<string> ans;
                    for (const auto& p : vec) {
                        ans.push_back(p.second);
                    }
                    return ans;
                }
                for (int next : friends[cur]) {
                    if (!visited[next]) {
                        q.push(next);
                        visited[next] = true;
                    }
                }
            }
            ++depth;
        }
        return {};
    }
};