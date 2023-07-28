impl Solution {
    pub fn min_impossible_or(nums: Vec<i32>) -> i32 {
        
        let mut nums = nums;
        nums.sort_unstable();
        let mut res = 1;
        for i in nums {
            if i <= res {
                res |= i;
            } else {
                break;
            }
        }
        res + 1
    }
}