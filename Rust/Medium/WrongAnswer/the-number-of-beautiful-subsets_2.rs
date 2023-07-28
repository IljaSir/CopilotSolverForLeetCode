impl Solution {
    pub fn beautiful_subsets(nums: Vec<i32>, k: i32) -> i32 {
        
        let mut dp = vec![0; 1 << nums.len()];
        dp[0] = 1;
        for i in 0..(1 << nums.len()) {
            let mut ok = true;
            for j in 0..nums.len() {
                if i & (1 << j) != 0 {
                    for l in j + 1..nums.len() {
                        if i & (1 << l) != 0 && (nums[j] - nums[l]).abs() == k {
                            ok = false;
                            break;
                        }
                    }
                }
            }
            if ok {
                for j in 0..nums.len() {
                    if i & (1 << j) == 0 {
                        dp[i | (1 << j)] += dp[i];
                    }
                }
            }
        }
        dp[(1 << nums.len()) - 1]
    }
}