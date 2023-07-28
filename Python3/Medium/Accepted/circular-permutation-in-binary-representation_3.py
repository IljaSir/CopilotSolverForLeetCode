class Solution:
    def circularPermutation(self, n: int, start: int) -> List[int]:
        def grayCode(n):
            if n == 0:
                return [0]
            if n == 1:
                return [0, 1]
            prev = grayCode(n - 1)
            return prev + [2 ** (n - 1) + x for x in prev[::-1]]
        gray_code = grayCode(n)
        start_index = gray_code.index(start)
        return gray_code[start_index:] + gray_code[:start_index]