class Solution:
    def isValid(self, s: str) -> bool:
        
        # This is a stack problem.
        # The stack will be a list.
        # The stack will contain characters.
        # The stack will be initialized to an empty list.
        stack = []
        # Iterate through each character in the string.
        for character in s:
            # If the character is a left parenthesis.
            if character == "(" or character == "[" or character == "{":
                # Push the character onto the stack.
                stack.append(character)
            # Otherwise, the character is a right parenthesis.
            else:
                # If the stack is empty.
                if len(stack) == 0:
                    # Return False.
                    return False
                # Otherwise, the stack is not empty.
                else:
                    # Pop the top character from the stack.
                    top_character = stack.pop()
                    # If the top character is a left parenthesis.
                    if top_character == "(":
                        # If the character is not a right parenthesis.
                        if character != ")":
                            # Return False.
                            return False
                    # Otherwise, the top character is a left bracket.
                    elif top_character == "[":
                        # If the character is not a right bracket.
                        if character != "]":
                            # Return False.
                            return False
                    # Otherwise, the top character is a left brace.
                    else:
                        # If the character is not a right brace.
                        if character != "}":
                            # Return False.
                            return False
        # If the stack is empty.
        if len(stack) == 0:
            # Return True.
            return True
        # Otherwise, the stack is not empty.
        else:
            # Return False.
            return False