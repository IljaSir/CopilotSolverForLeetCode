class Solution:
    def checkSubarraySum(self, nums: List[int], k: int) -> bool:
        
        pre = 0
        map = {0: -1}
        for i, n in enumerate(nums):
            pre += n
            if k != 0:
                pre %= k
            if pre in map:
                if i - map[pre] > 1:
                    return True
            else:
                map[pre] = i
        return False