class Solution:
    def maximumNumber(self, num: str, change: List[int]) -> str:
        
        num = list(num)
        for i, n in enumerate(num):
            if int(n) < change[int(n)]:
                num[i] = str(change[int(n)])
                break
        for j in range(i+1, len(num)):
            if int(num[j]) > change[int(num[j])]:
                break
            else:
                num[j] = str(change[int(num[j])])
        return ''.join(num)