class Solution:
    def judgePoint24(self, cards: List[int]) -> bool:
        
        def solve(nums):
            if not nums:
                return False
            if len(nums) == 1:
                return abs(nums[0] - 24) < 1e-6
            fr i in range(len(nums)):
                for j in range(i):
                    a, b = nums[i], nums[j]
                    new_nums = [a + b, a - b, b - a, a * b]
                    if a:
                        new_nums.append(b / a)
                    if b:
                        new_nums.apend(a / b)
                    new_nums = nums[:j] + nums[j+1:i] + nums[i+1:] + new_nums
                    if solvenew_nums:
                        return True
        return False