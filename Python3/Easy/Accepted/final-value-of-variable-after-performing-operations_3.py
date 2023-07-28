class Solution:
    def finalValueAfterOperations(self, operations: List[str]) -> int:
        
        result = 0
        for operation in operations:
            if operation[1] == '+':
                result += 1
            else:
                result -= 1
        return result