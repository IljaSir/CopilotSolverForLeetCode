class Solution:
    def exclusiveTime(self, n: int, logs: List[str]) -> List[int]:
        
        
        stack = []
        res = [0] * n
        for log in logs:
            func_id, state, time = log.split(':')
            func_id = int(func_id)
            time = int(time)
            if state == 'start':
                stack.append((func_id, time))
            else:
                func_id, prev_time = stack.pop()
                res[func_id] += time - prev_time + 1
                if stack:
                    res[stack[-1][0]] -= time - prev_time + 1
        return res