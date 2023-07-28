class Solution {
public:
    int getLucky(string s, int k) {
        
        int n = s.size();
        int sum = 0;
        for (int i = 0; i < n; i++){
            int c = s[i] - 'a' + 1;
            sum += c / 10;
            sum += c % 10;
        }
        while (--k){
            int temp = sum;
            sum = 0;
            while (temp){
                sum += temp % 10;
                temp /= 10;
            }
        }
        return sum;
    }
};