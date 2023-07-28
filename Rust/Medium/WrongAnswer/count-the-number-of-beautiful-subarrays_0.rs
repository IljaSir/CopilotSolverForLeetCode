impl Solution {
    pub fn beautiful_subarrays(nums: Vec<i32>) -> i64 {
        
        let mut ans = 0;
        for i in 0..nums.len() {
            let mut odd = 0;
            for j in i..nums.len() {
                if nums[j] % 2 == 1 {
                    odd += 1;
                }
                if odd % 2 == 1 {
                    ans += 1;
                }
            }
        }
        ans
    }
}