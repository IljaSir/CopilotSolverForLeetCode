class Solution {
public:
    int maxArea(int h, int w, vector<int>& horizontalCuts, vector<int>& verticalCuts) {
        
        sort(horizontalCuts.begin(), horizontalCuts.end());
        sort(verticalCuts.begin(), verticalCuts.end());
        int maxH = horizontalCuts[0];
        int maxW = verticalCuts[0];
        for (int i = 1; i < horizontalCuts.size(); i++) {
            maxH = max(maxH, horizontalCuts[i] - horizontalCuts[i - 1]);
        }
        maxH = max(maxH, h - horizontalCuts.back());
        for (int i = 1; i < verticalCuts.size(); i++) {
            maxW = max(maxW, verticalCuts[i] - verticalCuts[i - 1]);
        }
        maxW = max(maxW, w - verticalCuts.back());
        return (long long)maxH * maxW % 1000000007;
    }
};