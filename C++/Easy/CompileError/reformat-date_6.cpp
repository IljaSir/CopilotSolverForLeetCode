class Solution {
public:
    string reformatDate(string date) {
        
        int day,year;
        string month;
        string dayString="";
        string yearString="";
        string monthString="";
        for(int i=0;i<date.length();i++){
            if(date[i]==' '){
                day=stoi(dayString);
                break;
            }
            if(date[i]>='0' && date[i]<='9'){
                dayString+=date[i];
            }
        }
        for(int i=0;i<date.length();i++){
            if(date[i]==' '){
                month=monthString;
                break;
            }
            if(date[i]>='a' && date[i]<='z'){
                monthString+=date[i];
            }
        }
        for(int i=0;i<date.length();i++){
            if(date[i]==' '){
                year=stoi(yearString);
                break;
            }
            if(date[i]>='0' && date[i]<='9'){
                yearString+=date[i];
            }
        }
        if(month=="Jan"){
            month="01";
        }
        else if(month=="Feb"){
            month="02";
        }
        else if(month=="Mar"){
            month="03";
        }
        else if(month=="Apr"){
            month="04";
        }
        else if(month=="May"){
            month="05";
        }
        else if(month=="Jun"){
            month="06";
        }
        else if(month=="Jul"){
            month="07";
        }
        else if(month=="Aug"){
            month="08";
        }
        else if(month=="Sep"){
            month="09";
        }
        else if(month=="Oct"){
            month="10";
        }
        else if(month=="Nov"){
            month="11";
        }
        else if(month=="Dec"){
            month="12";
        }
        string dayString1="";
        string dayString2="";
        dayString1+=to_string(day);
        if(dayString1.length()==1){
            dayString2+="0";
        }
        dayString2+=dayString1;
        string yearString1="";
        string yearString2="";
        string yearString3="";
        string yearString4="";
        yearString1+=to_string(year);
        yearString2+=yearString1[2];
        yearString3+=yearString1[3];
        yearString4+=yearString2;
        yearString4+=yearString3;
        string ans="";
        ans+=yearString1;
        ans
    }
};