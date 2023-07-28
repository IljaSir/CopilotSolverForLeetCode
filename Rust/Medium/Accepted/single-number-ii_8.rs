impl Solution {
    pub fn single_number(nums: Vec<i32>) -> i32 {
        

        let mut s = 0;
        let mut t = 0;
        for n in nums {
            s = !t & (s ^ n);
            t = !s & (t ^ n);
        }
        s
    }
}