class Solution {
public:
    string countOfAtoms(string formula) {
        
        int i = 0;
        auto atoms = parse(formula, i);
        string result;
        for (auto &atom : atoms) {
            result += atom.first;
            if (atom.second > 1) {
                result += to_string(atom.second);
            }
        }
        return result;
    }
};