class Solution {
public:
    vector<string> watchedVideosByFriends(vector<vector<string>>& watchedVideos, vector<vector<int>>& friends, int id, int level) {
        
        vector<string> res;
        unordered_map<string, int> freq;
        unordered_set<int> visited;
        queue<int> q;
        q.push(id);
        visited.insert(id);
        int curLevel = 0;
        while(!q.empty() && curLevel <= level){
            int size = q.size();
            for(int i = 0; i < size; i++){
                int curId = q.front();
                q.pop();
                if(curLevel == level){
                    for(string video: watchedVideos[curId]){
                        freq[video]++;
                    }
                }
                for(int j = 0; j < friends[curId].size(); j++){
                    if(visited.count(friends[curId][j]) == 0){
                        visited.insert(friends[curId][j]);
                        q.push(friends[curId][j]);
                    }
                }
            }
            curLevel++;
        }
        vector<pair<int, string>> tmp;
        for(auto it = freq.begin(); it != freq.end(); it++){
            tmp.push_back(make_pair(it->second, it->first));
        }
        sort(tmp.begin(), tmp.end());
        for(int i = 0; i < tmp.size(); i++){
            res.push_back(tmp[i].second);
        }
        return res;
    }
};