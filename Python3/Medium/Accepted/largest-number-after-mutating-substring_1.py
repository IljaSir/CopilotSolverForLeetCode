class Solution:
    def maximumNumber(self, num: str, change: List[int]) -> str:
        
        num = list(num)
        i = 0
        while i < len(num):
            if change[int(num[i])] > int(num[i]):
                break
            i += 1
        for j in range(i, len(num)):
            if change[int(num[j])] < int(num[j]):
                break
            num[j] = str(change[int(num[j])])
        return ''.join(num)