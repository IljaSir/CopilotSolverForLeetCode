class Solution:
    def numberOfBeams(self, bank: List[str]) -> int:
        
        # print("bank: ", bank)
        rows = len(bank)
        cols = len(bank[0])
        num_beams = 0
        for col in range(cols):
            # print("col: ", col)
            for row in range(rows):
                # print("row: ", row)
                if bank[row][col] == "1":
                    # print("bank[row][col]: ", bank[row][col])
                    for row2 in range(row+1, rows):
                        # print("row2: ", row2)
                        if bank[row2][col] == "1":
                            # print("bank[row2][col]: ", bank[row2][col])
                            num_beams += 1
                            break
                        if "1" in bank[row2]:
                            # print("1 in bank[row2]: ", bank[row2])
                            break
        return num_beams