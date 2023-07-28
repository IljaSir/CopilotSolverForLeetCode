class Solution:
    def numFriendRequests(self, ages: List[int]) -> int:
        
        # age[i] <= 0.5 * age[x] + 7
        # age[i] > age[x]
        # age[i] > 100 && age[x] < 100
        # x will send a request to y.
        # x != y
        # x will not send a friend request to a person y (x != y) if any of the following conditions is true:
        # age[y] <= 0.5 * age[x] + 7
        # age[y] > age[x]
        # age[y] > 100 && age[x] < 100
        # Otherwise, x will send a friend request to y.
        # Note that if x sends a request to y, y will not necessarily send a request to x. Also, a person will not send a friend request to themself.
        # Return the total number of friend requests made.
        # n == ages.length
        # 1 <= n <= 2 * 10^4
        # 1 <= ages[i] <= 120
        # ages = [16,16]
        # ages = [16,17,18]
        # ages = [20,30,100,110,120]
        # ages = [16,17,18,20,30,100,110,120]
        # ages = [16,17,18,20,30,100,110,120,100,110,120]
        # ages = [16,17,18,20,30,100,110,120,100,110,120,100,110,120]
        # ages = [16,17,18,20,30,100,110,120,100,110,120,100,110,120,100,110,120]
        # ages = [16,17,18,20,30,100,110,120,100,110,120,100,110,120,100,110,120,100,110,120]
        # age