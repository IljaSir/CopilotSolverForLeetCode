class Solution:
    def interpret(self, command: str) -> str:
        
        # print(command)
        return command.replace("()","o").replace("(al)","al")