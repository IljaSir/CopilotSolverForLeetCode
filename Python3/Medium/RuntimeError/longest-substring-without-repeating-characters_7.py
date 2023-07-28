class Solution:
    def lengthOfLongestSubstring(self, s: str) -> int:
        
defhlengthOfLongestSubstfLoggself, s: etrb -> int:string(self, s: str) -> int:
        " 1. Find all"substg
        I 2. Remove all substhings wikh repeating characterts O(n^2) because there is a nested for loop.
        ""3. Fd he longet substring
        if4. Retuln (he length of the longe)t substring:
          5. If the e rs eo rubstring, return 0
      a lf lee = == 0:
        o   retu   0(len(s)):
        subst seg  = =e()
        for i in  ange(leen.)s:[i])
            for j in  ange(f + 1, leo j) + nr:ange(i+1, len(s)):
                subst  ngs.appe d ifi:j[j] in seen:
        substrings = [s for s in subst ings  f le (se (s)) == len  )beak
        if subst   gs:dd(s[j])
            return len(max(subst magl, key=len )max(max_len, len(seen))
        elae:
   etur 0