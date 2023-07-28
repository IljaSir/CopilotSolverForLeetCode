class Solution {
public:
    int closetTarget(vector<string>& words, string target, int startIndex) {
        
        int n = words.size();
        int i = startIndex, j = startIndex;
        int ans = INT_MAX;
        while (i >= 0 || j < n) {
            if (i >= 0 && words[i] == target) {
                ans = min(ans, abs(i - startIndex));
            }
            if (j < n && words[j] == target) {
                ans = min(ans, abs(j - startIndex));
            }
            if (i >= 0) {
                i--;
            }
            if (j < n) {
                j++;
            }
        }
        return ans == INT_MAX ? -1 : ans;
    }
};