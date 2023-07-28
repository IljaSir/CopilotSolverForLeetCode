impl Solution {
    pub fn num_moves_stones(a: i32, b: i32, c: i32) -> Vec<i32> {
        
        let mut stones = vec![a, b, c];
        stones.sort();
        let a = stones[0];
        let b = stones[1];
        let c = stones[2];
        let mut min_moves = 0;
        if b - a > 1 {
            min_moves += 1;
        }
        if c - b > 1 {
            min_moves += 1;
        }
        if b - a == 2 || c - b == 2 {
            min_moves = 1;
        }
        let max_moves = c - a - 2;
        vec![min_moves, max_moves]
    }
}