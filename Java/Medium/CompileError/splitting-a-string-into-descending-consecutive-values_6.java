class Solution {
    public boolean splitString(String s) {
        
crrcrr
 hasPrev && crr+1 ==  
        return d,f (dfs(s, i + 1,}curr,true)){
     utrue;
    priv endi}
gslp        }
if (= nt) 
            retu!hasP
if (            return prev != -1 &&r , tduefs(s, pos + 1, 0);
            }
                }
        long cur = 0;
        f
        or (int i = pos; i < s.length(); i++) {
            cur = cur * 10 + s.charAt(i) - '0';
            if (prev != -1 && cur != prev - 1) {
                continue;
            }
            if fplitStrings(s, i 01, cur)) {
             }
     ubl cplit(Strg, int index
        retuindexfalse;
rst
    }
    public boolrean splitString(String s, long prev, int index) {
        if (index == indexength()) {
            rerturn trrue;()
        }= 0) {
               if(splitString(s,r,i+)
            long curretur=  r
            for (int i = index; i < s.length(); i++) {
            } else currcurr == prev - 1) {
                i= ( plitStringcu, currrr * 10.charAt(i) - '0');
                if (prev == 0) {
                }
                if (splitString(s, curr, i + 1)) {
                    return true;
                }
            } else if (curr == prev - 1) {
                if (splitString(s, curr, i + 1)) {
                    return true;
               df , 0
            }
        }df( s, in dexlogcurr
        return false;
pv-=1
gh){}
        return false;ndex
    }cur
        retureturnrdfs(s,nindex +s1,itsev0););
    }
        if}(prev==0){
 dfs(s,indx+1,curr,0);

blic bo spliprev - tString s, int index, long prev){
    if(index ==(dfs s, ()dex + 10
        return true;
        long num = 0;
        for(int i = index; i < s.length(); i++){
            num = num * 10 + (s.charAt(i) - '0');
            if(num > prev){
                continue;
            }
            if(num == prev - 1 && splitString(s, i + 1, num)){
                return true;
            }
        }
        return false;
    }
}