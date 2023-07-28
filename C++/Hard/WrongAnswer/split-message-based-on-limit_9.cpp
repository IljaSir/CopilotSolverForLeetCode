class Solution {
public:
    vector<string> splitMessage(string message, int limit) {
        
        vector<string> v;
        int len = message.length();
        int part = len/limit;
        int i = 0;
        while(i < len){
            string s = message.substr(i, limit);
            s += "<" + to_string(i/limit + 1) + "/" + to_string(part + 1) + ">";
            v.push_back(s);
            i += limit;
        }
        v[v.size()-1] = message.substr(i-limit, len - (i-limit));
        return v;
    }
};