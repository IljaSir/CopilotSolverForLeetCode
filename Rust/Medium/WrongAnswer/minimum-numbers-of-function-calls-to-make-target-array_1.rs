impl Solution {
    pub fn min_operations(nums: Vec<i32>) -> i32 {
        
        let mut nums = nums;
        let mut ans = 0;
        while nums.iter().any(|&x| x > 0) {
            ans += 1;
            for i in 0..nums.len() {
                if nums[i] % 2 == 1 {
                    nums[i] -= 1;
                } else {
                    nums[i] /= 2;
                }
            }
        }
        ans
    }
}