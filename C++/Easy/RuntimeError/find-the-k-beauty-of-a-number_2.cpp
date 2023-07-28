class Solution {
public:
    int divisorSubstrings(int num, int k) {
        
        string s = to_string(num);
        int res = 0;
        for (int i = 0; i + k <= s.size(); ++i) {
            string t = s.substr(i, k);
            int n = stoi(t);
            if (num % n == 0) ++res;
        }
        return res;
    }
};