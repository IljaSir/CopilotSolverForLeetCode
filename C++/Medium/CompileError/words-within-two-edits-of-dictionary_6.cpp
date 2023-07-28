class Solution {
public:
    vector<string> twoEditWords(vector<string>& queries, vector<string>& dictionary) {
        
        vector<string> res;
        for(string& q : queries) {
            for(string& d : dictionary) {
                if(q.size() == d.size()) {
                    if(oneEdit(q, d)) {
                        res.push_back(q);
                        break;
                    }
                } else if(q.size() + 1 == d.size()) {
                    if(oneInsert(q, d)) {
                        res.push_back(q);
                        break;
                    }
                } else if(q.size() - 1 == d.size()) {
                    if(oneInsert(d, q)) {
                        res.push_back(q);
                        break;
                    }
                }
            }
        }
        return res;
    }
};