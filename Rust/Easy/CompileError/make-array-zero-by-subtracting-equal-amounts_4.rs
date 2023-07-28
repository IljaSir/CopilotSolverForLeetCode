impl Solution {
    pub fn minimum_operations(nums: Vec<i32>) -> i32 {
        
        let mut nums = nums;
        nums.sort();
        let mut i = 0;
        let mut res = 0;
        while i < nums.len() {
            let mut j = i + 1;
            while j < nums.len() && nums[j] == nums[i] {
                j += 1;
            }
            res += j - i;
            i = j;
        }
        res
    }
}