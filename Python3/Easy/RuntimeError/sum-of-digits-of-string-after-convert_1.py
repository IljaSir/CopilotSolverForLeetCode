class Solution:
    def getLucky(self, s: str, k: int) -> int:
        
        # Convert s into an integer by replacing each letter with its position in the alphabet (i.e., replace 'a' with 1, 'b' with 2, ..., 'z' with 26). 
        # Then, transform the integer by replacing it with the sum of its digits. 
        # Repeat the transform operation k times in total.
        # 1 <= s.length <= 100
        # 1 <= k <= 10
        # s consists of lowercase English letters.
        # Convert: "zbax" ➝ "(26)(2)(1)(24)" ➝ "262124" ➝ 262124
        # Transform #1: 262124 ➝ 2 + 6 + 2 + 1 + 2 + 4 ➝ 17
        # Transform #2: 17 ➝ 1 + 7 ➝ 8
        # Return the resulting integer after performing the operations described above.
        # ord('a') = 97
        # ord('z') = 122
        # ord('a') - ord('a') + 1 = 1
        # ord('z') - ord('a') + 1 = 26
        # ord('b') - ord('a') + 1 = 2
        # ord('y') - ord('a') + 1 = 25
        # ord('c') - ord('a') + 1 = 3
        # ord('x') - ord('a') + 1 = 24
        # ord('d') - ord('a') + 1 = 4
        # ord('w') - ord('a') + 1 = 23
        # ord('e') - ord('a') + 1 = 5
        # ord('v') - ord('a') + 1 = 22
        # ord('f') - ord('a') + 1 = 6
        # ord('u') - ord('a') + 1 = 21
        # ord('g') - ord('a') + 1 = 7
        # ord('t') - ord('a') + 1 = 20
        # ord('h') - ord('a') + 1 = 8
        # ord('s') -