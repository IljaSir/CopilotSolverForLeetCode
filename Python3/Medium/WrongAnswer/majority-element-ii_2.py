class Solution:
    def majorityElement(self, nums: List[int]) -> List[int]:
        
        n = len(nums)
        if n < 2:
            return nums
        count1, count2, candidate1, candidate2 = 0, 0, 0, 1
        for num in nums:
            if num == candidate1:
                count1 += 1
            elif num == candidate2:
                count2 += 1
            elif count1 == 0:
                candidate1, count1 = num, 1
            elif count2 == 0:
                candidate2, count2 = num, 1
            else:
                count1, count2 = count1 - 1, count2 - 1
        return [n for n in (candidate1, candidate2) if nums.count(n) > n // 3]