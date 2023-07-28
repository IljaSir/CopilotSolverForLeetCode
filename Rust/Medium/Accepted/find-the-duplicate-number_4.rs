impl Solution {
    pub fn find_duplicate(nums: Vec<i32>) -> i32 {
        

        let mut s = 0;
        let mut f = 0;
        loop {
            s = nums[s as usize];
            f = nums[nums[f as usize] as usize];
            if s == f {
                break;
            }
        }
        let mut p = 0;
        loop {
            s = nums[s as usize];
            p = nums[p as usize];
            if s == p {
                break;
            }
        }
        s
    }
}