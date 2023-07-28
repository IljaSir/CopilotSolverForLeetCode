class Solution {
public:
    vector<int> numSmallerByFrequency(vector<string>& queries, vector<string>& words) {
        
        vector<int> ans;
        vector<int> freqWords;
        for (auto word: words) {
            freqWords.push_back(f(word));
        }
        sort(freqWords.begin(), freqWords.end());
        for (auto query: queries) {
            int freqQuery = f(query);
            int count = 0;
            for (auto freqWord: freqWords) {
                if (freqQuery < freqWord) {
                    count++;
                }
            }
            ans.push_back(count);
        }
        return ans;
    }
    
    int f(string& s) {
        int freq = 0;
        char ch = 'z';
        for (auto c: s) {
            if (c < ch) {
                ch = c;
                freq = 1;
            } else if (c == ch) {
                freq++;
            }
        }
        return freq;
    }
};