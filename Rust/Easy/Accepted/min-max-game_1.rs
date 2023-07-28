impl Solution {
    pub fn min_max_game(nums: Vec<i32>) -> i32 {
        
        let mut nums = nums;
        while nums.len() > 1 {
            let mut new_nums = vec![];
            for i in 0..nums.len()/2 {
                if i%2 == 0 {
                    new_nums.push(nums[2*i].min(nums[2*i+1]));
                } else {
                    new_nums.push(nums[2*i].max(nums[2*i+1]));
                }
            }
            nums = new_nums;
        }
        nums[0]
    }
}