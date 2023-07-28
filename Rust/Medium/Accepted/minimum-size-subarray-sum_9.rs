impl Solution {
    pub fn min_sub_array_len(target: i32, nums: Vec<i32>) -> i32 {
        

        let mut sum = 0;
        let mut min_len = i32::MAX;
        let mut start = 0;
        for i in 0..nums.len() {
            sum += nums[i];
            while sum >= target {
                min_len = min_len.min((i - start + 1) as i32);
                sum -= nums[start];
                start += 1;
            }
        }
        if min_len == i32::MAX {
            0
        } else {
            min_len
        }
    }
}