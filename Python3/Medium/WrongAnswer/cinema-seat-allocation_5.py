class Solution:
    def maxNumberOfFamilies(self, n: int, reservedSeats: List[List[int]]) -> int:
        
        # 1. Sort reservedSeats
        # 2. Count number of 4 person groups
        # 3. Return count
        reservedSeats.sort(key=lambda x: x[0])
        count = 0
        prev_row = 0
        prev_seat = 0
        for row, seat in reservedSeats:
            if row == prev_row:
                if prev_seat <= seat - 4 and seat <= 6:
                    count += 1
                    prev_seat = seat
                elif prev_seat <= seat - 4 and seat >= 7:
                    count += 1
                    prev_seat = seat
                elif seat >= 7 and seat <= 10 and prev_seat > 4:
                    count += 1
                    prev_seat = seat
                elif seat >= 7 and seat <= 10 and prev_seat <= 4:
                    count += 1
                    prev_seat = seat
                elif seat >= 7 and seat <= 10 and prev_seat == 0:
                    count += 1
                    prev_seat = seat
            else:
                count += 2
                prev_row = row
                prev_seat = seat
        count += 2 * (n - len(reservedSeats))
        return count