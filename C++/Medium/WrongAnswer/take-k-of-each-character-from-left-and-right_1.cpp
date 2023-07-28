class Solution {
public:
    int takeCharacters(string s, int k) {
        
        int n = s.length();
        int a = 0, b = 0, c = 0;
        for (int i = 0; i < k; ++i) {
            if (s[i] == 'a') ++a;
            else if (s[i] == 'b') ++b;
            else ++c;
        }
        int result = a + b + c;
        for (int i = k; i < n; ++i) {
            if (s[i] == 'a') ++a;
            else if (s[i] == 'b') ++b;
            else ++c;
            if (s[i - k] == 'a') --a;
            else if (s[i - k] == 'b') --b;
            else --c;
            result = min(result, a + b + c);
        }
        return result;
    }
};