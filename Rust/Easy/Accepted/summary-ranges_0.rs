impl Solution {
    pub fn summary_ranges(nums: Vec<i32>) -> Vec<String> {
        
        let mut result = Vec::new();
        if nums.len() == 0 {
            return result;
        }
        let mut start = nums[0];
        let mut end = nums[0];
        for i in 1..nums.len() {
            if nums[i] == end + 1 {
                end = nums[i];
            } else {
                if start == end {
                    result.push(start.to_string());
                } else {
                    result.push(format!("{}->{}", start, end));
                }
                start = nums[i];
                end = nums[i];
            }
        }
        if start == end {
            result.push(start.to_string());
        } else {
            result.push(format!("{}->{}", start, end));
        }
        result
    }
}