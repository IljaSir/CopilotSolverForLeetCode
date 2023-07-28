class Solution {
public:
    int secondHighest(string s) {
        
        int largest = -1;
        int second = -1;
        for (auto c : s) {
            if (c >= '0' && c <= '9') {
                int n = c - '0';
                if (n > largest) {
                    second = largest;
                    largest = n;
                } else if (n > second && n != largest) {
                    second = n;
                }
            }
        }
        return second;
    }
};