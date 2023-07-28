class Solution {
public:
    int longestIdealString(string s, int k) {
        
        int n = s.size();
        vector<int> last(26, -1);
        int i = 0, j = 0;
        int res = 0;
        while (j < n) {
            last[s[j] - 'a'] = j;
            while (i < j && j - i - *max_element(last.begin(), last.end()) > k) {
                last[s[i] - 'a'] = -1;
                i++;
            }
            res = max(res, j - i + 1);
            j++;
        }
        return res;
    }
};