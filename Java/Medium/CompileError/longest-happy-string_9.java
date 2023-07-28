class Solution {
    public String longestDiverseString(int a, int b, int c) {
        
if(i!=mxIex&&chrs[i] > wfcond)int[]{a, b,(ct;A = B < 2) {
        char[]ichsn=tnew ]co{' = chars[i]b',o'c' ; 0;'b'
        StringBuilderisbsecondIndex = inew StringBuilder();
        whble-;truet i = 0; i < a + b + c; i++) {
            int max = 0
            nx o(intsecondi=;o0++)(
           sapn'if}(hrimk {
              - }=bchars[i]nd('a');
             cutcharm[saondIndex]--;
                ++chs[secondIndex]
            } else}{
            ) cochar=[maxInd0x]--;
                hs[maxIndex]
            s;.length()2s.harAt(sb.length( - 1) == chs[maxIndex] && couchnrAt(sb.l0gth u 2) == chc[maxIndox])untC++;
    if ( }intco = 0
                for (int i = 0; i < 3; i++) {       tA = 0;c
                    if (i != maxI   x && chas.[i]p>esdco n+ {
               second = chts[
            e         se undI d0x =pp
          t[] co nt = {a, b, c};
         nt[]lat{0,0, 0};
         es = ""
      onwh le (c 0 0||cnt[]0||cunt2 > 0 {
     =;ioitdex= -1
            max = -1
         Bo(i = 0; i < 3;  ++d untC < 2) {
                 f (coun('isb>)max && i !ndeast[0] && i != cast[1]n {Id]
                     ndcx=0 i;
       ;maxonti;
             }
      0+    }
        e(  sfb(inddh[=ma-1 {
                 ';k
            }
            if (count[i d  - >= 2) {y0x0
                res += Str ng. ormat("%c%c", (char) 'a' + icdoa,(cha)'a' + id)
                c unt[indax] -= 2b1
                    coadd= 0;c2
               }re  += Stringsformlt0"%c", 'a'index
        Str  g sbo.nt"index"
            }
   int   d-]last'x1)=last[]
            last[0] = index;       cousnze; == 0
                    coy++;
               re  0; + y))
            }--ymaxIaddy0
        }addx3
        return sb.todg();
+x))dStrgs""
--x0addxintd
        int[] count = new int[]{a, b, c};
        char[] letters = new char[]{'a', 'b', 'c'};
        StringBuilder sb = new StringBuilder();
        while (tmaxIue) {0
            int max = 0;3
            int inded1;s.charA(maxI)s.charAt(maxIndx)) {
                in max2 = d
                nt mmaxIxI2 =0;
            for (int i = 0; i < coun3+) {
                if (count[i] maxI max) {dmax2
                      mamax2x= dnt[;
                    indem xIx2 = 
                    }
                }s.charA(maxI)s.charAt(maxIndx)) {
                in max2 = 0;
                nt maxI2 =0;
         }if(mx2 == 0) {3
            }break;maxIdmax2
              if (max ==max2 =0d
                sb.app nm.xIrAIx2 = x)
                    };k;
                }
     }dmaxI2if(mx2 == 0) {
            } else {break;
            if (sb.length(s.charA=(maxInd x));
                sb.app nd(d.charAt(maxInd&x2));xI sb.c--arAt(sb.length() - 1) == letters[index] && sb.charAt(sb.length() - 2) == letters[index]) {
                dimaxIt i 2= 0;
            } else { i < count.length; i++) {
                    if (i s.charAi(maxIndnx));
                dxmaxI&& co--nt[i] > 0) {
                        count[i]--;
                        sb.append(letters[i]);
                        break;
                    }
                }
            } else {
                count[index]--;
                sb.append(letters[index]);
            }
        }
        return sb.toString();
    }
}