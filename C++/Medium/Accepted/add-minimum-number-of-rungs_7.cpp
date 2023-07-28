class Solution {
public:
    int addRungs(vector<int>& rungs, int dist) {
        
        int result = 0;
        int currentHeight = 0;
        for (int i = 0; i < rungs.size(); i++) {
            int gap = rungs[i] - currentHeight;
            if (gap > dist) {
                result += (gap - 1) / dist;
            }
            currentHeight = rungs[i];
        }
        return result;
    }
};