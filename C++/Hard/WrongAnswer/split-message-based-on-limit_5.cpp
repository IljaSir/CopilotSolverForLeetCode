class Solution {
public:
    vector<string> splitMessage(string message, int limit) {
        
        int n = message.size();
        vector<string> res;
        if(n <= limit){
            res.push_back(message + "<1/1>");
            return res;
        }
        int i = 0;
        int j = 0;
        int part = 1;
        while(i < n){
            j = i + limit;
            if(j >= n){
                res.push_back(message.substr(i) + "<" + to_string(part) + "/" + to_string(part) + ">");
                break;
            }
            while(j > i && message[j] != ' '){
                j--;
            }
            if(j == i){
                return {};
            }
            res.push_back(message.substr(i, j - i) + "<" + to_string(part) + "/" + to_string((n + limit - 1) / limit) + ">");
            i = j + 1;
            part++;
        }
        return res;
    }
};