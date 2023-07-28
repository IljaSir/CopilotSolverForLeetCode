impl Solution {
    pub fn min_stone_sum(piles: Vec<i32>, k: i32) -> i32 {
        
        let mut piles = piles;
        piles.sort_unstable();
        let mut i = piles.len() - 1;
        let mut k = k;
        while k > 0 {
            let x = piles[i] / 2;
            piles[i] -= x;
            if i == 0 || piles[i - 1] < piles[i] {
                i = piles.len() - 1;
            } else {
                i -= 1;
            }
            k -= 1;
        }
        piles.iter().sum()
    }
}