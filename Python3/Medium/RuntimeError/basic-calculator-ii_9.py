class Solution:
    def calculate(self, s: str) -> int:
        
def calculate(self, s: str= -> int:
        
        # 1. get rid of all spaces
        s = s.replace(' ', '')
        
        # 2. convert string to list of operators and numbers
        # 3. add + sign in front of the first number
        # 4. add + sign after each operator
        # 5. convert string to list of operators and numbers
        s = s.replace('+', ' +').replace('-', ' -').replace('*', ' *').replace('/', ' /')
        s = s.split()
        
        # 6. convert all numbers to integers
        for i in range(len(s)):
            if s[i].isdigit():
                s[i] = int(s[i])
        
        # 7. calculate * and / first
        i = 0
        while i < len(s):
            if s[i] == '*':
                s[i-1] = s[i-1] * s[i+1]
                s.pop(i)
                s.pop(i)
            elif s[i] == '/':
                s[i-1] = s[i-1] // s[i+1]
                s.pop(i)
                s.pop(i)
            else:
                i += 1
        
        # 8. calculate + and -
        i = 0
        while i < len(s):
            if s[i] == '+':
                s[i-1] = s[i-1] + s[i+1]
                s.pop(i)
                s.pop(i)
            elif s[i] == '-':
                s[i-1] = s[i-1] - s[i+1]
                s.pop(i)
                s.pop(i)
            else:
                i += 1
        
        # 9. return the only number in the list
        return s[0]= '+':
                ans += stack[i+1]
            else:
                ans -= stack[i+1]
        return ans