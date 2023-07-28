impl Solution {
    pub fn min_stone_sum(piles: Vec<i32>, k: i32) -> i32 {
        
        let mut piles = piles;
        for _ in 0..k {
            piles.sort();
            piles[piles.len() - 1] -= piles[piles.len() - 1] / 2;
        }
        piles.iter().sum()
    }
}