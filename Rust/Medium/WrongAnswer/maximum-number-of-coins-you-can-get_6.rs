impl Solution {
    pub fn max_coins(piles: Vec<i32>) -> i32 {
        
        let mut piles = piles;
        piles.sort_by(|a, b| b.cmp(a));
        let mut i = 1;
        let mut sum = 0;
        while i < piles.len() {
            sum += piles[i];
            i += 2;
        }
        sum
    }
}