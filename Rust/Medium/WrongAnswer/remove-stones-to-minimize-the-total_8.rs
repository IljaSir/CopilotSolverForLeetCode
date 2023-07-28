impl Solution {
    pub fn min_stone_sum(piles: Vec<i32>, k: i32) -> i32 {
        
        let mut piles = piles;
        piles.sort_unstable_by(|a, b| b.cmp(a));
        let mut k = k;
        while k > 0 {
            let i = 0;
            let p = piles[i];
            piles[i] = (p + 1) / 2;
            k -= 1;
        }
        piles.iter().sum()
    }
}