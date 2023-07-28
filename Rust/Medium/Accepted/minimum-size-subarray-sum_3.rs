impl Solution {
    pub fn min_sub_array_len(target: i32, nums: Vec<i32>) -> i32 {
        

        let mut i = 0;
        let mut j = 0;
        let mut sum = 0;
        let mut min = nums.len() + 1;
        while j < nums.len() {
            sum += nums[j];
            while sum >= target {
                min = min.min(j - i + 1);
                sum -= nums[i];
                i += 1;
            }
            j += 1;
        }
        if min == nums.len() + 1 {
            0
        } else {
            min as i32
        }
    }
}