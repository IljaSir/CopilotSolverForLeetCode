impl Solution {
    pub fn min_stone_sum(piles: Vec<i32>, k: i32) -> i32 {
        
        let mut piles = piles;
        let mut k = k;
        piles.sort_unstable();
        let mut i = 0;
        let mut j = piles.len() - 1;
        while k > 0 {
            let mid = piles[j] / 2;
            piles[j] -= mid;
            if piles[j] == 0 {
                j -= 1;
            }
            k -= 1;
        }
        piles.iter().sum()
    }
}