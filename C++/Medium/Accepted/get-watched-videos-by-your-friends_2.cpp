class Solution {
public:
    vector<string> watchedVideosByFriends(vector<vector<string>>& watchedVideos, vector<vector<int>>& friends, int id, int level) {
        
        vector<vector<int>> graph(friends.size());
        for (int i = 0; i < friends.size(); ++i)
            for (int j = 0; j < friends[i].size(); ++j)
                graph[i].push_back(friends[i][j]);
        vector<int> dist(friends.size(), -1);
        queue<int> q;
        q.push(id);
        dist[id] = 0;
        while (!q.empty()) {
            int cur = q.front();
            q.pop();
            for (int i = 0; i < graph[cur].size(); ++i) {
                int next = graph[cur][i];
                if (dist[next] == -1) {
                    dist[next] = dist[cur] + 1;
                    q.push(next);
                }
            }
        }
        unordered_map<string, int> freq;
        for (int i = 0; i < dist.size(); ++i)
            if (dist[i] == level)
                for (int j = 0; j < watchedVideos[i].size(); ++j)
                    ++freq[watchedVideos[i][j]];
        vector<pair<int, string>> ans;
        for (auto& p : freq)
            ans.push_back({p.second, p.first});
        sort(ans.begin(), ans.end());
        vector<string> res;
        for (auto& p : ans)
            res.push_back(p.second);
        return res;
    }
};