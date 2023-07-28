class Solution:
    def addToArrayForm(self, num: List[int], k: int) -> List[int]:
        
        # Solution 1 - 380 ms
        """
        return list(map(int, str(int(''.join(map(str, num))) + k)))
        """
        # Solution 2 - 352 ms
        num[-1] += k
        for i in range(len(num) - 1, -1, -1):
            if num[i] > 9:
                num[i] -= 10
                if i == 0:
                    num.insert(0, 1)
                else:
                    num[i - 1] += 1
        return num