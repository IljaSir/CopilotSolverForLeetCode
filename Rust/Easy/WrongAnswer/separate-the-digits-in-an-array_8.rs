impl Solution {
    pub fn separate_digits(nums: Vec<i32>) -> Vec<i32> {
        
        let mut answer: Vec<i32> = Vec::new();
        for i in nums {
            let mut i = i;
            while i > 0 {
                answer.push(i % 10);
                i /= 10;
            }
        }
        answer
    }
}