class Solution {
    public String reformatDate(String date) {
        
        String[] tokens = date.split(" ");
        String day = tokens[0].substring(0, tokens[0].length() - 2);
        String month = tokens[1];
        String year = tokens[2];
        if (day.length() == 1) {
            day = "0" + day;
        }
        switch (month) {
            case "Jan":
                month = "01";
                break;
            case "Feb":
                month = "02";
                break;
            case "Mar":
                month = "03";
                break;
            case "Apr":
                month = "04";
                break;
            case "May":
                month = "05";
                break;
            case "Jun":
                month = "06";
                break;
            case "Jul":
                month = "07";
                break;
            case "Aug":
                month = "08";
                break;
            case "Sep":
                month = "09";
                break;
            case "Oct":
                month = "10";
                break;
            case "Nov":
                month = "11";
                break;
            case "Dec":
                month = "12";
                break;
        }
        return year + "-" + month + "-" + day;
    }
}