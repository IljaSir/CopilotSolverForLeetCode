impl Solution {
    pub fn xor_operation(n: i32, start: i32) -> i32 {
        
        let mut nums = Vec::new();
        for i in 0..n {
            nums.push(start + 2 * i);
        }
        let mut result = 0;
        for i in nums {
            result ^= i;
        }
        result
    }
}