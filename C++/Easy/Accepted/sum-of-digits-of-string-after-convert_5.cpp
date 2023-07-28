class Solution {
public:
    int getLucky(string s, int k) {
        
        int sum = 0;
        for(auto c : s) {
            int num = c - 'a' + 1;
            while(num) {
                sum += num % 10;
                num /= 10;
            }
        }
        while(--k) {
            int num = sum;
            sum = 0;
            while(num) {
                sum += num % 10;
                num /= 10;
            }
        }
        return sum;
    }
};