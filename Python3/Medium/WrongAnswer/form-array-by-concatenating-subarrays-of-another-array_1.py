class Solution:
    def canChoose(self, groups: List[List[int]], nums: List[int]) -> bool:
        
        # @param groups: List[List[int]]
        # @param nums: List[int]
        # @return: bool
        n = len(groups)
        m = len(nums)
        i = 0
        j = 0
        while i < n and j < m:
            if nums[j] == groups[i][0]:
                k = 0
                while k < len(groups[i]) and j < m:
                    if nums[j] != groups[i][k]:
                        break
                    j += 1
                    k += 1
                if k == len(groups[i]):
                    i += 1
                else:
                    j -= k
            j += 1
        return i == n