impl Solution {
    pub fn sort_even_odd(nums: Vec<i32>) -> Vec<i32> {
        
        let mut nums = nums;
        let (mut even, mut odd) = (0, 1);
        while odd < nums.len() {
            if nums[odd] > nums[even] {
                nums.swap(odd, even);
            }
            even += 2;
            odd += 2;
        }
        even = 0;
        odd = 1;
        while odd < nums.len() {
            if nums[odd] < nums[even] {
                nums.swap(odd, even);
            }
            even += 2;
            odd += 2;
        }
        nums
    }
}