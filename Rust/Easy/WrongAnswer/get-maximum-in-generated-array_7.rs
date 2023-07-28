impl Solution {
    pub fn get_maximum_generated(n: i32) -> i32 {
        
        let n = n as usize;
        let mut nums = vec![0; n + 1];
        for i in 1..=n {
            nums[i] = if i % 2 == 0 {
                nums[i / 2]
            } else {
                nums[i / 2] + nums[i / 2 + 1]
            }
        }
        nums.iter().max().unwrap().clone()
    }
}