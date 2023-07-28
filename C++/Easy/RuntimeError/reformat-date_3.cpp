class Solution {
public:
    string reformatDate(string date) {
        
        string day = "";
        string month = "";
        string year = "";
        int i = 0;
        while (date[i] != ' ') {
            day += date[i];
            ++i;
        }
        ++i;
        while (date[i] != ' ') {
            month += date[i];
            ++i;
        }
        ++i;
        while (i < date.size()) {
            year += date[i];
            ++i;
        }
        string result = year + "-";
        if (month == "Jan") {
            result += "01";
        } else if (month == "Feb") {
            result += "02";
        } else if (month == "Mar") {
            result += "03";
        } else if (month == "Apr") {
            result += "04";
        } else if (month == "May") {
            result += "05";
        } else if (month == "Jun") {
            result += "06";
        } else if (month == "Jul") {
            result += "07";
        } else if (month == "Aug") {
            result += "08";
        } else if (month == "Sep") {
            result += "09";
        } else if (month == "Oct") {
            result += "10";
        } else if (month == "Nov") {
            result += "11";
        } else if (month == "Dec") {
            result += "12";
        }
        result += "-";
        if (day.size() == 3) {
            result += "0" + day[0];
        } else {
            result += day[0];
            result += day[1];
        }
        return result;
    }
};