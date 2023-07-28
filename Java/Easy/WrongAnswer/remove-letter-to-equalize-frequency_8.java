class Solution {
    public boolean equalFrequency(String word) {
        
        int[] count = new int[26];
        for (char c : word.toCharArray())
            count[c - 'a']++;
        Arrays.sort(count);
        int i = 0;
        while (i < 26 && count[i] == 0)
            i++;
        int min = count[i];
        int max = count[25];
        if (min == max)
            return true;
        if (min == 1 && count[i + 1] == max)
            return true;
        return min == max - 1 && count[24] == max;
    }
}