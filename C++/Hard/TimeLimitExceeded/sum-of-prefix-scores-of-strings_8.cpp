class Solution {
public:
    vector<int> sumPrefixScores(vector<string>& words) {
        
        vector<int> ans;
        ans.reserve(words.size());
        unordered_map<string, int> prefix2cnt;
        for (auto& w : words) {
            string pre;
            for (auto c : w) {
                pre.push_back(c);
                prefix2cnt[pre]++;
            }
        }
        for (auto& w : words) {
            string pre;
            int sum = 0;
            for (auto c : w) {
                pre.push_back(c);
                sum += prefix2cnt[pre];
            }
            ans.push_back(sum);
        }
        return ans;
    }
};