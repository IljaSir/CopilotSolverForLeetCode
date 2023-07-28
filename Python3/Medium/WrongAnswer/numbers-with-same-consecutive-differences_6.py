class Solution:
    def numsSameConsecDiff(self, n: int, k: int) -> List[int]:
        
        # get all numbers of length n
        def get_nums(n, k):
            if n == 1:
                return list(range(10))
            nums = []
            for num in get_nums(n-1, k):
                last_digit = num % 10
                if last_digit < 10 - k:
                    nums.append(num*10 + last_digit + k)
                if last_digit >= k:
                    nums.append(num*10 + last_digit - k)
            return nums

        return [num for num in get_nums(n, k) if num > 9 or n == 1]