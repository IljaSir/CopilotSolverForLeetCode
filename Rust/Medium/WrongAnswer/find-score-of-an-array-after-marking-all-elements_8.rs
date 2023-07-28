impl Solution {
    pub fn find_score(nums: Vec<i32>) -> i64 {
        
        let mut nums = nums;
        let mut score = 0;
        let mut i = 0;
        while i < nums.len() {
            let mut min = (i32::max_value(), i);
            for j in i..nums.len() {
                if nums[j] < min.0 {
                    min = (nums[j], j);
                }
            }
            score += min.0 as i64;
            nums[min.1] = i32::max_value();
            if min.1 > 0 {
                nums[min.1 - 1] = i32::max_value();
            }
            if min.1 < nums.len() - 1 {
                nums[min.1 + 1] = i32::max_value();
            }
            i = min.1 + 1;
        }
        score
    }
}