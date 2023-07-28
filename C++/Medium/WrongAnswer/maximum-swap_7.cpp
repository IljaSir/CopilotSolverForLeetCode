class Solution {
public:
    int maximumSwap(int num) {
        
        string s = to_string(num);
        int n = s.size();
        int idx = n - 1;
        for (int i = n - 2; i >= 0; --i) {
            if (s[i] < s[idx]) {
                int j = i + 1;
                while (j < n && s[j] != s[i]) {
                    ++j;
                }
                swap(s[i], s[j]);
                break;
            } else if (s[i] > s[idx]) {
                idx = i;
            }
        }
        return stoi(s);
    }
};