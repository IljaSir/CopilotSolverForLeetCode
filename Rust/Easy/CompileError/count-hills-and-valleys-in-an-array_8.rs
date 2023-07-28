impl Solution {
    pub fn count_hill_valley(nums: Vec<i32>) -> i32 {
        
        let mut res = 0;
        let mut i = 1;
        let mut prev = nums[0];
        while i < nums.len() {
            let mut j = i;
            while j < nums.len() && nums[j] == nums[j - 1] {
                j += 1;
            }
            if j == nums.len() {
                break;
            }
            let mut is_hill = nums[j] > nums[j - 1];
            while j < nums.len() && nums[j] > nums[j - 1] == is_hill {
                j += 1;
            }
            if j == nums.len() {
                break;
            }
            if is_hill && nums[j] < nums[j - 1] {
                res += 1;
            }
            if !is_hill && nums[j] > nums[j - 1] {
                res += 1;
            }
            i = j;
        }
        res
    }
}