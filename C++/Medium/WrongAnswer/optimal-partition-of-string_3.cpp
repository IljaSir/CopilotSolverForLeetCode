class Solution {
public:
    int partitionString(string s) {
        
        int n = s.size();
        vector<int> last(26, -1);
        for (int i = 0; i < n; i++) {
            last[s[i] - 'a'] = i;
        }
        int left = 0, right = 0;
        int res = 0;
        for (int i = 0; i < n; i++) {
            right = max(right, last[s[i] - 'a']);
            if (i == right) {
                res++;
                left = i + 1;
            }
        }
        return res;
    }
};