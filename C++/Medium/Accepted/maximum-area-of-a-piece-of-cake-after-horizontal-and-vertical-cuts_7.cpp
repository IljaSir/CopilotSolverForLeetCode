class Solution {
public:
    int maxArea(int h, int w, vector<int>& horizontalCuts, vector<int>& verticalCuts) {
        
        int mod = 1e9 + 7;
        sort(horizontalCuts.begin(), horizontalCuts.end());
        sort(verticalCuts.begin(), verticalCuts.end());
        int maxH = max(horizontalCuts[0], h - horizontalCuts[horizontalCuts.size() - 1]);
        int maxV = max(verticalCuts[0], w - verticalCuts[verticalCuts.size() - 1]);
        for (int i = 1; i < horizontalCuts.size(); ++i) {
            maxH = max(maxH, horizontalCuts[i] - horizontalCuts[i - 1]);
        }
        for (int i = 1; i < verticalCuts.size(); ++i) {
            maxV = max(maxV, verticalCuts[i] - verticalCuts[i - 1]);
        }
        return (long)maxH * maxV % mod;
    }
};