class Solution:
    def countSmaller(self, nums: List[int]) -> List[int]:
        
        res = []
        for i in range(len(nums)):
            count = 0
            for j in range(i+1, len(nums)):
                if nums[j] < nums[i]:
                    count += 1
            res.append(count)
        return res