class Solution:
    def makeSimilar(self, nums: List[int], target: List[int]) -> int:
        
        n = len(nums)
        diff = [0] * n
        for i in range(n):
            diff[i] = nums[i] - target[i]
        diff.sort()
        # print(diff)
        res = 0
        i, j = 0, n-1
        while i < j:
            if diff[i] + diff[j] == 0:
                res += 1
                i += 1
                j -= 1
            elif diff[i] + diff[j] > 0:
                j -= 1
            else:
                i += 1
        return res