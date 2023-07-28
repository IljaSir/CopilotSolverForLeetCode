class Solution {
public:
    int maxDistance(vector<int>& colors) {
        
        int n = colors.size();
        int maxDistance = 0;
        for (int i = 0; i < n; i++) {
            int first = -1;
            int last = -1;
            for (int j = 0; j < n; j++) {
                if (colors[j] == colors[i]) {
                    continue;
                }
                if (first == -1) {
                    first = j;
                }
                last = j;
            }
            if (first != -1) {
                maxDistance = max(maxDistance, last - first);
            }
        }
        return maxDistance;
    }
};