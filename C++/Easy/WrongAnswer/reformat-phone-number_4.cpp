class Solution {
public:
    string reformatNumber(string number) {
        
        string result;
        int count = 0;
        for (auto c : number) {
            if (c != '-' && c != ' ') {
                result += c;
                count++;
                if (count == 3 && result.size() < number.size() - 4) {
                    result += '-';
                    count = 0;
                }
            }
        }
        if (result.size() > 2 && result[result.size() - 2] == '-') {
            result[result.size() - 3] = result[result.size() - 1];
            result.pop_back();
        }
        return result;
    }
};