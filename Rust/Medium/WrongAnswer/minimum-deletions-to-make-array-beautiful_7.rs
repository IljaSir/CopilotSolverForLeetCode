impl Solution {
    pub fn min_deletion(nums: Vec<i32>) -> i32 {
        
        let mut count = 0;
        let mut last = -1;
        for i in 0..nums.len() {
            if i % 2 == 0 {
                if nums[i] == last {
                    count += 1;
                }
                last = nums[i];
            } else {
                if nums[i] == last {
                    count += 1;
                } else {
                    last = nums[i];
                }
            }
        }
        count
    }
}