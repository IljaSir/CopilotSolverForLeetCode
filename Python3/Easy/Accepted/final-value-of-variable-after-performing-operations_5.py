class Solution:
    def finalValueAfterOperations(self, operations: List[str]) -> int:
        
        x = 0
        for op in operations:
            if op[:2] == '++':
                x += 1
            elif op[:2] == '--':
                x -= 1
            elif op[-2:] == '++':
                x += 1
            elif op[-2:] == '--':
                x -= 1
        return x