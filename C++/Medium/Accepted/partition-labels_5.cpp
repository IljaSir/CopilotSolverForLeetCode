class Solution {
public:
    vector<int> partitionLabels(string s) {
        
        vector<int> result;
        unordered_map<char, int> last_index;
        for (int i = 0; i < s.size(); ++i) {
            last_index[s[i]] = i;
        }
        int start = 0;
        int end = 0;
        for (int i = 0; i < s.size(); ++i) {
            end = max(end, last_index[s[i]]);
            if (i == end) {
                result.push_back(end - start + 1);
                start = end + 1;
            }
        }
        return result;
    }
};