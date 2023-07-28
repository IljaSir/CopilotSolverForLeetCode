impl Solution {
    pub fn length_of_lis(nums: Vec<i32>) -> i32 {
        

        let mut dp = Vec::new();
        for x in nums {
            match dp.binary_search(&x) {
                Ok(_) => (),
                Err(i) => {
                    if i == dp.len() {
                        dp.push(x);
                    } else {
                        dp[i] = x;
                    }
                }
            }
        }
        dp.len() as i32
    }
}