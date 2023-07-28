class Solution {
public:
    vector<int> exclusiveTime(int n, vector<string>& logs) {
        
        vector<int> res(n, 0);
        stack<int> stk;
        int pre = 0;
        for(auto& log: logs){
            int pos = log.find(':');
            int id = stoi(log.substr(0, pos));
            int pos2 = log.find(':', pos + 1);
            string status = log.substr(pos + 1, pos2 - pos - 1);
            int cur = stoi(log.substr(pos2 + 1));
            if(!stk.empty()){
                res[stk.top()] += cur - pre;
            }
            pre = cur;
            if(status == "start"){
                stk.push(id);
            }else{
                res[stk.top()]++;
                stk.pop();
                pre++;
            }
        }
        return res;
    }
};