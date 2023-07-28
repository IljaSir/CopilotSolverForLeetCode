class Solution {
public:
    vector<int> partitionLabels(string s) {
        
        vector<int> res;
        int max = 0;
        int start = 0;
        for (int i = 0; i < s.length(); i++) {
            int last = s.rfind(s[i]);
            if (last > max) {
                max = last;
            }
            if (i == max) {
                res.push_back(max - start + 1);
                start = max + 1;
            }
        }
        return res;
    }
};