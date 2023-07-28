impl Solution {
    pub fn count_arrangement(n: i32) -> i32 {
        

        let mut nums = vec![0; n as usize];
        for i in 0..n {
            nums[i as usize] = i + 1;
        }
        Self::count(nums)
    }
    fn count(mut nums: Vec<i32>) -> i32 {
        if nums.len() == 0 {
            return 1;
        }
        let mut ret = 0;
        for i in 0..nums.len() {
            if nums[i] % nums.len() as i32 == 0 || nums.len() as i32 % nums[i] == 0 {
                nums.swap(i, nums.len() - 1);
                ret += Self::count(nums[..nums.len() - 1].to_vec());
                nums.swap(i, nums.len() - 1);
            }
        }
        ret
    }
}