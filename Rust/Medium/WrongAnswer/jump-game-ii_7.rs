impl Solution {
    pub fn jump(nums: Vec<i32>) -> i32 {
        

        let mut i = 0;
        let mut j = 0;
        let mut res = 0;
        while j < nums.len() - 1 {
            let mut k = i;
            while k <= j {
                i = std::cmp::max(i, k + nums[k] as usize);
                k += 1;
            }
            j = i;
            res += 1;
        }
        res
    }
}