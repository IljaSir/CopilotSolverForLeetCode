impl Solution {
    pub fn prefixes_div_by5(nums: Vec<i32>) -> Vec<bool> {
        
        let mut x = 0;
        let mut answer = Vec::with_capacity(nums.len());
        for n in nums {
            x = (x << 1) + n;
            answer.push(x % 5 == 0);
            x %= 5;
        }
        answer
    }
}