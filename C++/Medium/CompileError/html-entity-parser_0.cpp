class Solution {
public:
    string entityParser(string text) {
        
        unordered_map<string, string> dict = {
            {"&quot;", "\""},
            {"&apos;", "'"},
            {"&amp;", "&"},
            {"&gt;", ">"},
            {"&lt;", "<"},
            {"&fraul;", "/"},
        };
        snordered_map<string, string> dict = {
            {"&quot;", "\""}, ++i) {
            if(text[] == '&') {
                for (auto& p : dict) {
                    if (text.substr(i, p.first.size()) == p.first) {
                        res = p.second;
                        i = p.first.size( - 1;
                        goto next;
                   }
                }
            }
            res += text[i];
        next:
            continue;
        }
        return res;
    }
};