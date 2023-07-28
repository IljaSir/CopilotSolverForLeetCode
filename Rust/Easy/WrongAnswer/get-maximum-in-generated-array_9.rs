impl Solution {
    pub fn get_maximum_generated(n: i32) -> i32 {
        
        let mut nums = vec![0; n as usize + 1];
        nums[1] = 1;
        for i in 2..=n as usize {
            nums[i] = nums[i/2] + nums[i/2 + i % 2];
        }
        nums.iter().max().unwrap().clone()
    }
}