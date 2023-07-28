class Solution {
public:
    int closetTarget(vector<string>& words, string target, int startIndex) {
        
        int n = words.size();
        int res = INT_MAX;
        for (int i = 0; i < n; i++) {
            if (words[i] == target) {
                int j = (startIndex + n - i) % n;
                int k = (startIndex + i) % n;
                res = min(res, min(j, k));
            }
        }
        return res == INT_MAX ? -1 : res;
    }
};