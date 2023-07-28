class Solution {
public:
    string interpret(string command) {
        
        string res;
        int i = 0;
        while (i < command.size()) {
            if (command[i] == 'G') {
                res.push_back('G');
                i++;
            } else if (command[i] == '(') {
                if (command[i+1] == ')') {
                    res.push_back('o');
                    i += 2;
                } else {
                    res.push_back('a');
                    res.push_back('l');
                    i += 4;
                }
            }
        }
        return res;
    }
};