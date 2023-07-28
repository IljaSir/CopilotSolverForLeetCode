impl Solution {
    pub fn summary_ranges(nums: Vec<i32>) -> Vec<String> {
        
        let mut res = vec![];
        let mut start = 0;
        for i in 1..nums.len() {
            if nums[i] != nums[i-1] + 1 {
                if i-1 == start {
                    res.push(nums[start].to_string());
                } else {
                    res.push(format!("{}->{}", nums[start], nums[i-1]));
                }
                start = i;
            }
        }
        if start == nums.len() - 1 {
            res.push(nums[start].to_string());
        } else if start < nums.len() {
            res.push(format!("{}->{}", nums[start], nums[nums.len()-1]));
        }
        res
    }
}