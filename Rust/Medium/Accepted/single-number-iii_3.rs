impl Solution {
    pub fn single_number(nums: Vec<i32>) -> Vec<i32> {
        

        let mut xor = 0;
        for num in nums.iter() {
            xor ^= num;
        }
        let mut mask = 1;
        while (xor & mask) == 0 {
            mask <<= 1;
        }
        let mut a = 0;
        let mut b = 0;
        for num in nums.iter() {
            if (num & mask) == 0 {
                a ^= num;
            } else {
                b ^= num;
            }
        }
        vec![a, b]
    }
}