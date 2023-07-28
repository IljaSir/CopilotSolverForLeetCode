class Solution {
public:
    int maxDistance(vector<int>& colors) {
        
        int n = colors.size();
        vector<int> left(n, -1);
        vector<int> right(n, -1);
        for (int i = 0; i < n; ++i) {
            int c = colors[i];
            if (left[c] == -1) {
                left[c] = i;
            }
            right[c] = i;
        }
        int maxDist = 0;
        int minLeft = left[colors[0]];
        int maxRight = right[colors[0]];
        for (int i = 1; i < n; ++i) {
            int c = colors[i];
            if (c == colors[0]) {
                continue;
            }
            maxDist = max(maxDist, max(i - minLeft, maxRight - i));
            minLeft = min(minLeft, left[c]);
            maxRight = max(maxRight, right[c]);
        }
        return maxDist;
    }
};