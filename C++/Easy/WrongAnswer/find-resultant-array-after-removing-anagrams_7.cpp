class Solution {
public:
    vector<string> removeAnagrams(vector<string>& words) {
        
        unordered_map<string, int> m;
        vector<string> result;
        for (auto& word : words) {
            string sorted_word = word;
            sort(sorted_word.begin(), sorted_word.end());
            if (m.find(sorted_word) == m.end()) {
                result.push_back(word);
                m[sorted_word] = result.size() - 1;
            }
            else {
                result[m[sorted_word]] = "";
            }
        }
        return result;
    }
};