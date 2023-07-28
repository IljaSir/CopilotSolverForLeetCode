impl Solution {
    pub fn min_stone_sum(piles: Vec<i32>, k: i32) -> i32 {
        
        let mut piles = piles;
        let mut k = k;
        while k > 0 {
            let mut max = 0;
            let mut max_idx = 0;
            for (idx, pile) in piles.iter().enumerate() {
                if *pile > max {
                    max = *pile;
                    max_idx = idx;
                }
            }
            piles[max_idx] -= max / 2;
            k -= 1;
        }
        piles.iter().sum()
    }
}