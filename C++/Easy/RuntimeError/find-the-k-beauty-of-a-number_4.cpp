class Solution {
public:
    int divisorSubstrings(int num, int k) {
        
        int count = 0;
        string str = to_string(num);
        for (int i = 0; i + k <= str.length(); ++i) {
            string sub = str.substr(i, k);
            if (sub[0] == '0' && sub.length() > 1) {
                continue;
            }
            int n = stoi(sub);
            if (num % n == 0) {
                ++count;
            }
        }
        return count;
    }
};