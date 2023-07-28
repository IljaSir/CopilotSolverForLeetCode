impl Solution {
    pub fn min_max_game(nums: Vec<i32>) -> i32 {
        
        let mut nums = nums;
        let mut n = nums.len();
        while n != 1 {
            let mut new_nums = vec![];
            for i in 0..n/2 {
                new_nums.push(nums[2*i].min(nums[2*i+1]));
                new_nums.push(nums[2*i].max(nums[2*i+1]));
            }
            nums = new_nums;
            n = n / 2;
        }
        nums[0]
    }
}