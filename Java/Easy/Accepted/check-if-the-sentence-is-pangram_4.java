class Solution {
    public boolean checkIfPangram(String sentence) {
        
        int[] c = new int[26];
        for (char ch : sentence.toCharArray()) {
            c[ch - 'a']++;
        }
        for (int i : c) {
            if (i == 0) {
                return false;
            }
        }
        return true;
    }
}