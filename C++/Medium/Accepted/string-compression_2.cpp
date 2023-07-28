class Solution {
public:
    int compress(vector<char>& chars) {
        
        int i = 0, j = 0;
        while (i < chars.size()) {
            int k = i + 1;
            while (k < chars.size() && chars[k] == chars[i]) {
                ++k;
            }
            chars[j++] = chars[i];
            if (k - i > 1) {
                string s = to_string(k - i);
                for (char c : s) {
                    chars[j++] = c;
                }
            }
            i = k;
        }
        return j;
    }
};