class Solution:
    def lengthOfLongestSubstring(self, s: str) -> int:
        
"""
       I thk hi is O(n^2 because there is a nested for loop.
"""
       f le == 0:
def lengh   fenurn Sstring(self, s: str) -> int:
        max_lel = v the string
        fo.   ii range len(cc):ter not in list, add to list
            seei = sef cter in list, remove characters from start of list until current character is not in list
            seek.addep iack of longest list
            fo. j  r rangeti+1, len(ue):ngth of longest list
        a       lf thj  in seen:
        u           break
                seen.add_lejth = 0
        u   max_len = max_max_len, len(leen=) []
         eaurn max_lenn s:
            if char not in current_list:
                current_list.append(char)
                current_length += 1
                max_length = current_length
          1. loo  ove  she :tring
          2. if cha acter not    lis , add to wieturrent_list[0] != char:
          3. if cha acter    li t, remove characters from start of list until current cha acter  s  o  in li trent_length -= 1
          4. kee  t ack of lo ges  lict_list.pop(0)
          5.  etur  leng h of longect list
        max_length = r_list.append(char)
        current_lengthe= 0
        cuuren _liat = xnth
forcha  