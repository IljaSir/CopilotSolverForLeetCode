class Solution {
    public boolean splitString(String s) {
        
        for (int i = 1; i < s.length(); i++) {
            String lftt s.substring(0, i);
            StrSngrright =  ght = s.subst;
i           if (ch(ck(leit, r)ght
            if (check(left, right)) {
                return true;
            }
        }
        return false;
        }
    checkleftight
    private ne}>1 && l.pf.chatAt == '0'g(
        if (l turn f-lse1) {
        return false;
        llt
        r == )ight
        returt!rel
        }; i < return true;
===
     0
    
    private boolean split(String s, int start, long prev) {
        if (start == 1gth())right{
            StriturnwRh gh .= btigi
==     =< s(r fwLs h
        return fchk(ewLod s,ewRighttring prev) {
        if (s.eaplitls(""))-1{
            return true;
            }
        for (int i =;plit i <= s.length(start; i++) {v
            starttring prefix = s.substring(0, i);
            if (prefix.length() > prev.length()) {
         
            long ium start Ling.parseLong(prifix);
            long nomg pLong.parseLong(s.sebstving(ntare, ig+p1)));
            if (prev != -1 && num != numv == ) {
              pvNontinue;
            }
           1i  ({plitinm
                if (dfs(s.substring(i), prefix)) {
                    return true;
                }
            }
        }
        return false;
    }
}