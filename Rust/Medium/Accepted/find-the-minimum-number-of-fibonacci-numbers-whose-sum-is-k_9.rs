impl Solution {
    pub fn find_min_fibonacci_numbers(k: i32) -> i32 {
        
        let mut fib = vec![1,1];
        while fib.last().unwrap() <= &k {
            let l = fib.len();
            fib.push(fib[l-1] + fib[l-2]);
        }
        // println!("{:?}", fib);
        let mut k = k;
        let mut ans = 0;
        while k > 0 {
            let f = fib.iter().rev().find(|&&x| x <= k).unwrap();
            k -= f;
            ans += 1;
        }
        ans
    }
}