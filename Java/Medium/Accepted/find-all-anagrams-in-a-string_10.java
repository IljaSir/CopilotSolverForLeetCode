class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        
        List<Integer> res = new ArrayList();
        int[] pArr = new int[26];
        int[] sArr = new int[26];
        for (int i = 0; i < p.length(); i++) {
            pArr[p.charAt(i) - 'a']++;
        }
        int left = 0, right = 0;
        while (right < s.length()) {
            sArr[s.charAt(right) - 'a']++;
            if (right - left + 1 > p.length()) {
                sArr[s.charAt(left) - 'a']--;
                left++;
            }
            if (right - left + 1 == p.length() && Arrays.equals(sArr, pArr)) {
                res.add(left);
            }
            right++;
        }
        return res;
    }
}