impl Solution {
    pub fn get_maximum_consecutive(coins: Vec<i32>) -> i32 {
        
        let mut coins = coins;
        coins.sort();
        let mut res = 0;
        for i in coins {
            if i > res + 1 {
                break;
            }
            res += i;
        }
        res + 1
    }
}