class Solution {
public:
    int maxArea(int h, int w, vector<int>& horizontalCuts, vector<int>& verticalCuts) {
        
        sort(horizontalCuts.begin(), horizontalCuts.end());
        sort(verticalCuts.begin(), verticalCuts.end());
        int hmax = max(horizontalCuts[0], h - horizontalCuts.back());
        int wmax = max(verticalCuts[0], w - verticalCuts.back());
        for (int i = 1; i < horizontalCuts.size(); ++i) {
            hmax = max(hmax, horizontalCuts[i] - horizontalCuts[i - 1]);
        }
        for (int i = 1; i < verticalCuts.size(); ++i) {
            wmax = max(wmax, verticalCuts[i] - verticalCuts[i - 1]);
        }
        return (long long)hmax * wmax % 1000000007;
    }
};