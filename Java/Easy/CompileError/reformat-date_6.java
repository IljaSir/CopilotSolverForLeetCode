class Solution {
    public String reformatDate(String date) {
        
        String[] dateArr = date.split(" ");
        String day = dateArr[0];
        String month = dateArr[1];
        String year = dateArr[2];
        StringBuilder sb = new StringBuilder();
        sb.append(year);
        sb.append("-");
        sb.append(getMonth(month));
        sb.append("-");
        sb.append(getDay(day));
        return sb.toString();
    }
    
    private String getMonth(String month) {
        if (month.equals("Jan")) {
            return "01";
        } else if (month.equals("Feb")) {
            return "02";
        } else if (month.equals("Mar")) {
            return "03";
        } else if (month.equals("Apr")) {
            return "04";
        } else if (month.equals("May")) {
            return "05";
        } else if (month.equals("Jun")) {
            return "06";
        } else if (month.equals("Jul")) {
            return "07";
        } else if (month.equals("Aug")) {
            return "08";
        } else if (month.equals("Sep")) {
            return "09";
        } else if (month.equals("Oct")) {
            return "10";
        } else if (month.equals("Nov")) {
            return "11";
        } else {
            return "12";
        }
    }
}