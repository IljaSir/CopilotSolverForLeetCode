class Solution {
public:
    int convertTime(string current, string correct) {
        
        int hour = stoi(current.substr(0,2));
        int minute = stoi(current.substr(3,2));
        int hour1 = stoi(correct.substr(0,2));
        int minute1 = stoi(correct.substr(3,2));
        int ans = 0;
        int temp = 0;
        while(hour != hour1 || minute != minute1){
            temp++;
            if(temp == 60){
                hour++;
                temp = 0;
            }
            if(hour == 24){
                hour = 0;
            }
            minute++;
            if(minute == 60){
                minute = 0;
            }
            ans++;
        }
        return ans;
    }
    int numberOfRounds(string startTime, string finishTime) {
        int hour = stoi(startTime.substr(0,2));
        int minute = stoi(startTime.substr(3,2));
        int hour1 = stoi(finishTime.substr(0,2));
        int minute1 = stoi(finishTime.substr(3,2));
        if(hour > hour1 || (hour == hour1 && minute > minute1)){
            hour1 += 24;
        }
        int ans = 0;
        while(hour != hour1 || minute != minute1){
            minute += 15;
            if(minute == 60){
                hour++;
                minute = 0;
            }
            if(hour == 24){
                hour = 0;
            }
            ans++;
        }
        return ans;
    }
    int numberOfRounds(string current, string correct) {
        int hour = stoi(current.substr(0,2));
        int minute = stoi(current.substr(3,2));
        int hour1 = stoi(correct.substr(0,2));
        int minute1 = stoi(correct.substr(3,2));
        if(hour > hour1 || (hour == hour1 && minute > minute1)){
            hour1 += 24;
        }
        int ans = 0;
        while(hour != hour1 || minute != minute1){
            minute += 15;
            if(minute == 60){
                hour++;
                minute = 0;
            }
            if(hour == 24){
                hour = 0;
            }
            ans++;
        }
        return ans;
    }
};