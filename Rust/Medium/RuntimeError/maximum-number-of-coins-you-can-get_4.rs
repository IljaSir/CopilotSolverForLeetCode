impl Solution {
    pub fn max_coins(piles: Vec<i32>) -> i32 {
        
        let mut piles = piles;
        piles.sort();
        let mut sum = 0;
        let mut i = 0;
        let mut j = piles.len() - 2;
        while i < j {
            sum += piles[j];
            i += 1;
            j -= 2;
        }
        sum
    }
}