class Solution {
public:
    string reformatDate(string date) {
        
        map<string, string> m;
        m["Jan"] = "01";
        m["Feb"] = "02";
        m["Mar"] = "03";
        m["Apr"] = "04";
        m["May"] = "05";
        m["Jun"] = "06";
        m["Jul"] = "07";
        m["Aug"] = "08";
        m["Sep"] = "09";
        m["Oct"] = "10";
        m["Nov"] = "11";
        m["Dec"] = "12";
        string res;
        string d, mth, y;
        stringstream ss(date);
        ss >> d >> mth >> y;
        res = y + "-" + m[mth] + "-";
        if (d.length() == 4) {
            res += "0" + d.substr(0, 1);
        }
        else if (d.length() == 3) {
            res += d.substr(0, 2);
        }
        else {
            res += "0" + d.substr(0, 1);
        }
        return res;
    }
};