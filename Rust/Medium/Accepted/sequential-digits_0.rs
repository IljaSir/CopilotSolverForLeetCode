impl Solution {
    pub fn sequential_digits(low: i32, high: i32) -> Vec<i32> {
        
        let mut res = vec![];
        for i in 1..=9 {
            let mut n = i;
            for j in i+1..=9 {
                n = n * 10 + j;
                if n >= low && n <= high {
                    res.push(n);
                }
            }
        }
        res.sort();
        res
    }
}