impl Solution {
    pub fn get_maximum_consecutive(coins: Vec<i32>) -> i32 {
        
        let mut coins = coins;
        coins.sort();
        let mut res = 0;
        for c in coins {
            if c > res + 1 {
                break;
            }
            res += c;
        }
        res + 1
    }
}