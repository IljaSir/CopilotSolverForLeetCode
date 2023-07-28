class Solution:
    def getSkyline(self, buildings: List[List[int]]) -> List[List[int]]:
    class Solution:
    def getSkyline(sandlf, buildings: List[List[int]]) -> List[List[int]]:
        # 1. Divide and Conquenn
        # Time  complexity: O(nlogn)
        # # Sp ctSplexit:sOl()buldins
        ## de d f updaup_xuyput(x, y):
        ##        # if skyli e cha geiis top vrutical - add      ewuppintx, y])
        ##   #i   if soe:upuoouput[-1][0] != x:
      # #      opu.ppe([x,])
        ##   dfeg   if, kyl=ne   angcu sev_ trcalh- updaty eatoi
        ##    tu=else
#   otu[-1][1]=y

        ##    de wmerge_skyhinis(lele,n or p)r:
        ##        nil wn_rre atn(le t),  en(right)nd of left list or current x is bigger than right's
        ##         _ i pp_r = 0     x, left_y = left[p_l]
        ##             y_=+left_y = 1_y = 0
      # #         out ut#el[]e if we'fe at the ond of right lisr or c rle,t x is bigger than left's

        ##        weslp_l< _lrp_r < _r:
        ##         g       w 'r= tten of lftlisr crren x is b gger  han#gigh('s
te      #  #          if  yt == nhr o  (p_l <i _c andrr_y [p_l][0] <=!rxght[p_r][0])::
  #     #         #           eft_ycurr_y = _max_y
#       p_l +=#1
       u#n#elseifwe'reattheed f righliscrren is bigger than left's
 def ge#        #    i :
  #     #r        #       n = ight_y i_
      # #                #p_r += 1
      ex##maxheight(.e.y)beweenbhskylines
        ##         # two sy = max(lveotyright_
       #        re#sif m[x heigh0 is bigg,r 0]an curr]nt y,updteadcurr y
    acti#        for , hveur_y!=mx_y:
   ixte#                update_heapq.(ctimax_v)
        #          f:crr_y=mx_y

       #         return output

       i#f r-c
        