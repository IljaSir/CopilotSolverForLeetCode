impl Solution {
    pub fn max_coins(piles: Vec<i32>) -> i32 {
        
        let mut piles = piles;
        piles.sort();
        let mut res = 0;
        let mut i = 0;
        let mut j = piles.len() - 2;
        while i < j {
            res += piles[j];
            i += 1;
            j -= 2;
        }
        res
    }
}