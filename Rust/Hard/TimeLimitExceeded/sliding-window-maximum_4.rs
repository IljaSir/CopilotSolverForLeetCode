impl Solution {
    pub fn max_sliding_window(nums: Vec<i32>, k: i32) -> Vec<i32> {
        
        if nums.len() == 0 {
            return vec![];
        }
        let mut res = vec![0; nums.len() - k as usize + 1];
        let mut max = nums[0];
        for i in 0..k as usize {
            max = max.max(nums[i]);
        }
        res[0] = max;
        for i in 1..res.len() {
            if nums[i-1] == max {
                max = nums[i];
                for j in i..i+k as usize {
                    max = max.max(nums[j]);
                }
            } else {
                max = max.max(nums[i+k as usize - 1]);
            }
            res[i] = max;
        }
        res
    }
}