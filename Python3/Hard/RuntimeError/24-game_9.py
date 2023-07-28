class Solution:
    def judgePoint24(self, cards: List[int]) -> bool:
        
        # 4 cards, 3 ops, 3! = 6 ways to insert ops
        # 6 ways to insert 3 ops, 5 ways to insert 2 ops, 4 ways to insert 1 op
        # 4! = 24 ways to insert 4 ops
        # 24 ways to insert 4 ops, 23 ways to insert 3 ops, 22 ways to insert 2 ops, 21 ways to insert 1 op
        # 24 * 23 * 22 * 21 = 166,320 ways to insert 4 ops
        # 166,320 ways to insert 4 ops, 166,319 ways to insert 3 ops, 166,318 ways to insert 2 ops, 166,317 ways to insert 1 op
        # 166,320 * 166,319 * 166,318 * 166,317 = 27,252,480,000 ways to insert 4 ops
        # 27,252,480,000 ways to insert 4 ops, 27,252,479,999 ways to insert 3 ops, 27,252,479,998 ways to insert 2 ops, 27,252,479,997 ways to insert 1 op
        # 27,252,480,000 * 27,252,479,999 * 27,252,479,998 * 27,252,479,997 = 7,402,012,199,680,000,000 ways to insert 4 ops
        # 7,402,012,199,680,000,000 ways to insert 4 ops, 7,402,012,199,679,999,999 ways to insert 3 ops, 7,402,012,199,679,999,998 ways to insert 2 ops, 7,402,012,199,679,999,997 ways to insert 1 op
        # 7,402,012,199,680,000,000 * 7,402,012,199,679,999,999 * 7,402,012,199,679,999,998 * 7,402,012,199,679,999,997 = 5,461,390,734,016,000,000,000,000, 1:
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