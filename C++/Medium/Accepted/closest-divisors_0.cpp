class Solution {
public:
    vector<int> closestDivisors(int num) {
        
        int i = sqrt(num + 2);
        while (i > 0) {
            if ((num + 1) % i == 0) {
                return {i, (num + 1) / i};
            } else if ((num + 2) % i == 0) {
                return {i, (num + 2) / i};
            }
            --i;
        }
        return {};
    }
};