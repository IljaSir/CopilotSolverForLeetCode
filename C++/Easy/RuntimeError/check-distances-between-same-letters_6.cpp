class Solution {
public:
    bool checkDistances(string s, vector<int>& distance) {
        
        int n = s.size();
        int i = 0;
        int j = 1;
        int k = 0;
        while (i < n) {
            if (s[i] == s[j]) {
                if (k != distance[s[i] - 'a']) {
                    return false;
                }
                k = 0;
                i = j + 1;
                j = i + 1;
            } else {
                k++;
                j++;
            }
        }
        return true;
    }
};