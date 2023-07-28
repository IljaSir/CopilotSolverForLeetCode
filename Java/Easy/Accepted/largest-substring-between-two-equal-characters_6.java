class Solution {
    public int maxLengthBetweenEqualCharacters(String s) {
        
        int[] firstIndex = new int[26];
        int[] lastIndex = new int[26];
        Arrays.fill(firstIndex, -1);
        Arrays.fill(lastIndex, -1);
        for(int i = 0; i < s.length(); i++) {
            int index = s.charAt(i) - 'a';
            if(firstIndex[index] == -1) {
                firstIndex[index] = i;
            }
            lastIndex[index] = i;
        }
        int max = -1;
        for(int i = 0; i < 26; i++) {
            if(firstIndex[i] != -1 && lastIndex[i] != -1) {
                max = Math.max(max, lastIndex[i] - firstIndex[i] - 1);
            }
        }
        return max;
    }
}