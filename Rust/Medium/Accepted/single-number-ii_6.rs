impl Solution {
    pub fn single_number(nums: Vec<i32>) -> i32 {
        

        let mut res = 0;
        for i in 0..32 {
            let mut cnt = 0;
            for &num in nums.iter() {
                if (num >> i) & 1 == 1 {
                    cnt += 1;
                }
            }
            if cnt % 3 != 0 {
                res |= 1 << i;
            }
        }
        res
    }
}