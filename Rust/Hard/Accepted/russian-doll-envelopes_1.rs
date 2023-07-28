impl Solution {
    pub fn max_envelopes(envelopes: Vec<Vec<i32>>) -> i32 {
        
        let mut envelopes = envelopes;
        envelopes.sort_by(|a, b| a[0].cmp(&b[0]).then_with(|| a[1].cmp(&b[1]).reverse()));
        let mut dp = Vec::new();
        for envelope in envelopes {
            let index = match dp.binary_search(&envelope[1]) {
                Ok(index) => index,
                Err(index) => index,
            };
            if index == dp.len() {
                dp.push(envelope[1]);
            } else {
                dp[index] = envelope[1];
            }
        }
        dp.len() as i32
    }
}