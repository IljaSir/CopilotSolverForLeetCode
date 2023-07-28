class Solution {
public:
    int daysBetweenDates(string date1, string date2) {
        
        int year1 = stoi(date1.substr(0,4));
        int month1 = stoi(date1.substr(5,2));
        int day1 = stoi(date1.substr(8,2));
        int year2 = stoi(date2.substr(0,4));
        int month2 = stoi(date2.substr(5,2));
        int day2 = stoi(date2.substr(8,2));
        int days1 = 0;
        int days2 = 0;
        for(int i=1971;i<year1;i++) {
            if (i%4==0) {
                days1 += 366;
            } else {
                days1 += 365;
            }
        }
        for(int i=1971;i<year2;i++) {
            if (i%4==0) {
                days2 += 366;
            } else {
                days2 += 365;
            }
        }
        int days = 0;
        if (year1==year2) {
            if (month1==month2) {
                days = abs(day1-day2);
            } else {
                if (month1<month2) {
                    for(int i=month1;i<month2;i++) {
                        days += daysInMonth(i,year1);
                    }
                    days += day2;
                    days -= day1;
                } else {
                    for(int i=month2;i<month1;i++) {
                        days += daysInMonth(i,year2);
                    }
                    days += day1;
                    days -= day2;
                }
            }
        } else {
            if (year1<year2) {
                for(int i=month1;i<=12;i++) {
                    days += daysInMonth(i,year1);
                }
                days += day1;
                for(int i=1;i<month2;i++) {
                    days += daysInMonth(i,year2);
                }
                days += day2;
            } else {
                for(int i=month2;i<=12;i++) {
                    days += daysInMonth(i,year2);
                }
                days += day2;
                for(int i=1;i<month1;i++) {
                    days += daysInMonth(i,year1);
                }
                days += day1;
            }
        }
        return abs(days1+days-days2);
    }
};