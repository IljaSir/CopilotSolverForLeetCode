impl Solution {
    pub fn summary_ranges(nums: Vec<i32>) -> Vec<String> {
        
        let mut ret = Vec::new();
        let mut i = 0;
        while i < nums.len() {
            let mut j = i+1;
            while j < nums.len() && nums[j] == nums[j-1] + 1 {
                j += 1;
            }
            if j > i+1 {
                ret.push(format!("{}->{}", nums[i], nums[j-1]));
            } else {
                ret.push(format!("{}", nums[i]));
            }
            i = j;
        }
        ret
    }
}