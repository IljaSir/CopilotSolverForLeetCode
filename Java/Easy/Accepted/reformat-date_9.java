class Solution {
    public String reformatDate(String date) {
        
        String[] arr = date.split(" ");
        String year = arr[2];
        String day = arr[0];
        String month = arr[1];
        String monthNum = "";
        switch (month) {
            case "Jan":
                monthNum = "01";
                break;
            case "Feb":
                monthNum = "02";
                break;
            case "Mar":
                monthNum = "03";
                break;
            case "Apr":
                monthNum = "04";
                break;
            case "May":
                monthNum = "05";
                break;
            case "Jun":
                monthNum = "06";
                break;
            case "Jul":
                monthNum = "07";
                break;
            case "Aug":
                monthNum = "08";
                break;
            case "Sep":
                monthNum = "09";
                break;
            case "Oct":
                monthNum = "10";
                break;
            case "Nov":
                monthNum = "11";
                break;
            case "Dec":
                monthNum = "12";
                break;
        }
        String dayNum = "";
        if (day.length() == 3) {
            dayNum = "0" + day.charAt(0);
        } else {
            dayNum = day.substring(0, 2);
        }
        return year + "-" + monthNum + "-" + dayNum;
    }
}