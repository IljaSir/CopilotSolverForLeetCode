class Solution {
    public String reformatDate(String date) {
        
        String[] split = date.split(" ");
        String day = split[0];
        String month = split[1];
        String year = split[2];
        String[] days = new String[]{"1st", "2nd", "3rd", "4th", "5th", "6th", "7th", "8th", "9th", "10th", "11th", "12th", "13th", "14th", "15th", "16th", "17th", "18th", "19th", "20th", "21st", "22nd", "23rd", "24th", "25th", "26th", "27th", "28th", "29th", "30th", "31st"};
        String[] months = new String[]{"Jan", "Feb", "Mar", "Apr", "May", "Jun", "Jul", "Aug", "Sep", "Oct", "Nov", "Dec"};
        String dayNum = day.substring(0, day.length() - 2);
        String monthNum = "";
        for (int i = 0; i < months.length; i++) {
            if (month.equals(months[i])) {
                monthNum = String.format("%02d", i + 1);
            }
        }
        return year + "-" + monthNum + "-" + String.format("%02d", Integer.parseInt(dayNum));
    }
}