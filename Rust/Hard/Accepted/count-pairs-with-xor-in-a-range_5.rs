impl Solution {
    pub fn count_pairs(nums: Vec<i32>, low: i32, high: i32) -> i32 {
        
        let mut ans = 0;
        let n = nums.len();
        for i in 0..n {
            for j in i + 1..n {
                let xor = nums[i] ^ nums[j];
                if xor >= low && xor <= high {
                    ans += 1;
                }
            }
        }
        ans
    }
}