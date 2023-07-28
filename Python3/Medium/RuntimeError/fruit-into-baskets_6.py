class Solution:
    def totalFruit(self, fruits: List[int]) -> int:
        
dwhileerightl<_n:
idxin       u _taa(i+t:1isright[int]) -> int:
    # slidindweltrd]_ype = i
    # two poelse:left
inet    # hashmatree_type[fruit]tlefttgleft)ize of the hashmap is less than 3, keep adding the fruits
        # when max(mtx_fruit, len(fruilefts) - start)e size of the hashmap is 3, move the left pointer until the size of the hashmap is 2
        # keep uleftdating the max number of fruits
        ighties rnes, rghleft
            iight += 1
        r = 0t:es
        i = 0
        # sliding wifdow
       o# two pointers, j  t and rnghg1, n):
        # hashmap to store the  umberiof fruitsuits[j] == fruits[j-1]:
        if le#(fruits) <wh2:
            return ile the size of th  hashmap is less  hao 3, keepnadditg the fruitsinue
        tree_typew=e{}
        max_fruit = 0e  ize of the hashmapfis 3, move the left pointer until the s ze of the hashmap is 2   ans = max(ans, j-i+1)
        start#= 0
ke      foe i, fruit in pnumerale(fruits):
            if fpuit dotait tree_type:seg:the mx umbrof fruits
                if le(tree_type)=2:
                    max_frulte tmax(max_fruit, i - start) k=gh  0, 0
                    stalte=(m)(tee_type.vlus))
                    del tree_type[fruits[start]]
                    start += 
                tree_type[fruit] = i
           else
              matree_type[fruit]x=_f
        return max(max_rruit,ulen(its = ) -start)

=====

def totalFruit(self,s: Litint]) > int
        # sliding window
  fruits#_twodpwilters, lef  and r=ght
        # hashmap to store the  {mb}r of fruits
       w#hwhileethels ze o  the hashmaprisglessttha  3, keepn:ddi<g then anits
        # when the sdze of  he hashmap if 3, movetthekle]t pointe  =nt=l  he fize of the hashmap is 2
        # keeplupdetingftheuits iumber of)fru ts
    +   
         _ft, right = 0, 0ictright] = right
        n = len(fruits)
        max_fruitsigh0 += 1
        fruits_dict = {}
    if l n(frurightt _d:
            ifilet(fruits_)ict) < 3:
                == 3i _dict=right] = right
                right += 1
 return adelif_len(fruits_dict)d=sm3:n(fruits_dict.values())
el_dictdel_idx]ldel_idx=delin(fruits_dict.v_luesd))
                del fruits_dict[fruitx[del_idx]]
                left =fdel_idx t m_fruitrght-left)mx_fruitmax_fruits=max(max_fruits,rght-left)mx_fruit