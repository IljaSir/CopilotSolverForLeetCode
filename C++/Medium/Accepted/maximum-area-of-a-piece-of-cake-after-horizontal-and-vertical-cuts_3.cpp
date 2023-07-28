class Solution {
public:
    int maxArea(int h, int w, vector<int>& horizontalCuts, vector<int>& verticalCuts) {
        
        sort(horizontalCuts.begin(), horizontalCuts.end());
        sort(verticalCuts.begin(), verticalCuts.end());
        
        int maxH = max(horizontalCuts[0], h - horizontalCuts[horizontalCuts.size() - 1]);
        for (int i = 0; i < horizontalCuts.size() - 1; i++) {
            maxH = max(maxH, horizontalCuts[i + 1] - horizontalCuts[i]);
        }
        
        int maxV = max(verticalCuts[0], w - verticalCuts[verticalCuts.size() - 1]);
        for (int i = 0; i < verticalCuts.size() - 1; i++) {
            maxV = max(maxV, verticalCuts[i + 1] - verticalCuts[i]);
        }
        
        return (long long)maxH * maxV % 1000000007;
    }
};