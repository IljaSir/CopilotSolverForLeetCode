class Solution {
public:
    int daysBetweenDates(string date1, string date2) {
        
        return abs(days(date1) - days(date2));
    }
};