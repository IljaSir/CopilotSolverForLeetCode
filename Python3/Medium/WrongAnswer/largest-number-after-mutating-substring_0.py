class Solution:
    def maximumNumber(self, num: str, change: List[int]) -> str:
        
        result = []
        i = 0
        while i < len(num):
            if int(num[i]) < change[int(num[i])]:
                while i < len(num) and int(num[i]) <= change[int(num[i])]:
                    result.append(str(change[int(num[i])]))
                    i += 1
            else:
                result.append(num[i])
                i += 1
        return ''.join(result)