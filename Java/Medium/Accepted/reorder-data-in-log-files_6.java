class Solution {
    public String[] reorderLogFiles(String[] logs) {
        
        List<String> digitLogs = new ArrayList<>();
        List<String> letterLogs = new ArrayList<>();
        for (String log : logs) {
            int i = log.indexOf(' ');
            if (Character.isDigit(log.charAt(i + 1))) {
                digitLogs.add(log);
            } else {
                letterLogs.add(log);
            }
        }
        Collections.sort(letterLogs, (a, b) -> {
            int i = a.indexOf(' ');
            int j = b.indexOf(' ');
            String s1 = a.substring(i + 1);
            String s2 = b.substring(j + 1);
            int cmp = s1.compareTo(s2);
            if (cmp == 0) {
                return a.substring(0, i).compareTo(b.substring(0, j));
            }
            return cmp;
        });
        String[] ans = new String[logs.length];
        int i = 0;
        for (String log : letterLogs) {
            ans[i++] = log;
        }
        for (String log : digitLogs) {
            ans[i++] = log;
        }
        return ans;
    }
}