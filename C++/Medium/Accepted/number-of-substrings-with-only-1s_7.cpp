class Solution {
public:
    int numSub(string s) {
        
        long long int count = 0;
        long long int sum = 0;
        for (auto c : s) {
            if (c == '1') {
                count++;
            } else {
                sum = (sum + ((count * (count + 1)) / 2)) % 1000000007;
                count = 0;
            }
        }
        sum = (sum + ((count * (count + 1)) / 2)) % 1000000007;
        return sum;
    }
};