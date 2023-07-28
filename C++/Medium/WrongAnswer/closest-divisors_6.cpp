class Solution {
public:
    vector<int> closestDivisors(int num) {
        
        int a = num + 1;
        int b = num + 2;
        int i = sqrt(a);
        int j = sqrt(b);
        while(i > 0) {
            if(a % i == 0) {
                return {i, a / i};
            }
            if(b % j == 0) {
                return {j, b / j};
            }
            --i;
            --j;
        }
        return {0, 0};
    }
};