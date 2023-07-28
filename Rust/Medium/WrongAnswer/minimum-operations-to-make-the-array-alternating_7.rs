impl Solution {
    pub fn minimum_operations(nums: Vec<i32>) -> i32 {
        
        let mut cnt = 0;
        for i in 0..nums.len() {
            if i % 2 == 0 {
                if nums[i] % 2 == 0 {
                    cnt += 1;
                }
            } else {
                if nums[i] % 2 == 1 {
                    cnt += 1;
                }
            }
        }
        cnt.min(nums.len() as i32 - cnt)
    }
}