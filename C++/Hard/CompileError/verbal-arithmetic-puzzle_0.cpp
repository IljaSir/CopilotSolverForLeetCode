class Solution {
public:
    bool isSolvable(vector<string>& words, string result) {
        
        unordered_map<char, int> char2digit;
        unordered_set<int> used_digit;
        vector<int> digits(words.size(), 0);
        int carry = 0;
        for (int i = 0; i < result.size(); ++i) {
            if (char2digit.find(result[i]) == char2digit.end()) {
                char2digit[result[i]] = -1;
            }
        }
        for (int i = 0; i < words.size(); ++i) {
            for (int j = 0; j < words[i].size(); ++j) {
                if (char2digit.find(words[i][j]) == char2digit.end()) {
                    char2digit[words[i][j]] = -1;
                }
            }
        }
        return dfs(words, result, char2digit, used_digit, digits, 0, carry);
    }
    bool dfs(vector<string>& words, string& result,
             unordered_map<char, int>& char2digit,
             unordered_set<int>& used_digit,
             vector<int>& digits, int index, int carry) {
        if (index == char2digit.size()) {
            int sum = carry;
            for (int i = 0; i < digits.size(); ++i) {
                sum += digits[i];
            }
            return sum == 0;
        }
        auto it = char2digit.begin();
        advance(it, index);
        for (int i = 0; i <= 9; ++i) {
            if (i == 0 && (result[0] == it->first || (words.size() > 1 && words[0][0] == it->first))) {
                continue;
            }
            if (used_digit.find(i) == used_digit.end()) {
                used_digit.insert(i);
                it->second = i;
                bool valid = true;
                int sum = carry;
                for (int j = 0; j < digits.size(); ++j) {
                    if (words[j].size() > index) {
                        if (char2digit[words[j][words[j].size() - 1 - index]] == -1) {
                            valid = false;
                            break;
                        }
                        sum += char2digit[words[j][words[j].size() - 1 - index]] * pow(10, index);
                    }
                }
                if (
    }
};