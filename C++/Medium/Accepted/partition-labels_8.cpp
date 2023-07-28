class Solution {
public:
    vector<int> partitionLabels(string s) {
        
        vector<int> ret;
        int len = s.length();
        if (len == 0) {
            return ret;
        }
        int start = 0, end = 0;
        for (int i = 0; i < len; ++i) {
            int last = s.find_last_of(s[i]);
            if (last > end) {
                end = last;
            }
            if (i == end) {
                ret.push_back(end - start + 1);
                start = end + 1;
            }
        }
        return ret;
    }
};