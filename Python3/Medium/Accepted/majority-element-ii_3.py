class Solution:
    def majorityElement(self, nums: List[int]) -> List[int]:
        
        dic = {}
        res = []
        for num in nums:
            if num in dic:
                dic[num] += 1
            else:
                dic[num] = 1
        for key in dic:
            if dic[key] > len(nums) // 3:
                res.append(key)
        return res