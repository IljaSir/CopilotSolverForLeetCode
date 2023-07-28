class Solution {
public:
    int numSub(string s) {
        
        int count = 0;
        int sum = 0;
        for (auto c : s) {
            if (c == '1') {
                count++;
            } else {
                sum += count * (count + 1) / 2;
                count = 0;
            }
        }
        sum += count * (count + 1) / 2;
        return sum % 1000000007;
    }
};