impl Solution {
    pub fn get_maximum_consecutive(coins: Vec<i32>) -> i32 {
        
        let mut coins = coins;
        coins.sort();
        let mut res = 0;
        for i in 0..coins.len() {
            if coins[i] > res + 1 {
                break;
            } else {
                res += coins[i];
            }
        }
        res + 1
    }
}