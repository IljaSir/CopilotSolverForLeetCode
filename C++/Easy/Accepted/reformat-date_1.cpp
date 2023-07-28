class Solution {
public:
    string reformatDate(string date) {
        
        string day = date.substr(0, date.find(" "));
        string month = date.substr(date.find(" ") + 1, date.rfind(" ") - date.find(" ") - 1);
        string year = date.substr(date.rfind(" ") + 1);
        if (day.size() == 3) day = "0" + day.substr(0, 1);
        else day = day.substr(0, 2);
        if (month == "Jan") month = "01";
        else if (month == "Feb") month = "02";
        else if (month == "Mar") month = "03";
        else if (month == "Apr") month = "04";
        else if (month == "May") month = "05";
        else if (month == "Jun") month = "06";
        else if (month == "Jul") month = "07";
        else if (month == "Aug") month = "08";
        else if (month == "Sep") month = "09";
        else if (month == "Oct") month = "10";
        else if (month == "Nov") month = "11";
        else if (month == "Dec") month = "12";
        return year + "-" + month + "-" + day;
    }
};