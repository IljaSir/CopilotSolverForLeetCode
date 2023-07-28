class Solution {
public:
    int balancedString(string s) {
        
        int n = s.size();
        int res = n;
        unordered_map<char, int> count;
        for (char c : s) {
            count[c]++;
        }
        int i = 0;
        for (int j = 0; j < n; j++) {
            count[s[j]]--;
            while (i < n && count['Q'] <= n/4 && count['W'] <= n/4 && count['E'] <= n/4 && count['R'] <= n/4) {
                res = min(res, j - i + 1);
                count[s[i]]++;
                i++;
            }
        }
        return res;
    }
};