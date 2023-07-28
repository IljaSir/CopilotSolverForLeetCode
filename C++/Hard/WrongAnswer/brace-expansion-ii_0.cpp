class Solution {
public:
    vector<string> braceExpansionII(string expression) {
        
        vector<string> res;
        vector<string> stack;
        stack.push_back("");
        for (int i = 0; i < expression.size(); i++) {
            if (expression[i] == '{') {
                vector<string> temp;
                stack.push_back("{");
                i++;
                while (expression[i] != '}') {
                    string str = "";
                    while (i < expression.size() && expression[i] != ',' && expression[i] != '}') {
                        str += expression[i];
                        i++;
                    }
                    temp.push_back(str);
                    if (expression[i] == ',') {
                        i++;
                    }
                }
                sort(temp.begin(), temp.end());
                vector<string> new_stack;
                for (int k = 0; k < stack.size(); k++) {
                    for (int j = 0; j < temp.size(); j++) {
                        new_stack.push_back(stack[k] + temp[j]);
                    }
                }
                stack = new_stack;
            } else if (expression[i] == ',') {
                continue;
            } else {
                vector<string> new_stack;
                for (int k = 0; k < stack.size(); k++) {
                    new_stack.push_back(stack[k] + expression[i]);
                }
                stack = new_stack;
            }
        }
        for (int i = 0; i < stack.size(); i++) {
            res.push_back(stack[i]);
        }
        sort(res.begin(), res.end());
        return res;
    }
};