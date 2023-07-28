class Solution:
    def exclusiveTime(self, n: int, logs: List[str]) -> List[int]:
        
        
        stack = []
        res = [0] * n
        prev = 0
        
        for log in logs:
            id, status, time = log.split(':')
            id = int(id)
            time = int(time)
            
            if status == 'start':
                if stack:
                    res[stack[-1]] += time - prev
                stack.append(id)
                prev = time
            else:
                res[stack.pop()] += time - prev + 1
                prev = time + 1
                
        return res