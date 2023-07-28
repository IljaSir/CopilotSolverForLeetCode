impl Solution {
    pub fn separate_digits(nums: Vec<i32>) -> Vec<i32> {
        
        let mut res: Vec<i32> = vec![];
        for n in nums {
            let mut n = n;
            while n > 0 {
                res.push(n % 10);
                n /= 10;
            }
        }
        res
    }
}