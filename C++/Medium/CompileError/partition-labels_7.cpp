class Solution {
public:
    vector<int> partitionLabels(string s) {
        
        vector<int> res;
        int n = s.size();
        int start = 0;
        int end = 0;
        for (int i = 0; i < n; i++) {
            end = max(end, s.find_last_of(s[i]));
            if (i == end) {
                res.push_back(i - start + 1);
                start = i + 1;
            }
        }
        return res;
    }
};