class Solution {
    public String reformatDate(String date) {
        
        String[] parts = date.split(" ");
        String day = parts[0];
        String month = parts[1];
        String year = parts[2];
        
        return year + "-" + getMonth(month) + "-" + getDay(day);
    }
    
    private String getMonth(String month) {
        switch(month) {
            case "Jan":
                return "01";
            case "Feb":
                return "02";
            case "Mar":
                return "03";
            case "Apr":
                return "04";
            case "May":
                return "05";
            case "Jun":
                return "06";
            case "Jul":
                return "07";
            case "Aug":
                return "08";
            case "Sep":
                return "09";
            case "Oct":
                return "10";
            case "Nov":
                return "11";
            case "Dec":
                return "12";
            default:
                return null;
        }
    }
    
    private String getDay(String day) {
        if (day.length() == 3) {
            return "0" + day.substring(0, 1);
        } else {
            return day.substring(0, 2);
        }
    }
}