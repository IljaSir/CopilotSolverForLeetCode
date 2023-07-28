impl Solution {
    pub fn longest_subarray(nums: Vec<i32>) -> i32 {
        
        let mut max = 0;
        let mut prev = 0;
        let mut cur = 0;
        let mut found = false;
        for i in 0..nums.len() {
            if nums[i] == 1 {
                cur += 1;
            } else {
                if found {
                    max = std::cmp::max(max, cur + prev);
                } else {
                    found = true;
                }
                prev = cur;
                cur = 0;
            }
        }
        if found {
            max = std::cmp::max(max, cur + prev);
        }
        if found {
            max - 1
        } else {
            max - 1
        
    }
}