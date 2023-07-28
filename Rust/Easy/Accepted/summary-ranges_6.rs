impl Solution {
    pub fn summary_ranges(nums: Vec<i32>) -> Vec<String> {
        
        let mut res = Vec::new();
        let mut start = 0;
        let mut end = 0;
        let mut i = 0;
        while i < nums.len() {
            start = nums[i];
            end = start;
            while i < nums.len() - 1 && nums[i] + 1 == nums[i + 1] {
                i += 1;
                end = nums[i];
            }
            res.push(if start == end {
                start.to_string()
            } else {
                format!("{}->{}", start, end)
            });
            i += 1;
        }
        res
    }
}