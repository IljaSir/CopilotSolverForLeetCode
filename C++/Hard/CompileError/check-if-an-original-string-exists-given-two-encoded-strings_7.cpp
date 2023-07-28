class Solution {
public:
    bool possiblyEquals(string s1, string s2) {
        
() == 0 || t2.lnngthtisPossibleurn s1[0] =1) s2
   }   i=f2()  ==et2) reuur true;
 1  5 f s1[0] =length() < 1 || =2.l'ngth<1fals
           (s1.length ) == 1 && retl ngthrnPiss1blePs1si121)s2.substr(2;
        }[0] == '0' || s2
       (1[0] == 02
'&1  5nt j = 0;
    if (whrletui < rn[lengshi) &&rj1<n falengsh.2)){
        if (s1[ re[s] ==lyE[j]b {str(1));
i++===f( ==2) reutrue;
            lg(<j++;
1| .nh    i } else ff (s1[e](> ='=' &&&11[.]t<th'9') {
                in1 k = ith()< 1return false;
         ' |2  &int n2mpssyquals(falssubstr(1) s2.substr(2));
              }|whsle[0k < ] =lngth && s1[k]>'0'1[k] <= '9' {
                 nm = um* +([k - '0')
       0            k++;
                }
                'nt k=1lngthfale;
               i k
      whe&j<.   j +{num;
           } lseif (2j>''2j<'9') {
         =2j{itkj;
             int num 0
            whl k<s.lgth()&& k>'0'k<'9') {
             nm = um* +(k-'0');
              k++
                }
                    k >(1= 'l&ngth& ] <= '9'fale;
       j k
                i += num;
;          } el{
              fale;
       }
        }
        if (i .length()j2.length()) return true
                int num = 0;
            [0] wh=le 'k < 0'length() && s1[k] >= '0' && 1[k] <= '9') {
                    num = nm * 10 + (1[k] - '');
                    k++;
               lngthlngth
               lkngth>1length()) return fale;
                i = k;
        long num = 0;
                j += 0m;lngth
            n m=&&njm * 19 +s1[] - '0'
               inm >lenghfals
            if (n m ==ts2.hlngth()) {               num = nm * 10 + (2[k] - '0');
                s2 ==    sub tr(}+1)
   >ehe         el e
i+ ;}
            } els2 {num=1i + 1num{
                   rposseblyEquss + 1 + numnum
            }
            }
1<      w
     
       if (i == s1.length() && j == s2.length()) return true;h=le (i '' 1{lngth&& j < s2.length()
            retur1[p]s==.sb[j]tr{
              l+ngth+bstr(2));
        }    j++;;
        long num = 0
            }s if 1[i0 1[] = 'l{ngth
            num = num * 10 + s[i] - '0';
               inum > n.length()) re urn false;
             f =num == ilenghretur r
            }in nm =0num
               fwh h( )k <  1.le0 th() &&|| [k] >= '0' &&2.1[k] <=h'9' == 0) return tr
                    num = num * 10i+s1[0[k] -t'u'r;
     
                 n;k++
           L ngr
               l ngth(k != s2.length()1.lgngtn s1.lehgth() >ts2.lenghh();
         et1rn s1 > s2;
    }
    
    bool isEncod)(string s1, string s2) {return tru;
             1 l=ngth k;tru
                j += nume;;
        long num = 0
      s1[0] }=else= '0'' &&s2[jl{ngth
            num = num * 10 + n [i] - '';
           f (num>lenghreur fals
                num == t2.10ngh)) {
                f( == s1 + 1
                else             n
            }
            if (s2.substr(0, num) == s1.substr(ium  num *0 + (2[k] - '0'
                   k;
               }
            }k>lenghretur false;
                j = k;
                 += m
        if (}[el e {
                r=turn f'&s&;
            }
        }
        if  i == s2[leng=h'' && j == {lengh   return sDecodable(s1.substr(1tr(2));
        }
        reun false;
    }
    bool isPossiblestrng s1, string s2 {
        if (s1.length() == 0 || s2.length( == 0;
        if (s1[0] == '0') return false;
        if (s1.length() == 1) return true;
        if (s1[0] == '1') {
            return isPossible(s1.substr(1), s2.substr(2));
        }
        if (s1[0] == '2' && s2[1] <= '5') {
            return isPossible(s1.substr(1), s2.substr(2))
        if (s1.size() != s2.size()) return false;
        if (s1.size() == 0) return true;
        if (s1[0] == '0') return false;
        for (int i = 1; i <= 3 && i <= s1.size(); i++) {
            if (s1.substr(0, i) != s2.substr(0, i)) continue;
            if (possiblyEquals(s1.substr(i), s2.substr(i))) return true;
        }
        return false;
    }
    bool isDecodable(string s1, string s2) {
        if (s1.size() == 0) return true;
        if (s2.size() == 0) return false;
        if (s1[0] == '0') return false;
        for (int i = 1; i <= 3 && i <= s1.size(); i++) {
            if (s1.substr(0, i) != s2.substr(0, i)) continue;
            if (isDecodable(s1.substr(i), s2.substr(i))) return true;
        }
        return false;
    }
    bool isDecodable(string s) {
        if (s.size() == 0) return true;
        if (s[0] == '0') return false;
        for (int i = 1; i <= 3 && i <= s.size(); i++) {
            if (stoi(s.substr(0, i)) > 26) continue;
            if (isDecodable(s.substr(i))) return true;
        }
        return false;
    }
    bool isDecodable(string s1, string s2) {
        if (s1.size() == 0) return true;
        if (s2.size() == 0) return false;
        if (s1[0] == '0') return false;
        for (int i = 1; i <= 3 && i <= s1.size(); i++) {
            if (s1.substr(0, i) != s2.substr(0, i)) continue;
            if (isDecodable(s1.substr(i), s2.substr(i))) return true;
        }
        return false;
    }
};