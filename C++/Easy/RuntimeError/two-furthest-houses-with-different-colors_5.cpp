class Solution {
public:
    int maxDistance(vector<int>& colors) {
        
        int n = colors.size();
        int maxDist = 0;
        vector<int> first(101, INT_MAX), last(101, INT_MIN);
        for (int i = 0; i < n; ++i) {
            first[colors[i]] = min(first[colors[i]], i);
            last[colors[i]] = max(last[colors[i]], i);
        }
        for (int i = 0; i < 101; ++i) {
            for (int j = i + 1; j < 101; ++j) {
                maxDist = max(maxDist, abs(first[i] - last[j]));
                maxDist = max(maxDist, abs(first[j] - last[i]));
            }
        }
        return maxDist;
    }
};