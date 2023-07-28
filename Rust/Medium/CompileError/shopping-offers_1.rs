impl Solution {
    pub fn shopping_offers(price: Vec<i32>, special: Vec<Vec<i32>>, needs: Vec<i32>) -> i32 {
        

        let mut dp = vec![0; 1 << price.len()];
        for i in 1..(1 << price.len()) {
            dp[i] = i32::max_value();
            for j in 0..price.len() {
                if (i & (1 << j)) > 0 {
                    let prev = i & !(1 << j);
                    dp[i] = dp[i].min(dp[prev] + price[j]);
                }
            }
            for offer in &special {
                let mut valid = true;
                let mut next = i;
                for j in 0..price.len() {
                    if offer[j] > needs[j] || offer[j] > (i >> j) & 1 {
                        valid = false;
                        break;
                    }
                    next -= (offer[j] << j) as i32;
                }
                if valid {
                    dp[i] = dp[i].min(dp[next as usize] + offer[price.len()]);
                }
            }
        }
        dp[(1 << price.len()) - 1]
    }
}