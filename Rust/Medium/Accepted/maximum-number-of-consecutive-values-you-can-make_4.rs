impl Solution {
    pub fn get_maximum_consecutive(coins: Vec<i32>) -> i32 {
        
        let mut coins = coins;
        coins.sort();
        let mut max = 0;
        for i in coins {
            if i > max + 1 {
                break;
            }
            max += i;
        }
        max + 1
    }
}