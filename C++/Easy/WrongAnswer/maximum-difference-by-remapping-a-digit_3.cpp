class Solution {
public:
    int minMaxDifference(int num) {
        
        string s = to_string(num);
        int n = s.size();
        int minv = INT_MAX, maxv = INT_MIN;
        for (int i = 0; i < 10; ++i) {
            for (int j = 0; j < 10; ++j) {
                string t = s;
                for (char& c : t) {
                    if (c - '0' == i) {
                        c = j + '0';
                    }
                }
                if (t[0] == '0') continue;
                minv = min(minv, stoi(t));
                maxv = max(maxv, stoi(t));
            }
        }
        return maxv - minv;
    }
};