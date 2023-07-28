class Solution:
    def slidingPuzzle(self, board: List[List[int]]) -> int:
        
        # BFS
        # 1. get the initial state
        # 2. BFS
        # 3. return the number of steps
        # 4. if no solution, return -1
        # 5. if the initial state is the final state, return 0
        # 6. if the initial state is not the final state, return the number of steps
        # 7. if the final state is not reachable, return -1
        # 8. if the initial state is not reachable, return -1
        # 9. if the initial state is reachable, return the number of steps
        # 10. if the final state is reachable, return the number of steps
        # 11. if the initial state is reachable and the final state is reachable, return the number of steps
        # 12. if the initial state is not reachable and the final state is not reachable, return -1
        # 13. if the initial state is reachable and the final state is not reachable, return the number of steps
        # 14. if the initial state is not reachable and the final state is reachable, return -1
        # 15. if the initial state is reachable and the final state is reachable, return the number of steps
        # 16. if the initial state is reachable and the final state is reachable, return the number of steps
        # 17. if the initial state is reachable and the final state is not reachable, return the number of steps
        # 18. if the initial state is not reachable and the final state is reachable, return -1
        # 19. if the initial state is reachable and the final state is reachable, return the number of steps
        # 20. if the initial state is not reachable and the final state is not reachable, return -1
        # 21. if the initial state is reachable and the final state is reachable, return the number of steps
        # 22. if the initial state is reachable and the final state is reachable, return the number of steps
        # 23. if the initial state is reachable and the final state is reachable, return the number of steps
        # 24. if the initial state is reachable and the final state is reachable, return the number of steps
        # 25. if the initial state