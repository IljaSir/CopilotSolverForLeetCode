class Solution {
    public int countTime(String time) {
        
        String[] num = time.split(":");
        int hour = Integer.parseInt(num[0]);
        int minute = Integer.parseInt(num[1]);
        if (hour < 0 || hour > 23 || minute < 0 || minute > 59) {
            return 0;
        }
        return 1;
    }

    public int numberOfValidClockTimes(String time) {
        int count = 0;
        for (int i = 0; i < 24; i++) {
            for (int j = 0; j < 60; j++) {
                String hour = String.valueOf(i);
                String minute = String.valueOf(j);
                if (hour.length() == 1) {
                    hour = "0" + hour;
                }
                if (minute.length() == 1) {
                    minute = "0" + minute;
                }
                if (hour.contains("?") || minute.contains("?")) {
                    continue;
                }
                String newTime = hour + ":" + minute;
                count += countTime(newTime);
            }
        }
        return count;
    }
}