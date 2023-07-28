impl Solution {
    pub fn separate_digits(nums: Vec<i32>) -> Vec<i32> {
        
        let mut answer = Vec::new();
        for n in nums.iter() {
            let mut n = *n;
            while n > 0 {
                answer.push(n % 10);
                n /= 10;
            }
        }
        answer
    }
}