class Solution {
public:
    vector<string> sortPeople(vector<string>& names, vector<int>& heights) {
        
        vector<string> result;
        int n = names.size();
        if (n == 0) {
            return result;
        }
        // sort the heights
        vector<int> sortedHeights = heights;
        sort(sortedHeights.begin(), sortedHeights.end());
        // map the sorted heights to the names
        map<int, string> heightNameMap;
        for (int i = 0; i < n; i++) {
            heightNameMap[sortedHeights[i]] = names[i];
        }
        // add the names to the result
        for (int i = n - 1; i >= 0; i--) {
            result.push_back(heightNameMap[heights[i]]);
        }
        return result;
    }
};