impl Solution {
    pub fn max_coins(piles: Vec<i32>) -> i32 {
        
        let mut piles = piles;
        piles.sort_unstable();
        let mut i = 0;
        let mut j = piles.len() - 2;
        let mut sum = 0;
        while i < j {
            sum += piles[j];
            i += 1;
            j -= 2;
        }
        sum
    }
}