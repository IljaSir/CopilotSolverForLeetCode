class Solution {
public:
    int maxDistance(vector<int>& colors) {
        
        int n = colors.size();
        unordered_map<int, int> colorToLastPos;
        int ans = 0;
        for (int i = 0; i < n; i++) {
            if (colorToLastPos.find(colors[i]) == colorToLastPos.end()) {
                colorToLastPos[colors[i]] = i;
            } else {
                ans = max(ans, i - colorToLastPos[colors[i]]);
                colorToLastPos[colors[i]] = i;
            }
        }
        return ans;
    }
};