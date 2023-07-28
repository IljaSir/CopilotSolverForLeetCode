impl Solution {
    pub fn find_length_of_lcis(nums: Vec<i32>) -> i32 {
        
        let mut max = 0;
        let mut cur = 0;
        for (i, n) in nums.iter().enumerate() {
            if i == 0 {
                cur = 1;
            } else {
                if n > &nums[i-1] {
                    cur += 1;
                } else {
                    cur = 1;
                }
            }
            if cur > max {
                max = cur;
            }
        }
        max
    }
}