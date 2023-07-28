class Solution {
public:
    char repeatedCharacter(string s) {
        
        unordered_map<char, int> map;
        for (int i = 0; i < s.size(); i++) {
            if (map.find(s[i]) == map.end()) {
                map[s[i]] = i;
            } else {
                return s[i];
            }
        }
        return ' ';
    }
    char firstRepeatedCharacter(string s) {
        unordered_map<char, int> map;
        for (int i = 0; i < s.size(); i++) {
            if (map.find(s[i]) == map.end()) {
                map[s[i]] = i;
            } else {
                map[s[i]] = -1;
            }
        }
        int min = INT_MAX;
        char res = ' ';
        for (auto it = map.begin(); it != map.end(); it++) {
            if (it->second >= 0 && it->second < min) {
                res = it->first;
                min = it->second;
            }
        }
        return res;
    }
    char firstRepeatedCharacter2(string s) {
        unordered_map<char, int> map;
        char res = ' ';
        for (int i = 0; i < s.size(); i++) {
            if (map.find(s[i]) == map.end()) {
                map[s[i]] = i;
            } else {
                if (map[s[i]] >= 0) {
                    if (map[s[i]] < i) {
                        res = s[i];
                        map[s[i]] = -1;
                    } else {
                        res = s[i];
                        map[s[i]] = i;
                    }
                }
            }
        }
        return res;
    }
    char firstRepeatedCharacter3(string s) {
        unordered_map<char, int> map;
        char res = ' ';
        int min = INT_MAX;
        for (int i = 0; i < s.size(); i++) {
            if (map.find(s[i]) == map.end()) {
                map[s[i]] = i;
            } else {
                if (map[s[i]] >= 0) {
                    if (map[s[i]] < i) {
                        if (map[s[i]] < min) {
                            res = s[i];
                            min = map[s[i]];
                        }
                        map[s[i]] = -1;
                    } else {
                        if (i < min) {
                            res = s[i];
                            min
    }
};