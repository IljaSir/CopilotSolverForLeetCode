class Solution {
public:
    int numSub(string s) {
        
        int count = 0;
        int sum = 0;
        int n = s.size();
        for (int i = 0; i < n; ++i) {
            if (s[i] == '1') {
                count++;
            } else {
                sum += (count * (count + 1)) / 2;
                sum %= 1000000007;
                count = 0;
            }
        }
        sum += (count * (count + 1)) / 2;
        sum %= 1000000007;
        return sum;
    }
};