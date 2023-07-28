class Solution:
    def exclusiveTime(self, n: int, logs: List[str]) -> List[int]:
        
        
        stack = []
        prev_time = 0
        res = [0] * n
        for log in logs:
            function_id, event, timestamp = log.split(':')
            function_id, timestamp = int(function_id), int(timestamp)
            if event == 'start':
                if stack:
                    res[stack[-1]] += timestamp - prev_time
                stack.append(function_id)
                prev_time = timestamp
            else:
                res[stack.pop()] += timestamp - prev_time + 1
                prev_time = timestamp + 1
        return res