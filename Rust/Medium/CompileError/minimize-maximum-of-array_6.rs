impl Solution {
    pub fn minimize_array_value(nums: Vec<i32>) -> i32 {
        
        let mut nums = nums;
        let mut sum: i64 = nums.iter().sum();
        let mut min = *nums.iter().min().unwrap();
        let mut max = *nums.iter().max().unwrap();
        let mut res = 0;
        while min < max {
            let mid = (min + max) / 2;
            let mut temp = 0;
            for i in 0..nums.len() {
                temp += (nums[i] - mid).max(0);
            }
            if temp <= sum / 2 {
                max = mid;
            } else {
                min = mid + 1;
            }
        }
        min
    }
}