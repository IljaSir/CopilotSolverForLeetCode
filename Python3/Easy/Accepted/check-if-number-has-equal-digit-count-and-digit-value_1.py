class Solution:
    def digitCount(self, num: str) -> bool:
        
        # for i in range(len(num)):
        #     if num.count(str(i)) != int(num[i]):
        #         return False
        # return True
        return all(num.count(str(i)) == int(num[i]) for i in range(len(num)))