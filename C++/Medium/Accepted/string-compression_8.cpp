class Solution {
public:
    int compress(vector<char>& chars) {
        
        int i = 0, j = 0, k = 0;
        int n = chars.size();
        while (i < n) {
            while (j < n && chars[j] == chars[i]) {
                ++j;
            }
            chars[k++] = chars[i];
            if (j - i > 1) {
                string s = to_string(j - i);
                for (char c : s) {
                    chars[k++] = c;
                }
            }
            i = j;
        }
        return k;
    }
};