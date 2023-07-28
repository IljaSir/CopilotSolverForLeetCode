class Solution {
public:
    bool checkDistances(string s, vector<int>& distance) {
        
        int n = s.size();
        int i = 0;
        while (i < n) {
            int j = i + 1;
            while (j < n && s[j] != s[i]) ++j;
            if (j - i - 1 != distance[s[i] - 'a']) return false;
            i = j;
        }
        return true;
    }
};