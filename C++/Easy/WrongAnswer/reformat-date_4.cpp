class Solution {
public:
    string reformatDate(string date) {
        
        int d = 0;
        string m;
        int y = 0;
        int i = 0;
        while(date[i] != ' ') {
            d = d * 10 + (date[i] - '0');
            ++i;
        }
        ++i;
        while(date[i] != ' ') {
            m += date[i];
            ++i;
        }
        ++i;
        while(i < date.size()) {
            y = y * 10 + (date[i] - '0');
            ++i;
        }
        string y1 = to_string(y);
        string m1;
        if(m == "Jan") m1 = "01";
        if(m == "Feb") m1 = "02";
        if(m == "Mar") m1 = "03";
        if(m == "Apr") m1 = "04";
        if(m == "May") m1 = "05";
        if(m == "Jun") m1 = "06";
        if(m == "Jul") m1 = "07";
        if(m == "Aug") m1 = "08";
        if(m == "Sep") m1 = "09";
        if(m == "Oct") m1 = "10";
        if(m == "Nov") m1 = "11";
        if(m == "Dec") m1 = "12";
        string d1;
        if(d < 10) d1 = "0" + to_string(d);
        else d1 = to_string(d);
        return y1 + "-" + m1 + "-" + d1;
    }
};