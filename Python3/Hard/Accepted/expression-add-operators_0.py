class Solution:
    def addOperators(self, num: str, target: int) -> List[str]:
        
        
        def backtrack(index, prev_operand, curr_operand, value, string):
            # Done processing all the digits in num
            if index == N:
                if value == target and curr_operand == 0:
                    output.append("".join(string[1:]))
                return

            # Extending the current operand by one digit
            curr_operand = curr_operand * 10 + int(num[index])
            str_op = str(curr_operand)

            # To avoid cases where we have 1 + 05 or 1 * 05 since 05 won't be a
            # valid operand. Hence this check
            if curr_operand > 0:
                # NO OP recursion
                backtrack(index + 1, prev_operand, curr_operand, value, string)

            # ADDITION
            string.append("+"); string.append(str_op)
            backtrack(index + 1, curr_operand, 0, value + curr_operand, string)
            string.pop(); string.pop()

            # Can subtract or multiply only if there are some previous operands
            if string:
                # SUBTRACTION
                string.append("-"); string.append(str_op)
                backtrack(index + 1, -curr_operand, 0, value - curr_operand, string)
                string.pop(); string.pop()

                # MULTIPLICATION
                string.append("*"); string.append(str_op)
                backtrack(index + 1, curr_operand * prev_operand, 0, value - prev_operand + (curr_operand * prev_operand), string)
                string.pop(); string.pop()

        N = len(num)
        output, string = [], []
        backtrack(0, 0, 0, 0, string)
        return output