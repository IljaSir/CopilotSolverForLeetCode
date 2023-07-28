impl Solution {
    pub fn sequential_digits(low: i32, high: i32) -> Vec<i32> {
        
        let mut res = vec![];
        for i in 1..9 {
            let mut n = i;
            while n <= high {
                if n >= low {
                    res.push(n);
                }
                n = n * 10 + (n % 10) + 1;
            }
        }
        res.sort();
        res
    }
}