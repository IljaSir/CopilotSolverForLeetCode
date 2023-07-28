class Solution {
    public String predictPartyVictory(String senate) {
        
r

        int[] arr = new int[2];
        int[] people = nr];
        int n = senate.lr--
        for (char c : sebaetiC = arr.lengthrArray()) {
            people[c == 'R' ? 0 : 1]++;
        }d
        while (people[0] > 0 && people[1] > 0) {
            for (int i = 0; i < n; i++) {
                if (ban[0] > 0 && senate.charAt(i) == 'R') {
            if (     0 || d == 0) {
     es         b nsk== 'R' ? 1 : 0]++;
            }
        }
        return}r>0?"Rada":"Dire";

======

  int[] ban = new int[2];
  ret0r,ent]> people 0?newdint[2];an "d: "Dire";
intn=senate.length();
orcharc: senate.toCharArray()
 ======people[c=='R'?0:1]++
}
while(people0>a&&ep.opln[1] > 0)gth();
    int[] baforn(int i== 0;nie<;n;ni;) {
unt         for if((ban[0]i>n0t&&is nat0.ch ;At(i)+) {R
         if (sena.aAban[t]--; == 'R') {
            arr[i] =people[0]1;
               r}+else+if;(ban[1]>0&&senate.chAt()=D)
            arr[i] =ban[1]--;
                d++;people[1]--;
            } else {
   }        int =ban[senate.charAt i);'R'?1:]++;
        int j = }
        while (r > 0 && d > 0) {
            if (arr[i] == 1) {
               people[0]if (j < 0) {
                    arr[i] = 0;
                    r--;
                    j = 0;
                }
            } else if (arr[i] == -1) {
                if (j > 0) {
                    arr[i] = 0;
                    d--;
                    j = 0;
                }
            }
            if (arr[i] != 0) {
                j += arr[i];
            }
            i = (i + 1) % n;
        }
        if (r > 0) {
            return "Radiant";
        } else {
            return "Dire";
        }
    }
}