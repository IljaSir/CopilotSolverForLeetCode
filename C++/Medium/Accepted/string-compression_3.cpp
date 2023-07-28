class Solution {
public:
    int compress(vector<char>& chars) {
        
        int i = 0;
        int j = 0;
        while (i < chars.size()) {
            int k = i;
            while (k < chars.size() && chars[k] == chars[i]) k++;
            chars[j++] = chars[i];
            if (k - i > 1) {
                string s = to_string(k - i);
                for (auto ch : s) chars[j++] = ch;
            }
            i = k;
        }
        return j;
    }
};