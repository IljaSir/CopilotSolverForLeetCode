class Solution {
public:
    int dayOfYear(string date) {
        
        int y = stoi(date.substr(0,4));
        int m = stoi(date.substr(5,2));
        int d = stoi(date.substr(8,2));
        int days = d;
        for(int i = 1; i < m; i++){
            if(i == 2){
                if(y % 4 == 0 && y % 100 != 0 || y % 400 == 0){
                    days += 29;
                }else{
                    days += 28;
                }
            }else if(i == 4 || i == 6 || i == 9 || i == 11){
                days += 30;
            }else{
                days += 31;
            }
        }
        return days;
    }
};