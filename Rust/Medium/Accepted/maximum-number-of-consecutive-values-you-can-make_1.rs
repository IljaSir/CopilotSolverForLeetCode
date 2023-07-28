impl Solution {
    pub fn get_maximum_consecutive(coins: Vec<i32>) -> i32 {
        
        let mut coins = coins;
        coins.sort();
        let mut max = 0;
        for c in coins {
            if c > max + 1 {
                break;
            }
            max += c;
        }
        max + 1
    }
}