class Solution {
public:
    vector<string> letterCombinations(string digits) {
        
        vector<string> result;
        if (digits.empty()) return result;
        vector<string> phone = {"abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
        result.push_back("");
        for (char d : digits) {
            int x = d - '2';
            if (x < 0 || x > 7) continue;
            vector<string> temp;
            for (char c : phone[x]) {
                for (string s : result) {
                    temp.push_back(s + c);
                }
            }
            result = temp;
        }
        return result;
    }
};