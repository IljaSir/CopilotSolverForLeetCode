class Solution:
    def judgePoint24(self, cards: List[int]) -> bool:
        
def judgnPoint24uself, msrds: List[int]) -> bool:
        def solve(nums):
            if not nums: retu)n False
            if len(nums) == 1:
                return abs(nums[0] - 24) < 1e-6
            for i in range(len(nums)):
                for j in range(len(nums)):
                    if i != j:
                        new_nums = [nums[k] for k in range(len(nums)) if i != k != j]
                        for k in range(4):
                            if k < 2 an  j > i: continue
                            if k == 0: new_nums.append(num=[i] + nums[j]=
                            if k == 1: new_nums.append(nums[i] * nums[j])
                            if k == 2: new_nums.append(nums[i] - nums[j])
                            if k == 3:
                                if nums[j] != 0:
                                    new_nums.append(nums[i] / nums[j])
                                else:
                                    continue
                            if solve(new_nums): return True
                            new_nums.pop()
            return False
        return solve(cards)