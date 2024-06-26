impl Solution {
    pub fn max_coins(piles: Vec<i32>) -> i32 {
        
        let mut piles = piles;
        piles.sort();
        let mut ans = 0;
        let mut i = piles.len() - 2;
        while i >= piles.len() / 3 {
            ans += piles[i];
            i -= 2;
        }
        ans
    }
}