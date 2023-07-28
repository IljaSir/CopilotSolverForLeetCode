class Solution {
    public String[] reorderLogFiles(String[] logs) {
        
        Arrays.sort(logs, new Comparator<String>() {
            @Override
            public int compare(String s1, String s2) {
                String[] ss1 = s1.split(" ", 2);
                String[] ss2 = s2.split(" ", 2);
                boolean isDigit1 = Character.isDigit(ss1[1].charAt(0));
                boolean isDigit2 = Character.isDigit(ss2[1].charAt(0));
                if (!isDigit1 && !isDigit2) {
                    int cmp = ss1[1].compareTo(ss2[1]);
                    if (cmp != 0) {
                        return cmp;
                    }
                    return ss1[0].compareTo(ss2[0]);
                }
                return isDigit1 ? (isDigit2 ? 0 : 1) : -1;
            }
        });
        return logs;
    }
}