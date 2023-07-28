impl Solution {
    pub fn summary_ranges(nums: Vec<i32>) -> Vec<String> {
        
        let mut ret = vec![];
        let mut start = 0;
        let mut end = 0;
        for i in 1..nums.len() {
            if nums[i] - nums[i - 1] == 1 {
                end = i;
            } else {
                if start == end {
                    ret.push(format!("{}", nums[start]));
                } else {
                    ret.push(format!("{}->{}", nums[start], nums[end]));
                }
                start = i;
                end = i;
            }
        }
        if start == end {
            ret.push(format!("{}", nums[start]));
        } else {
            ret.push(format!("{}->{}", nums[start], nums[end]));
        }
        ret
    }
}