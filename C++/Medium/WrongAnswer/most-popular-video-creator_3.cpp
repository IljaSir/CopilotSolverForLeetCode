class Solution {
public:
    vector<vector<string>> mostPopularCreator(vector<string>& creators, vector<string>& ids, vector<int>& views) {
        
        unordered_map<string, int> viewsMap;
        unordered_map<string, string> maxViewsMap;
        for (int i = 0; i < creators.size(); i++) {
            if (viewsMap.find(creators[i]) == viewsMap.end()) {
                viewsMap[creators[i]] = views[i];
                maxViewsMap[creators[i]] = ids[i];
            } else {
                viewsMap[creators[i]] += views[i];
                if (maxViewsMap[creators[i]] > ids[i]) {
                    maxViewsMap[creators[i]] = ids[i];
                }
            }
        }
        
        int maxViews = 0;
        for (auto it = viewsMap.begin(); it != viewsMap.end(); it++) {
            maxViews = max(maxViews, it->second);
        }
        
        vector<vector<string>> result;
        for (auto it = viewsMap.begin(); it != viewsMap.end(); it++) {
            if (it->second == maxViews) {
                result.push_back({it->first, maxViewsMap[it->first]});
            }
        }
        
        return result;
    }
};