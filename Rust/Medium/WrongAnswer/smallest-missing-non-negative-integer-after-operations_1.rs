impl Solution {
    pub fn find_smallest_integer(nums: Vec<i32>, value: i32) -> i32 {
        
        let mut nums = nums;
        nums.sort();
        let mut res = 0;
        for i in 0..nums.len() {
            if nums[i] > res {
                return res;
            }
            if nums[i] <= res {
                res += value;
            }
        }
        res
    }
}