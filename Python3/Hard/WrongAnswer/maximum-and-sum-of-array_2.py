class Solution:
    def maximumANDSum(self, nums: List[int], numSlots: int) -> int:
        
        nums.sort(reverse=True)
        ans = 0
        for i in range(2**numSlots):
            b = "{0:b}".format(i).zfill(numSlots)
            tmp = 0
            for j in range(numSlots):
                if b[j] == '0':
                    continue
                tmp += nums[j]
            ans = max(ans, tmp)
        return ans