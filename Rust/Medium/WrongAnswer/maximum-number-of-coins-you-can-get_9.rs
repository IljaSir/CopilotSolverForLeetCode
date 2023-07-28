impl Solution {
    pub fn max_coins(piles: Vec<i32>) -> i32 {
        
        let mut piles = piles;
        piles.sort();
        let n = piles.len();
        let mut res = 0;
        for i in (0..n).step_by(3) {
            res += piles[n - 1 - i - 1];
        }
        res
    }
}