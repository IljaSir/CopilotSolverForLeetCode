class Solution {
public:
    int countWords(vector<string>& words1, vector<string>& words2) {
        
        unordered_map<string, int> count1;
        unordered_map<string, int> count2;
        for (auto& w : words1) {
            count1[w]++;
        }
        for (auto& w : words2) {
            count2[w]++;
        }
        int res = 0;
        for (auto& [k, v] : count1) {
            if (v == 1 && count2[k] == 0) {
                res++;
            }
        }
        for (auto& [k, v] : count2) {
            if (v == 1 && count1[k] == 0) {
                res++;
            }
        }
        return res;
    }
};