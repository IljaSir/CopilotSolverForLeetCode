class Solution {
public:
    int maxDistance(vector<int>& colors) {
        
        int maxDistance = 0;
        int lastColor = -1;
        int firstColor = -1;
        for (int i = 0; i < colors.size(); i++) {
            if (lastColor == -1) {
                lastColor = colors[i];
                firstColor = i;
            } else if (colors[i] != lastColor) {
                maxDistance = max(maxDistance, i - firstColor);
                firstColor = i;
                lastColor = colors[i];
            }
        }
        return maxDistance;
    }
};