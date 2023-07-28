class Solution {
public:
    vector<string> spellchecker(vector<string>& wordlist, vector<string>& queries) {
        
        unordered_set<string> wordSet(wordlist.begin(), wordlist.end());
        unordered_map<string, string> capMap;
        unordered_map<string, string> vowelMap;
        for (string &word: wordlist) {
            string lower = toLowerCase(word);
            capMap.insert({lower, word});
            vowelMap.insert({deVowel(lower), word});
        }
        vector<string> result;
        for (string &query: queries) {
            if (wordSet.count(query)) {
                result.push_back(query);
                continue;
            }
            string lower = toLowerCase(query);
            if (capMap.count(lower)) {
                result.push_back(capMap[lower]);
                continue;
            }
            string devowel = deVowel(lower);
            if (vowelMap.count(devowel)) {
                result.push_back(vowelMap[devowel]);
                continue;
            }
            result.push_back("");
        }
        return result;
    }
};