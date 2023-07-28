impl Solution {
    pub fn max_coins(piles: Vec<i32>) -> i32 {
        
        let mut piles = piles;
        piles.sort();
        let mut res = 0;
        let mut i = 0;
        while i < piles.len() {
            res += piles[piles.len() - 2 - i];
            i += 1;
        }
        res
    }
}