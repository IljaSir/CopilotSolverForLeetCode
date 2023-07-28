class Solution {
public:
    int magicalString(int n) {
        
        vector<int> s = {1, 2, 2};
        int i = 2;
        while (s.size() < n) {
            s.push_back(3 - s.back());
            if (s[i] == 2) {
                s.push_back(3 - s.back());
            }
            ++i;
        }
        return count(s.begin(), s.begin() + n, 1);
    }
};