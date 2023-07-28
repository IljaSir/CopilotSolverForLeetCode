class Solution:
    def minCharacters(self, a: str, b: str) -> int:
        
        # print(a, b)
        # print(a.count("a"), b.count("a"))
        # print(a.count("b"), b.count("b"))
        # print(a.count("c"), b.count("c"))
        # print(a.count("d"), b.count("d"))
        # print(a.count("e"), b.count("e"))
        # print(a.count("f"), b.count("f"))
        # print(a.count("g"), b.count("g"))
        # print(a.count("h"), b.count("h"))
        # print(a.count("i"), b.count("i"))
        # print(a.count("j"), b.count("j"))
        # print(a.count("k"), b.count("k"))
        # print(a.count("l"), b.count("l"))
        # print(a.count("m"), b.count("m"))
        # print(a.count("n"), b.count("n"))
        # print(a.count("o"), b.count("o"))
        # print(a.count("p"), b.count("p"))
        # print(a.count("q"), b.count("q"))
        # print(a.count("r"), b.count("r"))
        # print(a.count("s"), b.count("s"))
        # print(a.count("t"), b.count("t"))
        # print(a.count("u"), b.count("u"))
        # print(a.count("v"), b.count("v"))
        # print(a.count("w"), b.count("w"))
        # print(a.count("x"), b.count("x"))
        # print(a.count("y"), b.count("y"))
        # print(a.count("z"), b.count("z"))
        # return 0
        # 1. Every letter in a is strictly less than every letter in b in the alphabet.
        # 2. Every letter in b is strictly less than every letter in a in the alphabet.
        # 3. Both a and b consist of only one distinct letter.
        # return min([a.count("a"), b.count("a")]) + min([a.count("b"), b.count("b")]) + min([a.count("c"), b.count("c")]) + min([a.count("d"), b.count("d")]) + min([a.count("e"), b.count("e")]) + min([a.count("f"), b.count("f")]) + min([a