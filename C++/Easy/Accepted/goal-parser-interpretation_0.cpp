class Solution {
public:
    string interpret(string command) {
        
        string result;
        for (int i = 0; i < command.size(); ++i) {
            if (command[i] == 'G') {
                result.push_back('G');
            } else if (command[i] == '(' && command[i + 1] == ')') {
                result.push_back('o');
                ++i;
            } else if (command[i] == '(' && command[i + 1] == 'a' && command[i + 2] == 'l' && command[i + 3] == ')') {
                result.append("al");
                i += 3;
            }
        }
        return result;
    }
};