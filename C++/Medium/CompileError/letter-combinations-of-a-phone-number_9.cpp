class Solution {
public:
    vector<string> letterCombinations(string digits) {
        
        vector<string> result;
        if(digits.size() == 0){
            return result;
        }
        int digit = digits[0] - '0';
        vector<string> next = letterCombinations(digits.substr(1));
        if(digit == 2){
            if(next.size() == 0){
                return {"a", "b", "c"};
            }
            for(int i = 0; i < next.size(); i++){
                result.push_back("a" + next[i]);
                result.push_back("b" + next[i]);
                result.push_back("c" + next[i]);
            }
        }else if(digit == 3){
            if(next.size() == 0){
                return {"d", "e", "f"};
            }
            for(int i = 0; i < next.size(); i++){
                result.push_back("d" + next[i]);
                result.push_back("e" + next[i]);
                result.push_back("f" + next[i]);
            }
        }else if(digit == 4){
            if(next.size() == 0){
                return {"g", "h", "i"};
            }
            for(int i = 0; i < next.size(); i++){
                result.push_back("g" + next[i]);
                result.push_back("h" + next[i]);
                result.push_back("i" + next[i]);
            }
        }else if(digit == 5){
            if(next.size() == 0){
                return {"j", "k", "l"};
            }
            for(int i = 0; i < next.size(); i++){
                result.push_back("j" + next[i]);
                result.push_back("k" + next[i]);
                result.push_back("l" + next[i]);
            }
        }else if(digit == 6){
            if(next.size() == 0){
                return {"m", "n", "o"};
            }
            for(int i = 0; i < next.size(); i++){
                result.push_back("m" + next[i]);
                result.push_back("n" + next[i]);
                result.push_back("o" + next[i]);
            }
        }else if(digit == 7){
            if(next.size() == 0){
                return {"p", "q", "r", "s"};
            }
            for(int i = 0; i
    }
};