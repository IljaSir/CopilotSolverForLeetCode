class Solution {
public:
    string validIPAddress(string queryIP) {
        
        int n = queryIP.size();
        int cnt = 0;
        for(int i = 0; i < n; i++){
            if(queryIP[i] == '.'){
                cnt++;
            }
        }
        if(cnt == 3){
            return validIPv4(queryIP) ? "IPv4" : "Neither";
        }
        cnt = 0;
        for(int i = 0; i < n; i++){
            if(queryIP[i] == ':'){
                cnt++;
            }
        }
        if(cnt == 7){
            return validIPv6(queryIP) ? "IPv6" : "Neither";
        }
        return "Neither";
    }
    bool validIPv4(string queryIP){
        int n = queryIP.size();
        int cnt = 0;
        string temp;
        for(int i = 0; i < n; i++){
            if(queryIP[i] == '.'){
                if(temp.size() == 0 || temp.size() > 3) return false;
                if(temp.size() > 1 && temp[0] == '0') return false;
                int num = 0;
                for(int j = 0; j < temp.size(); j++){
                    if(temp[j] >= '0' && temp[j] <= '9'){
                        num = num*10 + (temp[j] - '0');
                    }else{
                        return false;
                    }
                }
                if(num > 255) return false;
                temp = "";
            }else{
                temp += queryIP[i];
            }
        }
        if(temp.size() == 0 || temp.size() > 3) return false;
        if(temp.size() > 1 && temp[0] == '0') return false;
        int num = 0;
        for(int j = 0; j < temp.size(); j++){
            if(temp[j] >= '0' && temp[j] <= '9'){
                num = num*10 + (temp[j] - '0');
            }else{
                return false;
            }
        }
        if(num > 255) return false;
        return true;
    }
};