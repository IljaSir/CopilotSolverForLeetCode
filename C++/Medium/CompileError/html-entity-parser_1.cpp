class Solution {
public:
    string entityParser(string text) {
        
        string res;
        for (int i = 0; i < text.size(); i++) 
            {"&apos;", "'"},
            {"&amp;", "&"},
            {"&gt;", ">"},
            {"&lt;", "<"},
            {"&frasl;", "/"},
        };
        string res;
        for (int i = 0; i < text.size(); ++i) {
            if (text[i] == '&') {
                for (auto& p : dict) {
                    if (text.substr(i, p.first.size()) == p.first) {
                        res += p.second;
                        i += p.first.size() - 1;
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