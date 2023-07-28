impl Solution {
    pub fn single_number(nums: Vec<i32>) -> Vec<i32> {
        

        let mut res = 0;
        for num in nums.iter() {
            res ^= num;
        }
        let mut mask = 1;
        while res & mask == 0 {
            mask <<= 1;
        }
        let mut res1 = 0;
        let mut res2 = 0;
        for num in nums.iter() {
            if num & mask == 0 {
                res1 ^= num;
            } else {
                res2 ^= num;
            }
        }
        vec![res1, res2]
    }
}