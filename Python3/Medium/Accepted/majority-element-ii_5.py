class Solution:
    def majorityElement(self, nums: List[int]) -> List[int]:
        
        n = len(nums)
        if n == 0:
            return []
        if n == 1:
            return nums
        m1 = nums[0]
        m2 = nums[0]
        c1 = 0
        c2 = 0
        for i in range(n):
            if nums[i] == m1:
                c1 += 1
            elif nums[i] == m2:
                c2 += 1
            elif c1 == 0:
                m1 = nums[i]
                c1 += 1
            elif c2 == 0:
                m2 = nums[i]
                c2 += 1
            else:
                c1 -= 1
                c2 -= 1
        c1 = 0
        c2 = 0
        for i in range(n):
            if nums[i] == m1:
                c1 += 1
            elif nums[i] == m2:
                c2 += 1
        res = []
        if c1 > n//3:
            res.append(m1)
        if c2 > n//3:
            res.append(m2)
        return res