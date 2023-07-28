class Solution {
public:
    int closetTarget(vector<string>& words, string target, int startIndex) {
        
        int n = words.size();
        int res = INT_MAX;
        for (int i = 0; i < n; i++) {
            if (words[i] == target) {
                int left = startIndex, right = startIndex;
                int leftDist = 0, rightDist = 0;
                while (left != i) {
                    left = (left + n - 1) % n;
                    leftDist++;
                }
                while (right != i) {
                    right = (right + 1) % n;
                    rightDist++;
                }
                res = min(res, min(leftDist, rightDist));
            }
        }
        return res == INT_MAX ? -1 : res;
    }
};