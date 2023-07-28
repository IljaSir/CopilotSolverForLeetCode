class Solution {
    public String[] reorderLogFiles(String[] logs) {
        
        Arrays.sort(logs, new Comparator<String>() {
            public int compare(String a, String b) {
                String[] aSplit = a.split(" ", 2);
                String[] bSplit = b.split(" ", 2);
                boolean isDigitA = Character.isDigit(aSplit[1].charAt(0));
                boolean isDigitB = Character.isDigit(bSplit[1].charAt(0));
                if (!isDigitA && !isDigitB) {
                    int cmp = aSplit[1].compareTo(bSplit[1]);
                    if (cmp != 0) {
                        return cmp;
                    }
                    return aSplit[0].compareTo(bSplit[0]);
                }
                return isDigitA ? (isDigitB ? 0 : 1) : -1;
            }
        });
        return logs;
    }
}