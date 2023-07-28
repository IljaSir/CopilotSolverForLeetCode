class Solution:
    def largestMultipleOfThree(self, digits: List[int]) -> str:
        
        mod = [0, 0, 0]
        for d in digits:
            mod[d % 3] += 1
        mod[1] %= 3
        mod[2] %= 3
        if mod[0] == 0:
            if mod[1] == 0 and mod[2] == 0:
                return ""
            elif mod[1] == 0:
                return ""
            elif mod[2] == 0:
                return ""
            elif mod[1] == 1:
                if mod[2] == 1:
                    return ""
                elif mod[2] == 2:
                    return ""
            elif mod[1] == 2:
                if mod[2] == 1:
                    return ""
                elif mod[2] == 2:
                    return ""
        else:
            if mod[1] == 0 and mod[2] == 0:
                return "".join([str(d) for d in sorted(digits, reverse=True)])
            elif mod[1] == 0:
                return "".join([str(d) for d in sorted(digits, reverse=True)])
            elif mod[2] == 0:
                return "".join([str(d) for d in sorted(digits, reverse=True)])
            elif mod[1] == 1:
                if mod[2] == 1:
                    return "".join([str(d) for d in sorted(digits, reverse=True)])
                elif mod[2] == 2:
                    return "".join([str(d) for d in sorted(digits, reverse=True)])
            elif mod[1] == 2:
                if mod[2] == 1:
                    return "".join([str(d) for d in sorted(digits, reverse=True)])
                elif mod[2] == 2:
                    return "".join([str(d) for d in sorted(digits, reverse=True)])