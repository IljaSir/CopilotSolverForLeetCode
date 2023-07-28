class Solution {
public:
    int minDeletions(string s) {
        
        int n = s.size();
        vector<int> count(26, 0);
        for (int i = 0; i < n; ++i) {
            ++count[s[i] - 'a'];
        }
        sort(count.begin(), count.end());
        int res = 0;
        for (int i = 24; i >= 0; --i) {
            if (count[i] == 0) break;
            if (count[i] <= count[i + 1]) {
                res += count[i + 1] - count[i] + 1;
                count[i] = 0;
            }
        }
        return res;
    }
};