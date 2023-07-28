class Solution:
    def selfDividingNumbers(self, left: int, right: int) -> List[int]:
        
        # 1st solution
        # result = []
        # for i in range(left, right + 1):
        #     if self.is_self_dividing_number(i):
        #         result.append(i)
        # return result
        # 2nd solution
        return [i for i in range(left, right + 1) if self.is_self_dividing_number(i)]