class Solution {
public:
    int balancedString(string s) {
        
        int n = s.size();
        if (n % 4 == 0) {
            int m = n / 4;
            unordered_map<char, int> map;
            for (auto c : s) {
                map[c]++;
            }
            int i = 0, j = 0, minLen = n;
            while (j < n) {
                map[s[j]]--;
                while (i <= j && map['Q'] <= m && map['W'] <= m && map['E'] <= m && map['R'] <= m) {
                    minLen = min(minLen, j - i + 1);
                    map[s[i]]++;
                    i++;
                }
                j++;
            }
            return minLen;
        }
        return 0;
    }
};