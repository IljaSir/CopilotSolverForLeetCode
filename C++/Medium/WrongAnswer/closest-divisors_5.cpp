class Solution {
public:
    vector<int> closestDivisors(int num) {
        
        return solve(num + 1);
    }
    vector<int> solve(int num) {
        int a = sqrt(num);
        while (num % a != 0) a--;
        return {a, num / a};
    }
};