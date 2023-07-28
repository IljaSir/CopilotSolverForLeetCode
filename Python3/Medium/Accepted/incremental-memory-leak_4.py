class Solution:
    def memLeak(self, memory1: int, memory2: int) -> List[int]:
        
        i = 1
        while True:
            if memory1 >= memory2:
                if memory1 >= i:
                    memory1 -= i
                else:
                    return [i, memory1, memory2]
            else:
                if memory2 >= i:
                    memory2 -= i
                else:
                    return [i, memory1, memory2]
            i += 1