impl Solution {
    pub fn longest_subarray(nums: Vec<i32>) -> i32 {
        
        let mut max = 0;
        let mut max_idx = 0;
        for i in 0..nums.len() {
            if nums[i] > max {
                max = nums[i];
                max_idx = i;
            }
        }
        let mut max2 = 0;
        for i in 0..max_idx {
            let tmp = max & nums[i];
            if tmp > max2 {
                max2 = tmp;
            }
        }
        let mut max3 = 0;
        for i in (max_idx + 1)..nums.len() {
            let tmp = max & nums[i];
            if tmp > max3 {
                max3 = tmp;
            }
        }
        if max2 == max {
            return 1;
        }
        if max3 == max {
            return 1;
        }
        2
    }
}