impl Solution {
    pub fn max_jump(stones: Vec<i32>) -> i32 {
        
        let mut dp: Vec<Vec<i32>> = vec![vec![0; stones.len()]; stones.len()];
        let mut max = 0;
        for i in 0..stones.len() {
            for j in 0..stones.len() {
                if i == j {
                    continue;
                }
                let diff = (stones[i] - stones[j]).abs();
                if diff > dp[i][j] {
                    dp[i][j] = diff;
                    if max < diff {
                        max = diff;
                    }
                }
            }
        }
        max
    }
}