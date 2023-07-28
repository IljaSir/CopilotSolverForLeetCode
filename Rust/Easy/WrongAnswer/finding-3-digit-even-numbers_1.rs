impl Solution {
    pub fn find_even_numbers(digits: Vec<i32>) -> Vec<i32> {
        
        let mut v = Vec::new();
        for i in 0..digits.len() {
            for j in 0..digits.len() {
                for k in 0..digits.len() {
                    if i != j && j != k && k != i {
                        let mut num = digits[i] * 100 + digits[j] * 10 + digits[k];
                        if num % 2 == 0 && num > 0 {
                            v.push(num);
                        }
                    }
                }
            }
        }
        v.sort();
        v.dedup();
        v
    }
}