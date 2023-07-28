class Solution:
    def getPermutation(self, n: int, k: int) -> str:
        
        def fact(n):
            if n == 0:
                return 1
            return n * fact(n - 1)
        nums = [i for i in range(1, n + 1)]
        k -= 1
        res = []
        while n > 0:
            n -= 1
            index, k = divmod(k, fact(n))
            res.append(str(nums[index]))
            nums.pop(index)
        return "".join(res)