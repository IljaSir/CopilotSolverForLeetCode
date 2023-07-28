class Solution:
    def equationsPossible(self, equations: List[str]) -> bool:
        
        # Create a dict of sets to store all the equalities
        equalities = {}
        # Create a dict of sets to store all the inequalities
        inequalities = {}
        # Iterate over the list of equations
        for equation in equations:
            # If the equation is an equality
            if equation[1] == "=":
                # If the first variable is not in the equalities dict
                if equation[0] not in equalities:
                    # Add it to the dict with an empty set
                    equalities[equation[0]] = set()
                # If the second variable is not in the equalities dict
                if equation[3] not in equalities:
                    # Add it to the dict with an empty set
                    equalities[equation[3]] = set()
                # Add the second variable to the set of the first variable
                equalities[equation[0]].add(equation[3])
                # Add the first variable to the set of the second variable
                equalities[equation[3]].add(equation[0])
            # If the equation is an inequality
            else:
                # If the first variable is not in the inequalities dict
                if equation[0] not in inequalities:
                    # Add it to the dict with an empty set
                    inequalities[equation[0]] = set()
                # If the second variable is not in the inequalities dict
                if equation[3] not in inequalities:
                    # Add it to the dict with an empty set
                    inequalities[equation[3]] = set()
                # Add the second variable to the set of the first variable
                inequalities[equation[0]].add(equation[3])
                # Add the first variable to the set of the second variable
                inequalities[equation[3]].add(equation[0])
        # Iterate over the equalities dict
        for key, value in equalities.items():
            # Iterate over the set of equalities of the current variable
            for variable in value:
                # If the variable is in the inequalities dict
                if variable in inequalities:
                    # If the current variable is in the set of inequalities of the current variable
                    if key in inequalities[variable]:
                        # Return false
                        return False
        # Return true
        return True