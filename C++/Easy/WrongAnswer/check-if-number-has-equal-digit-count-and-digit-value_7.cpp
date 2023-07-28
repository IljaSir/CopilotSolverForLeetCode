class Solution {
public:
    bool digitCount(string num) {
        
        unordered_map<char, int> m;
        for (auto c : num) m[c]++;
        for (int i = 0; i < num.size(); i++) {
            if (num[i] == '0' && m[num[i]] != 1) return false;
            if (num[i] != '0' && m[num[i]] != num[i] - '0') return false;
        }
        return true;
    }
};