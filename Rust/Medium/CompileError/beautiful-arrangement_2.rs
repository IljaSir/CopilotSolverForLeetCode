impl Solution {
    pub fn count_arrangement(n: i32) -> i32 {
        

        let mut nums = (1..=n).collect::<Vec<i32>>();
        let mut count = 0;
        Solution::backtrack(&mut nums, 0, &mut count);
        count
    }
    
    pub fn backtrack(nums: &mut Vec<i32>, start: usize, count: &mut i32) {
        if start == nums.len() {
            *count += 1;
            return;
        }
        
        for i in start..nums.len() {
            if nums[i] % (start + 1) as i32 == 0 || (start + 1) as i32 % nums[i] == 0 {
                nums.swap(i, start);
                Solution::backtrack(nums, start + 1, count);
                nums.swap(i, start);
            }
        }