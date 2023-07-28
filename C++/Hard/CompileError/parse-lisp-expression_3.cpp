class Solution {
public:
    int evaluate(string expression) {
        
        int result = 0;
        map<string, int> vars;
        int i = 0;
        result = evaluate(expression, i, vars);
        return result;
    }
    
    int evaluate(string expression, int &i, map<string, int> vars) {
        if (expression[i] == '(') {
            i++;
            string op = nextWord(expression, i);
            if (op == "add") {
                return evaluate(expression, i, vars) + evaluate(expression, i, vars);
            } else if (op == "mult") {
                return evaluate(expression, i, vars) * evaluate(expression, i, vars);
            } else if (op == "let") {
                while (expression[i] != ')') {
                    string var = nextWord(expression, i);
                    int val = evaluate(expression, i, vars);
                    vars[var] = val;
                }
                i++;
                return evaluate(expression, i, vars);
            }
        } else {
            return stoi(nextWord(expression, i));
        }
        return 0;
    }
};