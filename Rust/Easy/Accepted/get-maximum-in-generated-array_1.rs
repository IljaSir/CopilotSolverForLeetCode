impl Solution {
    pub fn get_maximum_generated(n: i32) -> i32 {
        
        let n = n as usize;
        if n == 0 {
            return 0;
        }
        let mut nums = vec![0; n + 1];
        nums[1] = 1;
        for i in 1..=n {
            if i * 2 <= n {
                nums[i * 2] = nums[i];
            }
            if i * 2 + 1 <= n {
                nums[i * 2 + 1] = nums[i] + nums[i + 1];
            }
        }
        nums.iter().max().unwrap().clone()
    }
}