class Solution {
public:
    string maximumTime(string time) {
        
        string s = "";
        for(int i = 0; i < time.size(); i++){
            if(time[i] == '?'){
                if(i == 0){
                    if(time[i+1] == '?' || time[i+1] <= '3')
                        s += '2';
                    else
                        s += '1';
                }
                else if(i == 1){
                    if(time[i-1] == '?' || time[i-1] == '2')
                        s += '3';
                    else
                        s += '9';
                }
                else if(i == 3)
                    s += '5';
                else
                    s += '9';
            }
            else
                s += time[i];
        }
        return s;
    }
};