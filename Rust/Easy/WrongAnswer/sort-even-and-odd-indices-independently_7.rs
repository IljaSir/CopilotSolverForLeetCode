impl Solution {
    pub fn sort_even_odd(nums: Vec<i32>) -> Vec<i32> {
        
        let mut nums = nums;
        let mut odd = nums.iter().enumerate().filter(|(i, _)| i % 2 == 1).map(|(_, &x)| x).collect::<Vec<i32>>();
        let mut even = nums.iter().enumerate().filter(|(i, _)| i % 2 == 0).map(|(_, &x)| x).collect::<Vec<i32>>();
        odd.sort_by(|a, b| b.cmp(a));
        even.sort_by(|a, b| a.cmp(b));
        let mut i = 0;
        while i < nums.len() {
            if i % 2 == 1 {
                nums[i] = odd.pop().unwrap();
            } else {
                nums[i] = even.pop().unwrap();
            }
            i += 1;
        }
        nums
    }
}