class Solution {
public:
    int divisorSubstrings(int num, int k) {
        
        string s = to_string(num);
        int ans = 0;
        for (int i = 0; i + k <= s.size(); ++i) {
            int j = i + k;
            int x = stoi(s.substr(i, j - i));
            if (x % num == 0) {
                ++ans;
            }
        }
        return ans;
    }
};