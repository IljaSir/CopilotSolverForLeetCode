impl Solution {
    pub fn min_swaps(nums: Vec<i32>) -> i32 {
        
        let mut count = 0;
        for i in 0..nums.len() {
            if nums[i] == 1 {
                count += 1;
            }
        }
        let mut i = 0;
        let mut j = 0;
        let mut max = 0;
        while j < nums.len() {
            if nums[j] == 1 {
                max += 1;
            }
            if j - i + 1 > count {
                if nums[i] == 1 {
                    max -= 1;
                }
                i += 1;
            }
            j += 1;
        }
        (count - max) as i32
    }
}