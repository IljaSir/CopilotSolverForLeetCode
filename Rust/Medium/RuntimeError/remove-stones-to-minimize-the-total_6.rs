impl Solution {
    pub fn min_stone_sum(piles: Vec<i32>, k: i32) -> i32 {
        
        let mut piles = piles;
        piles.sort();
        let mut k = k;
        let mut i = 0;
        while k > 0 {
            let j = piles.len() - 1 - i;
            piles[j] -= piles[j] / 2;
            i += 1;
            k -= 1;
        }
        piles.iter().sum()
    }
}