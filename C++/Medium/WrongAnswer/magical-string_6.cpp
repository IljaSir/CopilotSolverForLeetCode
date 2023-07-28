class Solution {
public:
    int magicalString(int n) {
        
        if (n == 0) {
            return 0;
        }
        if (n <= 3) {
            return 1;
        }
        int ans = 1;
        string s = "122";
        int i = 2;
        while (s.size() < n) {
            if (s[i] == '1') {
                s.push_back(s.back() == '1' ? '2' : '1');
                if (s.back() == '1') {
                    ans++;
                }
            } else {
                s.push_back(s.back() == '1' ? '2' : '1');
                s.push_back(s.back() == '1' ? '2' : '1');
                if (s.back() == '1') {
                    ans++;
                }
            }
            i++;
        }
        if (s.back() == '1' && s.size() > n) {
            ans--;
        }
        return ans;
    }
};