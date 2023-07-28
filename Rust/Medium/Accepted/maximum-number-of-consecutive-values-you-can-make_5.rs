impl Solution {
    pub fn get_maximum_consecutive(coins: Vec<i32>) -> i32 {
        
        let mut coins = coins;
        coins.sort();
        let mut max = 0;
        for coin in coins {
            if coin > max + 1 {
                break;
            } else {
                max += coin;
            }
        }
        max + 1
    }
}