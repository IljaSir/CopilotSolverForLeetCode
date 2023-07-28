class Solution:
    def countSmaller(self, nums: List[int]) -> List[int]:
        
        n = len(nums)
        sorted_nums = sorted(nums)
        index = {num: i for i, num in enumerate(sorted_nums)}
        bit = [0] * (n + 1)
        def update(i):
            while i <= n:
                bit[i] += 1
                i += i & -i
        def query(i):
            res = 0
            while i:
                res += bit[i]
                i -= i & -i
            return res
        res = []
        for num in nums[::-1]:
            res.append(query(index[num]))
            update(index[num] + 1)
        return res[::-1]