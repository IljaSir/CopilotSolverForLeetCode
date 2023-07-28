class Solution {
public:
    int maxDistance(vector<int>& colors) {
        
        int n = colors.size();
        int maxDist = 0;
        unordered_map<int, int> colorToFirstIndex;
        for (int i = 0; i < n; ++i) {
            if (colorToFirstIndex.find(colors[i]) == colorToFirstIndex.end()) {
                colorToFirstIndex[colors[i]] = i;
            }
        }
        unordered_map<int, int> colorToLastIndex;
        for (int i = n-1; i >= 0; --i) {
            if (colorToLastIndex.find(colors[i]) == colorToLastIndex.end()) {
                colorToLastIndex[colors[i]] = i;
            }
        }
        for (auto& it: colorToFirstIndex) {
            maxDist = max(maxDist, colorToLastIndex[it.first] - it.second);
        }
        return maxDist;
    }
};