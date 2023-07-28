class Solution {
public:
    int getLucky(string s, int k) {
        
        string num = "";
        for (auto c : s) {
            num += to_string(c - 'a' + 1);
        }
        long long int sum = 0;
        for (int i = 0; i < k; i++) {
            sum = 0;
            for (auto c : num) {
                sum += (c - '0');
            }
            num = to_string(sum);
        }
        return sum;
    }
};