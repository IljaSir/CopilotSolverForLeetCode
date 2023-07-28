impl Solution {
    pub fn min_deletion(nums: Vec<i32>) -> i32 {
        
        let mut ans = 0;
        let mut pre = nums[0];
        for i in 1..nums.len() {
            if i % 2 == 0 {
                if pre == nums[i] {
                    ans += 1;
                } else {
                    pre = nums[i];
                }
            } else {
                if pre == nums[i] {
                    ans += 1;
                } else {
                    pre = nums[i];
                }
            }
        }
        ans
    }
}