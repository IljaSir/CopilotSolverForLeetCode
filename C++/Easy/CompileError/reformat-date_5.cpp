class Solution {
public:
    string reformatDate(string date) {
        
        string res;
        int year = stoi(date.substr(date.length() - 4));
        res = to_string(year) + '-';
        string month = date.substr(date.length() - 8, 3);
        if (month == "Jan") res += "01";
        else if (month == "Feb") res += "02";
        else if (month == "Mar") res += "03";
        else if (month == "Apr") res += "04";
        else if (month == "May") res += "05";
        else if (month == "Jun") res += "06";
        else if (month == "Jul") res += "07";
        else if (month == "Aug") res += "08";
        else if (month == "Sep") res += "09";
        else if (month == "Oct") res += "10";
        else if (month == "Nov") res += "11";
        else if (month == "Dec") res += "12";
        res += '-';
        if (date[1] == 't') res += '0' + date[0];
        else if (date[1] == 'n') res += '1' + date[0];
        else if (date[1] == 'l') res += '1' + date[0];
        else if (date[1] == 'g') res += '2' + date[0];
        else if (date[1] == 'p') res += '3' + date[0];
        else if (date[1] == 'v') res += '4' + date[0];
        else if (date[1] == 'c') res += '5' + date[0];
        else if (date[1] == 'r') res += '6' + date[0];
        else if (date[1] == 'h') res += '7' + date[0];
        else if (date[1] == 'o') res += '8' + date[0];
        else if (date[1] == 'y') res += '9' + date[0];
        else if (date[1] == 'b') res += '1' + date[0];
        else if (date[1] == 'e') res += '3' + date[0];
    }
};