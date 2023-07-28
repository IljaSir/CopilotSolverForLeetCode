class Solution {
public:
    int closetTarget(vector<string>& words, string target, int startIndex) {
        
        int n = words.size();
        int res = INT_MAX;
        for (int i = 0; i < n; i++) {
            if (words[i] == target) {
                res = min(res, abs(i - startIndex));
                int j = i + 1;
                while (j != i) {
                    if (j == n) {
                        j = 0;
                    }
                    if (words[j] == target) {
                        break;
                    }
                    j++;
                }
                if (j != i) {
                    res = min(res, abs(j - i) + abs(j - startIndex));
                }
                j = i - 1;
                while (j != i) {
                    if (j == -1) {
                        j = n - 1;
                    }
                    if (words[j] == target) {
                        break;
                    }
                    j--;
                }
                if (j != i) {
                    res = min(res, abs(j - i) + abs(j - startIndex));
                }
            }
        }
        return res == INT_MAX ? -1 : res;
    }
};