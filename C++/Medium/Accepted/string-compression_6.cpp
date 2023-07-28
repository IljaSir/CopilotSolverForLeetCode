class Solution {
public:
    int compress(vector<char>& chars) {
        
        int len = 1;
        int count = 1;
        char last = chars[0];
        for (int i = 1; i < chars.size(); i++) {
            if (chars[i] == last) {
                count++;
            } else {
                if (count > 1) {
                    string s = to_string(count);
                    for (int j = 0; j < s.size(); j++) {
                        chars[len++] = s[j];
                    }
                }
                chars[len++] = chars[i];
                last = chars[i];
                count = 1;
            }
        }
        if (count > 1) {
            string s = to_string(count);
            for (int j = 0; j < s.size(); j++) {
                chars[len++] = s[j];
            }
        }
        return len;
    }
};