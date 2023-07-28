class Solution:
    def topKFrequent(self, nums: List[int], k: int) -> List[int]:
        
        if len(nums) <= 1:
            return nums
        dic = {}
        for num in nums:
            if num in dic:
                dic[num] += 1
            else:
                dic[num] = 1
        res = []
        for i in range(k):
            max_num = max(dic, key=dic.get)
            res.append(max_num)
            dic.pop(max_num)
        return res