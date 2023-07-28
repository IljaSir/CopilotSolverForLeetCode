class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        
        List<Integer> res = new ArrayList<>();
        int[] pCnt = new int[26];
        int[] sCnt = new int[26];
        for (char ch : p.toCharArray()) {
            pCnt[ch - 'a']++;
        }
        int left = 0;
        int right = 0;
        int len = p.length();
        while (right < s.length()) {
            sCnt[s.charAt(right) - 'a']++;
            if (right - left + 1 == len) {
                if (isAnagram(pCnt, sCnt)) {
                    res.add(left);
                }
                sCnt[s.charAt(left) - 'a']--;
                left++;
            }
            right++;
        }
        return res;
    }
    private boolean isAnagram(int[] pCnt, int[] sCnt) {
        for (int i = 0; i < pCnt.length; i++) {
            if (pCnt[i] != sCnt[i]) {
                return false;
            }
        }
        return true;
    }
}