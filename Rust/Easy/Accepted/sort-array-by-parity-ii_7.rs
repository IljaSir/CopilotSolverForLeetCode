impl Solution {
    pub fn sort_array_by_parity_ii(nums: Vec<i32>) -> Vec<i32> {
        
        let mut nums = nums;
        let mut odd = 1;
        let mut even = 0;
        while odd < nums.len() && even < nums.len() {
            while odd < nums.len() && nums[odd] % 2 == 1 {
                odd += 2;
            }
            while even < nums.len() && nums[even] % 2 == 0 {
                even += 2;
            }
            if odd < nums.len() && even < nums.len() {
                nums.swap(odd, even);
            }
        }
        nums
    }
}