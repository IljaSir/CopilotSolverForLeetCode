impl Solution {
    pub fn get_maximum_generated(n: i32) -> i32 {
        
        if n == 0 || n == 1 {
            return n;
        }

        let mut nums = vec![0; (n + 1) as usize];
        nums[1] = 1;
        let mut max = 1;
        for i in 2..=n {
            let index = i as usize;
            let half = i / 2;
            nums[index] = nums[half as usize];
            if i % 2 == 1 {
                nums[index] += nums[(half + 1) as usize];
            }
            max = max.max(nums[index]);
        }
        max
    }
}