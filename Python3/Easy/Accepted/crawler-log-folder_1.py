class Solution:
    def minOperations(self, logs: List[str]) -> int:
        
        current_folder = 0
        for log in logs:
            if log == "../":
                current_folder = max(0, current_folder - 1)
            elif log == "./":
                pass
            else:
                current_folder += 1
        return current_folder