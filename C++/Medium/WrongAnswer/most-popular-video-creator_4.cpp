class Solution {
public:
    vector<vector<string>> mostPopularCreator(vector<string>& creators, vector<string>& ids, vector<int>& views) {
        
        unordered_map<string, int> creatorViewMap;
        unordered_map<string, string> creatorMostViewedVideoMap;
        for (int i = 0; i < creators.size(); i++) {
            creatorViewMap[creators[i]] += views[i];
            if (creatorMostViewedVideoMap.find(creators[i]) == creatorMostViewedVideoMap.end()) {
                creatorMostViewedVideoMap[creators[i]] = ids[i];
            } else {
                if (views[i] > creatorViewMap[creatorMostViewedVideoMap[creators[i]]]) {
                    creatorMostViewedVideoMap[creators[i]] = ids[i];
                } else if (views[i] == creatorViewMap[creatorMostViewedVideoMap[creators[i]]]) {
                    if (ids[i] < creatorMostViewedVideoMap[creators[i]]) {
                        creatorMostViewedVideoMap[creators[i]] = ids[i];
                    }
                }
            }
        }
        int maxViewCount = 0;
        for (auto creatorView : creatorViewMap) {
            maxViewCount = max(maxViewCount, creatorView.second);
        }
        vector<vector<string>> result;
        for (auto creatorView : creatorViewMap) {
            if (creatorView.second == maxViewCount) {
                result.push_back({creatorView.first, creatorMostViewedVideoMap[creatorView.first]});
            }
        }
        return result;
    }
};