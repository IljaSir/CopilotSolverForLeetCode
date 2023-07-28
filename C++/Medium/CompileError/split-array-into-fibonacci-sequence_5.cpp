class Solution {
public:
    vector<int> splitIntoFibonacci(string num) {
        
        vector<int> res;
        backtrack(res, num, 0);
        return res;
    }
};