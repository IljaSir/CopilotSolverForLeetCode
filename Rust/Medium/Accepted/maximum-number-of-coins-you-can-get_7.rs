impl Solution {
    pub fn max_coins(piles: Vec<i32>) -> i32 {
        
        let mut piles = piles;
        piles.sort();
        let mut res = 0;
        let mut idx = piles.len() - 2;
        for _ in 0..piles.len() / 3 {
            res += piles[idx];
            idx -= 2;
        }
        res
    }
}