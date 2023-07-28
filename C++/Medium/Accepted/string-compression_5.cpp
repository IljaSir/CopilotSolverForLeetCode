class Solution {
public:
    int compress(vector<char>& chars) {
        
        int i = 0;
        int j = 0;
        int k = 0;
        int n = chars.size();
        while (i < n) {
            j = i;
            while (j < n && chars[j] == chars[i]) {
                ++j;
            }
            int cnt = j - i;
            chars[k++] = chars[i];
            if (cnt > 1) {
                string s = to_string(cnt);
                for (auto c : s) {
                    chars[k++] = c;
                }
            }
            i = j;
        }
        return k;
    }
};