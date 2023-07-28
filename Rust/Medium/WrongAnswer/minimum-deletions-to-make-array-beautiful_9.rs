impl Solution {
    pub fn min_deletion(nums: Vec<i32>) -> i32 {
        
        let mut prev = nums[0];
        let mut count = 0;
        let mut is_first = true;
        for x in nums {
            if is_first {
                is_first = false;
                continue;
            }
            if x == prev {
                count += 1;
            } else {
                prev = x;
            }
        }
        count
    }
}