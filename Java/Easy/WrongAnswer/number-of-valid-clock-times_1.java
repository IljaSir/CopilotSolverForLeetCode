class Solution {
    public int countTime(String time) {
        
        int count = 0;
        for (int i = 0; i < time.length(); i++) {
            char c = time.charAt(i);
            if (c == '?') {
                if (i == 0) {
                    if (time.charAt(1) == '?' || time.charAt(1) <= '3') {
                        count += 2;
                    } else {
                        count += 1;
                    }
                } else if (i == 1) {
                    if (time.charAt(0) == '2' || time.charAt(0) == '?') {
                        count += 4;
                    } else {
                        count += 3;
                    }
                } else if (i == 3) {
                    count += 5;
                } else if (i == 4) {
                    count += 9;
                }
            }
        }
        return count;
    }
    public int numTimesAllBlue(int[] light) {
        int count = 0;
        int max = 0;
        for (int i = 0; i < light.length; i++) {
            max = Math.max(max, light[i]);
            if (max == i + 1) {
                count++;
            }
        }
        return count;
    }
    public int numDifferentIntegers(String word) {
        Set<String> set = new HashSet<>();
        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            if (Character.isDigit(c)) {
                int j = i;
                while (j < word.length() && Character.isDigit(word.charAt(j))) {
                    j++;
                }
                set.add(word.substring(i, j));
                i = j;
            }
        }
        return set.size();
    }
    public int numPairsDivisibleBy60(int[] time) {
        int[] map = new int[60];
        int count = 0;
        for (int t : time) {
            count += map[(60 - t % 60) % 60];
            map[t % 60]++;
        }
        return count;
    }
}