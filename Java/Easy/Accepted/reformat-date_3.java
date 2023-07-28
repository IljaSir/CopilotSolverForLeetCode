class Solution {
    public String reformatDate(String date) {
        
        String[] d = date.split(" ");
        String day = d[0].substring(0, d[0].length() - 2);
        String month = d[1];
        String year = d[2];
        if (day.length() == 1) {
            day = "0" + day;
        }
        if (month.equals("Jan")) {
            month = "01";
        } else if (month.equals("Feb")) {
            month = "02";
        } else if (month.equals("Mar")) {
            month = "03";
        } else if (month.equals("Apr")) {
            month = "04";
        } else if (month.equals("May")) {
            month = "05";
        } else if (month.equals("Jun")) {
            month = "06";
        } else if (month.equals("Jul")) {
            month = "07";
        } else if (month.equals("Aug")) {
            month = "08";
        } else if (month.equals("Sep")) {
            month = "09";
        } else if (month.equals("Oct")) {
            month = "10";
        } else if (month.equals("Nov")) {
            month = "11";
        } else if (month.equals("Dec")) {
            month = "12";
        }
        return year + "-" + month + "-" + day;
    }
}