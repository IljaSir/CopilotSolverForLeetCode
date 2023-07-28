class Solution {
public:
    int maxArea(int h, int w, vector<int>& horizontalCuts, vector<int>& verticalCuts) {
        
        long long int m = 1000000007;
        sort(horizontalCuts.begin(), horizontalCuts.end());
        sort(verticalCuts.begin(), verticalCuts.end());
        long long int hmax = max(horizontalCuts[0], h - horizontalCuts[horizontalCuts.size() - 1]);
        long long int wmax = max(verticalCuts[0], w - verticalCuts[verticalCuts.size() - 1]);
        for (int i = 1; i < horizontalCuts.size(); i++) {
            hmax = max(hmax, horizontalCuts[i] - horizontalCuts[i - 1]);
        }
        for (int i = 1; i < verticalCuts.size(); i++) {
            wmax = max(wmax, verticalCuts[i] - verticalCuts[i - 1]);
        }
        return (hmax * wmax) % m;
    }
};