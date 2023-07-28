class Solution {
public:
    string smallestSubsequence(string s, int k, char letter, int repetition) {
        
        int n = s.size();
        int cnt = 0;
        for (int i = 0; i < n; i++) {
            if (s[i] == letter) {
                pos.push_back(i);
            }
        }
        string ans;
        int m = pos.size();
        int i = 0;
        while (k > 0) {
            int j = pos[i];
            vector<int> pos;
            for (int l = j; l < n; l++) {
                if (s[l] == letter) {
                    cnt++;
                }
                if (cnt >= repetition && l - j + 1 <= k) {
                    ans += s[l];
                    k--;
                    i = lower_bound(pos.begin(), pos.end(), l + 1) - pos.begin();
                    break;
                }
            }
        }
        return ans;
    }
};