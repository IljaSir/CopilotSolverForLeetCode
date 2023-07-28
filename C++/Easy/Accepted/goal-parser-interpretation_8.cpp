class Solution {
public:
    string interpret(string command) {
        
        string result;
        int i = 0;
        while (i < command.length()) {
            if (command[i] == 'G') {
                result.push_back('G');
                i++;
            } else if (command[i] == '(') {
                if (command[i+1] == ')') {
                    result.push_back('o');
                    i += 2;
                } else {
                    result.append("al");
                    i += 4;
                }
            }
        }
        return result;
    }
};