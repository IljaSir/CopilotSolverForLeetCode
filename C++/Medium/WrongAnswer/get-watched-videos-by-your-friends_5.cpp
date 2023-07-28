class Solution {
public:
    vector<string> watchedVideosByFriends(vector<vector<string>>& watchedVideos, vector<vector<int>>& friends, int id, int level) {
        
        int N = friends.size();
        vector<int> visited(N, 0);
        queue<int> q;
        q.push(id);
        visited[id] = 1;
        while (!q.empty()) {
            int sz = q.size();
            while (sz--) {
                int cur = q.front();
                q.pop();
                if (level == 0) {
                    vector<string> res;
                    unordered_map<string, int> freq;
                    for (auto &video: watchedVideos[cur]) {
                        freq[video]++;
                    }
                    for (auto &p: freq) {
                        res.push_back(p.first);
                    }
                    sort(res.begin(), res.end(), [&](const string &a, const string &b) {
                        if (freq[a] == freq[b]) {
                            return a < b;
                        }
                        return freq[a] < freq[b];
                    });
                    return res;
                }
                for (auto &f: friends[cur]) {
                    if (visited[f]) {
                        continue;
                    }
                    visited[f] = 1;
                    q.push(f);
                }
            }
            level--;
        }
        return {};
    }
};