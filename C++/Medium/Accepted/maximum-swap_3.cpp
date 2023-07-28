class Solution {
public:
    int maximumSwap(int num) {
        
        string s = to_string(num);
        int max = num;
        for (int i = 0; i < s.size(); i++) {
            for (int j = i + 1; j < s.size(); j++) {
                swap(s[i], s[j]);
                max = max > stoi(s) ? max : stoi(s);
                swap(s[i], s[j]);
            }
        }
        return max;
    }
};