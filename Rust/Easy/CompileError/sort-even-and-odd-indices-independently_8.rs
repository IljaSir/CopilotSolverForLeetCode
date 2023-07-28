impl Solution {
    pub fn sort_even_odd(nums: Vec<i32>) -> Vec<i32> {
        
        let mut nums = nums;
        let mut odd = nums.iter().enumerate().filter(|(i, _)| i % 2 == 1).map(|(_, v)| v).collect::<Vec<_>>();
        let mut even = nums.iter().enumerate().filter(|(i, _)| i % 2 == 0).map(|(_, v)| v).collect::<Vec<_>>();
        odd.sort();
        even.sort();
        for i in 0..nums.len() {
            if i % 2 == 0 {
                nums[i] = even[i / 2];
            } else {
                nums[i] = odd[i / 2];
            }
        }
        nums
    }
}