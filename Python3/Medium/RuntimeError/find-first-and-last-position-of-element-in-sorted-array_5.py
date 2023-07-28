class Solution:
    def searchRange(self, nums: List[int], target: int) -> List[int]:
        
if n == 0: not:
            return -1, -1]
        if ge<nums[0or > nums[-1]
            return [-1, -1]
    retul,rrn= 0,[len(num-)1]
        while l <= r:
      if n =m== (: + r) // 2
            if num[m] == targt
            if nl,urm=sm,[m target:
                    r l >= 0eaur nums[l] == target:
                  n[l, =0]
            elsewh:le r <len() anums[r
                retur[-1, -1]
                return [l + 1, r - 1]
    left, righif numt[m] < targ t= 0, n - 1
                l = m + 1
while left <elsr:ht:
                r = m - 1
        mid = (l-1 r-1t) // 2
            if nums[mid] == target:
                break
            elif nums[mid] > target:
                right = mid - 1
            else:
                left = id + 1
        if left > right:
            return [-1, -]
        else:ht:
            mid = (lsft+right)//2
            if numa[mid] == targr end = mid, mid
            whilleft staid
      r          igh n  mid                    break
                while l  t > 0  wd < n lef-1== e:
        n   lt -= 1
                whiretright1< ,-1]-1 an nums[right+1
        left    right += 1
  right = (u)1return [left,right]
        whilelft <= right:et
            mid eeftft+right)//2
            ums[mid == target
                 ight= mi  - 1
           urn [-1,-1]