class Solution {
public:
    vector<string> watchedVideosByFriends(vector<vector<string>>& watchedVideos, vector<vector<int>>& friends, int id, int level) {
        
        int n = friends.size();
        vector<string> res;
        unordered_map<string, int> freq;
        queue<int> q;
        unordered_set<int> visited;
        q.push(id);
        visited.insert(id);
        int l = 0;
        while (!q.empty() && l <= level) {
            int size = q.size();
            for (int i = 0; i < size; ++i) {
                int f = q.front();
                q.pop();
                for (int j = 0; j < friends[f].size(); ++j) {
                    int ff = friends[f][j];
                    if (visited.count(ff)) continue;
                    visited.insert(ff);
                    q.push(ff);
                }
            }
            ++l;
        }
        while (!q.empty()) {
            int f = q.front();
            q.pop();
            for (int i = 0; i < watchedVideos[f].size(); ++i) {
                ++freq[watchedVideos[f][i]];
            }
        }
        vector<pair<int, string>> tmp;
        for (auto& it : freq) {
            tmp.emplace_back(it.second, it.first);
        }
        sort(tmp.begin(), tmp.end());
        for (auto& it : tmp) {
            res.push_back(it.second);
        }
        return res;
    }
};