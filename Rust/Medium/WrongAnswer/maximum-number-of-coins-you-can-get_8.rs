impl Solution {
    pub fn max_coins(piles: Vec<i32>) -> i32 {
        
        let mut piles = piles;
        piles.sort();
        let mut result = 0;
        let mut i = 0;
        while i < piles.len() {
            result += piles[piles.len() - i - 2];
            i += 3;
        }
        result
    }
}