impl Solution {
    pub fn min_stone_sum(piles: Vec<i32>, k: i32) -> i32 {
        
        let mut piles = piles;
        for _ in 0..k {
            let mut max = 0;
            let mut max_idx = 0;
            for i in 0..piles.len() {
                if piles[i] > max {
                    max = piles[i];
                    max_idx = i;
                }
            }
            piles[max_idx] -= max / 2;
        }
        piles.iter().sum()
    }
}