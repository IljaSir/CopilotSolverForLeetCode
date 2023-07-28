impl Solution {
    pub fn find_min_fibonacci_numbers(k: i32) -> i32 {
        
        let mut a = 1;
        let mut b = 1;
        let mut c = 0;
        let mut fibs = vec![1];
        while c <= k {
            c = a + b;
            fibs.push(c);
            a = b;
            b = c;
        }
        let mut count = 0;
        let mut k = k;
        for i in (0..fibs.len()).rev() {
            if fibs[i] <= k {
                count += 1;
                k -= fibs[i];
            }
        }
        count
    }
}