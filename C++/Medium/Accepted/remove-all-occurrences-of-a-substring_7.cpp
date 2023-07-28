class Solution {
public:
    string removeOccurrences(string s, string part) {
        
        string t = s;
        while ((t.find(part) != string::npos)) {
            t.erase(t.find(part), part.length());
        }
        return t;
    }
};