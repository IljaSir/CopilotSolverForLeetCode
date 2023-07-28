class Solution {
public:
    string reverseStr(string s, int k) {
        
        for (int i = 0; i < s.size(); i += 2 * k) {
            int j = i;
            int l = min(i + k - 1, (int)s.size() - 1);
            while (j < l) {
                swap(s[j++], s[l--]);
            }
        }
        return s;
    }
};