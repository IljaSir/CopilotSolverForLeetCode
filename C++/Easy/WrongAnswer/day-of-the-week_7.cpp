class Solution {
public:
    string dayOfTheWeek(int day, int month, int year) {
        
        int days = 0;
        for(int i=1971;i<year;i++){
            if(isLeapYear(i)){
                days+=366;
            }else{
                days+=365;
            }
        }
        for(int i=1;i<month;i++){
            days+=getDaysOfMonth(i,year);
        }
        days+=day-1;
        int week = days%7;
        string ans;
        switch(week){
            case 0:
                ans = "Sunday";
                break;
            case 1:
                ans = "Monday";
                break;
            case 2:
                ans = "Tuesday";
                break;
            case 3:
                ans = "Wednesday";
                break;
            case 4:
                ans = "Thursday";
                break;
            case 5:
                ans = "Friday";
                break;
            case 6:
                ans = "Saturday";
                break;
        }
        return ans;
    }
    int getDaysOfMonth(int month,int year){
        if(month==1||month==3||month==5||month==7||month==8||month==10||month==12){
            return 31;
        }
        if(month==4||month==6||month==9||month==11){
            return 30;
        }
        if(month==2){
            if(isLeapYear(year)){
                return 29;
            }else{
                return 28;
            }
        }
        return -1;
    }
    bool isLeapYear(int year){
        if(year%400==0){
            return true;
        }
        if(year%100==0){
            return false;
        }
        if(year%4==0){
            return true;
        }
        return false;
    }
};