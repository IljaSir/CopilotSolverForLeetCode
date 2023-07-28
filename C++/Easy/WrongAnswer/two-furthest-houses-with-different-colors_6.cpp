class Solution {
public:
    int maxDistance(vector<int>& colors) {
        
        int n = colors.size();
        int max = 0;
        for (int i = 0; i < 100; i++) {
            int first = -1;
            int last = -1;
            for (int j = 0; j < n; j++) {
                if (colors[j] == i + 1) {
                    if (first == -1) first = j;
                    last = j;
                }
            }
            if (first != -1 && last != -1) {
                int distance = last - first;
                if (distance > max) max = distance;
            }
        }
        return max;
    }
};