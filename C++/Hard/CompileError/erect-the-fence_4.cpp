class Solution {
public:
    vector<vector<int>> outerTrees(vector<vector<int>>& trees) {
        
        vector<vector<int>> ans;
        int n = trees.size();
        if (n <= 3) return trees;
        vector<int> leftMost = trees[0];
        int leftMostIndex = 0;
        for (int i = 1; i < n; i++) {
            if (trees[i][0] < leftMost[0]) {
                leftMost = trees[i];
                leftMostIndex = i;
            }
        }
        ans.push_back(leftMost);
        int curIndex = leftMostIndex;
        do {
            int nextIndex = 0;
            for (int i = 1; i < n; i++) {
                if (i == curIndex) continue;
                int crossProduct = cross(trees[curIndex], trees[i], trees[nextIndex]);
                if (nextIndex == curIndex || crossProduct > 0 || (crossProduct == 0 && distance(trees[curIndex], trees[i]) > distance(trees[curIndex], trees[nextIndex]))) {
                    nextIndex = i;
                }
            }
            for (int i = 0; i < n; i++) {
                if (i == curIndex) continue;
                int crossProduct = cross(trees[curIndex], trees[i], trees[nextIndex]);
                if (crossProduct == 0) {
                    ans.push_back(trees[i]);
                }
            }
            curIndex = nextIndex;
        } while (curIndex != leftMostIndex);
        return ans;
    }
};