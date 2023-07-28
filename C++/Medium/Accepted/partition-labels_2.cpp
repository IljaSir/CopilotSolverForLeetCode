class Solution {
public:
    vector<int> partitionLabels(string s) {
        
        vector<int> last(26);
        for (int i = 0; i < s.size(); i++)
            last[s[i] - 'a'] = i;
        int start = 0, end = 0;
        vector<int> ans;
        for (int i = 0; i < s.size(); i++) {
            end = max(end, last[s[i] - 'a']);
            if (i == end) {
                ans.push_back(end - start + 1);
                start = end + 1;
            }
        }
        return ans;
    }
};