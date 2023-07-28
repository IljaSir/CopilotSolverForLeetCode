impl Solution {
    pub fn tribonacci(n: i32) -> i32 {
        
        if n == 0 {
            return 0;
        }
        if n == 1 || n == 2 {
            return 1;
        }
        let mut v = vec![0; (n + 1) as usize];
        v[0] = 0;
        v[1] = 1;
        v[2] = 1;
        for i in 3..=(n as usize) {
            v[i] = v[i - 1] + v[i - 2] + v[i - 3];
        }
        v[n as usize]
    }
}