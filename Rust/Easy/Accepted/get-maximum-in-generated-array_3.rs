impl Solution {
    pub fn get_maximum_generated(n: i32) -> i32 {
        
        if n == 0 {
            return 0;
        }
        let mut nums = vec![0; (n + 1) as usize];
        nums[1] = 1;
        let mut max = 1;
        for i in 0..=n {
            let i = i as usize;
            let ii = i * 2;
            if ii <= n as usize {
                nums[ii] = nums[i];
                max = max.max(nums[ii]);
            }
            let ii = i * 2 + 1;
            if ii <= n as usize {
                nums[ii] = nums[i] + nums[i + 1];
                max = max.max(nums[ii]);
            }
        }
        max
    }
}