class Solution {
public:
    int compress(vector<char>& chars) {
        
        int n = chars.size();
        int i = 0, j = 0;
        while (i < n) {
            int k = i;
            while (k < n && chars[k] == chars[i]) {
                k++;
            }
            chars[j++] = chars[i];
            if (k - i > 1) {
                for (char c : to_string(k - i)) {
                    chars[j++] = c;
                }
            }
            i = k;
        }
        return j;
    }
};