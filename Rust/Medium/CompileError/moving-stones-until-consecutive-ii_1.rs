impl Solution {
    pub fn num_moves_stones_ii(stones: Vec<i32>) -> Vec<i32> {
        
        let mut stones = stones;
        stones.sort();
        let n = stones.len();
        let mut max = stones[n - 1] - stones[0] + 1 - n as i32;
        max -= std::cmp::min(stones[n - 2] - stones[0] + 1 - (n - 1) as i32, stones[n - 1] - stones[1] + 1 - (n - 1) as i32);
        let mut i = 0;
        let mut min = max;
        for j in 0..n {
            while stones[j] - stones[i] + 1 > n as i32 {
                i += 1;
            }
            let cnt = j - i + 1;
            if cnt == n - 1 && stones[j] - stones[i] + 1 == n as i32 - 1 {
                min = std::cmp::min(min, 2);
            } else {
                min = std::cmp::min(min, n as i32 - cnt);
            }
        }
        vec![min, max]
    }
}