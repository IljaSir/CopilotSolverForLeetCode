class Solution:
    def judgePoint24(self, cards: List[int]) -> bool:
        
        def solve(nums):
            if len(nums) == 1:
                return abs(nums[0] - 24) < 0.001
            for i in range(len(nums)):
                for j in range(len(nums)):
                    if i == j:
                        continue
                    nxt = []
                    for k in range(len(nums)):
                        if k == i or k == j:
                            continue
                        nxt.append(nums[k])
                    for k in range(4):
                        if k < 2 and j > i:
                            continue
                        if k == 0:
                            nxt.append(nums[i] + nums[j])
                        elif k == 1:
                            nxt.append(nums[i] * nums[j])
                        elif k == 2:
                            nxt.append(nums[i] - nums[j])
                        elif k == 3:
                            if nums[j] != 0:
                                nxt.append(nums[i] / nums[j])
                        if solve(nxt):
                            return True
                        nxt.pop()
            return False
        return solve(cards)