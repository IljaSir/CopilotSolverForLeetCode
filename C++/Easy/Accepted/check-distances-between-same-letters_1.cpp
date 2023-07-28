class Solution {
public:
    bool checkDistances(string s, vector<int>& distance) {
        
        int n = s.size();
        int last[26];
        for (int i = 0; i < 26; i++) last[i] = -1;
        for (int i = 0; i < n; i++) {
            int c = s[i] - 'a';
            if (last[c] == -1) last[c] = i;
            else {
                if (i - last[c] - 1 != distance[c]) return false;
                last[c] = i;
            }
        }
        return true;
    }
};