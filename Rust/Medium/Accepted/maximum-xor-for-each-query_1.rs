impl Solution {
    pub fn get_maximum_xor(nums: Vec<i32>, maximum_bit: i32) -> Vec<i32> {
        
        let mut ans = Vec::new();
        let mut x = 0;
        for num in nums {
            x ^= num;
            ans.push((1 << maximum_bit) - 1 - x);
        }
        ans.reverse();
        ans
    }
}