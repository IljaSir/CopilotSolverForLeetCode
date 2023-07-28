impl Solution {
    pub fn summary_ranges(nums: Vec<i32>) -> Vec<String> {
        
        let mut res = vec![];
        let mut start = 0;
        let mut end = 0;
        for i in 1..nums.len() {
            if nums[i] == nums[i-1] + 1 {
                end = i;
            } else {
                if start == end {
                    res.push(nums[start].to_string());
                } else {
                    res.push(format!("{}->{}", nums[start], nums[end]));
                }
                start = i;
                end = i;
            }
        }
        if start == end {
            res.push(nums[start].to_string());
        } else {
            res.push(format!("{}->{}", nums[start], nums[end]));
        }
        res
    }
}