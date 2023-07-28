class Solution:
    def numDifferentIntegers(self, word: str) -> int:
        
        # The first step is to replace all non-digits with spaces
        # Then, split the string into a list of strings
        # Then, convert each string to an integer
        # Then, remove duplicates
        # Then, return the length of the list
        return len(set([int(x) for x in word.replace("a"," ").replace("b"," ").replace("c"," ").replace("d"," ").replace("e"," ").replace("f"," ").replace("g"," ").replace("h"," ").replace("i"," ").replace("j"," ").replace("k"," ").replace("l"," ").replace("m"," ").replace("n"," ").replace("o"," ").replace("p"," ").replace("q"," ").replace("r"," ").replace("s"," ").replace("t"," ").replace("u"," ").replace("v"," ").replace("w"," ").replace("x"," ").replace("y"," ").replace("z"," ").split()]))