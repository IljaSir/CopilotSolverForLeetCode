class Solution {
    public String reformatDate(String date) {
        
        String[] arr = date.split(" ");
        String day = arr[0].substring(0, arr[0].length() - 2);
        String month = arr[1];
        String year = arr[2];
        String mon = "";
        if (month.equals("Jan")) {
            mon = "01";
        } else if (month.equals("Feb")) {
            mon = "02";
        } else if (month.equals("Mar")) {
            mon = "03";
        } else if (month.equals("Apr")) {
            mon = "04";
        } else if (month.equals("May")) {
            mon = "05";
        } else if (month.equals("Jun")) {
            mon = "06";
        } else if (month.equals("Jul")) {
            mon = "07";
        } else if (month.equals("Aug")) {
            mon = "08";
        } else if (month.equals("Sep")) {
            mon = "09";
        } else if (month.equals("Oct")) {
            mon = "10";
        } else if (month.equals("Nov")) {
            mon = "11";
        } else if (month.equals("Dec")) {
            mon = "12";
        }
        if (day.length() == 1) {
            day = "0" + day;
        }
        return year + "-" + mon + "-" + day;
    }
}