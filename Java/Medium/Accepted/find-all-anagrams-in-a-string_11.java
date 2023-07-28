class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        
        int[] pArr = new int[26];
        int[] sArr = new int[26];
        List<Integer> result = new ArrayList<>();
        if (s.length() < p.length()) {
            return result;
        }
        for (int i = 0; i < p.length(); i++) {
            pArr[p.charAt(i) - 'a']++;
            sArr[s.charAt(i) - 'a']++;
        }
        if (Arrays.equals(pArr, sArr)) {
            result.add(0);
        }
        for (int i = p.length(); i < s.length(); i++) {
            sArr[s.charAt(i) - 'a']++;
            sArr[s.charAt(i - p.length()) - 'a']--;
            if (Arrays.equals(pArr, sArr)) {
                result.add(i - p.length() + 1);
            }
        }
        return result;
    }
}