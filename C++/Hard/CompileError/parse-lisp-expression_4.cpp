class Solution {
public:
    int evaluate(string expression) {
        
        return evaluate(expression, 0, expression.size());
    }
};