class Solution {
public:
    int maxCandies(vector<int>& status, vector<int>& candies, vector<vector<int>>& keys, vector<vector<int>>& containedBoxes, vector<int>& initialBoxes) {
        
        int n = status.size();
        vector<bool> opened(n, false);
        vector<bool> gotKey(n, false);
        for (int box : initialBoxes) {
            opened[box] = true;
        }
        int ans = 0;
        while (true) {
            vector<int> newBoxes;
            for (int box : initialBoxes) {
                if (opened[box]) {
                    ans += candies[box];
                    for (int key : keys[box]) {
                        gotKey[key] = true;
                    }
                    for (int newBox : containedBoxes[box]) {
                        newBoxes.push_back(newBox);
                    }
                }
            }
            if (newBoxes.empty()) {
                break;
            }
            initialBoxes = newBoxes;
            for (int box : initialBoxes) {
                if (gotKey[box]) {
                    opened[box] = true;
                }
            }
        }
        return ans;
    }
};