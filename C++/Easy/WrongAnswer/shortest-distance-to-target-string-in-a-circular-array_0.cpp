class Solution {
public:
    int closetTarget(vector<string>& words, string target, int startIndex) {
        
        int n = words.size();
        int ans = INT_MAX;
        for (int i = 0; i < n; ++i) {
            if (words[i] == target) {
                ans = min(ans, abs(i - startIndex));
                int j = (i + 1) % n;
                int k = (i - 1 + n) % n;
                while (j != i) {
                    if (words[j] == target) {
                        ans = min(ans, abs(j - startIndex));
                        break;
                    }
                    j = (j + 1) % n;
                }
                while (k != i) {
                    if (words[k] == target) {
                        ans = min(ans, abs(k - startIndex));
                        break;
                    }
                    k = (k - 1 + n) % n;
                }
            }
        }
        return ans == INT_MAX ? -1 : ans;
    }
};