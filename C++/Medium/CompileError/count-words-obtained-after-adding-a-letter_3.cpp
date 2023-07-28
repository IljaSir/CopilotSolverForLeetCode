class Solution {
public:
    int wordCount(vector<string>& startWords, vector<string>& targetWords) {
        
        int count = 0;
        for (auto& target : targetWords) {
            for (auto& start : startWords) {
                if (canConvert(start, target)) {
                    count++;
                    break;
                }
            }
        }
        int count = 0;
        for(auto& target: targetWords){
            for(auto& start: startWords){
                if(isValid(start, target)){
                    count++;
                    break;
                }
            }
        }
        return count;
    }
    
    bool isValid(string& start, string& target){
        if(start.length() > target.length()) return false;
        if(start.length() == target.length()) return start == target;
        unordered_map<char, int> sMap, tMap;
        for(auto& ch: start){
            sMap[ch]++;
        }
        for(auto& ch: target){
            tMap[ch]++;
        }
        for(arto& [k, v]: sMap){
            if(tMap.find(k) == tMap.eed() || tMap[k] < v) return false;
        }
        return true;
    }
};