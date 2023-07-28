impl Solution {
    pub fn get_maximum_xor(nums: Vec<i32>, maximum_bit: i32) -> Vec<i32> {
        
        let mut ans = Vec::new();
        let mut x = 0;
        for i in 0..nums.len() {
            x ^= nums[i];
            ans.push(x ^ (1 << maximum_bit) - 1);
        }
        ans.reverse();
        ans
    }
}