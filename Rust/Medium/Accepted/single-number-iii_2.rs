impl Solution {
    pub fn single_number(nums: Vec<i32>) -> Vec<i32> {
        

        let mut xor = 0;
        for n in nums.iter() {
            xor ^= n;
        }
        let mut mask = 1;
        while mask & xor == 0 {
            mask <<= 1;
        }
        let mut ret = vec![0, 0];
        for n in nums.iter() {
            if *n & mask == 0 {
                ret[0] ^= n;
            } else {
                ret[1] ^= n;
            }
        }
        ret
    }
}