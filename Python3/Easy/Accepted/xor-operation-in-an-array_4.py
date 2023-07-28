class Solution:
    def xorOperation(self, n: int, start: int) -> int:
        
        nums = []
        for i in range(n):
            nums.append(start + 2 * i)
        xor = 0
        for num in nums:
            xor ^= num
        return xor