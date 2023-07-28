class Solution {
public:
    vector<string> ambiguousCoordinates(string s) {
        
        vector<string> ret;
        int len = s.size();
        for (int i = 2; i < len - 1; ++i) {
            auto left = getNumber(s.substr(1, i - 1));
            auto right = getNumber(s.substr(i, len - i - 1));
            for (auto l : left) {
                for (auto r : right) {
                    ret.push_back("(" + l + ", " + r + ")");
                }
            }
        }
        return ret;
    }
};