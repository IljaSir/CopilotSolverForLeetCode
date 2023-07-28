impl Solution {
    pub fn max_sliding_window(nums: Vec<i32>, k: i32) -> Vec<i32> {
        
        let mut max = nums.iter().take(k as usize).max().unwrap();
        let mut res = vec![*max];
        for i in k as usize..nums.len() {
            if nums[i] > *max {
                max = &nums[i];
            } else if nums[i - k as usize] == *max {
                max = nums.iter().skip(i - k as usize + 1).take(k as usize).max().unwrap();
            }
            res.push(*max);
        }
        res
    }
}