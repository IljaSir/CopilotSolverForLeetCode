impl Solution {
    pub fn summary_ranges(nums: Vec<i32>) -> Vec<String> {
        
        if nums.is_empty() {
            return vec![];
        }
        let mut res = vec![];
        let mut l = 0;
        let mut r = 0;
        while r < nums.len() {
            if r + 1 < nums.len() && nums[r] + 1 == nums[r + 1] {
                r += 1;
            } else {
                if l == r {
                    res.push(nums[l].to_string());
                } else {
                    res.push(format!("{}->{}", nums[l], nums[r]));
                }
                l = r + 1;
                r = l;
            }
        }
        res
    }
}