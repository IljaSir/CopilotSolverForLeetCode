impl Solution {
    pub fn num_moves_stones(a: i32, b: i32, c: i32) -> Vec<i32> {
        
        let mut stones = vec![a, b, c];
        stones.sort();
        let min = if stones[0] + 1 == stones[1] && stones[1] + 1 == stones[2] {
            0
        } else if stones[0] + 1 == stones[1] || stones[1] + 1 == stones[2] {
            1
        } else {
            2
        };
        let max = stones[2] - stones[0] - 2;
        vec![min, max]
    }
}