impl Solution {
    pub fn single_number(nums: Vec<i32>) -> Vec<i32> {
        

        let mut ans = Vec::with_capacity(2);
        let mut xor = 0;
        for num in nums.iter() {
            xor ^= num;
        }
        xor &= -xor;
        for num in nums.iter() {
            if num & xor == 0 {
                ans.push(*num);
            }
        }
        ans
    }
}