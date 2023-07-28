impl Solution {
    pub fn min_non_zero_product(p: i32) -> i32 {
        
        let m = 1_000_000_007;
        let n = (1 << p) - 1;
        let a = (1 << (p - 1)) - 1;
        let b = (1 << (p - 1)) + (1 << (p - 2));
        let c = (n - a) % m;
        let d = (n - b) % m;
        let e = (n - 1) % m;
        let f = (n - 2) % m;
        let g = (n - 3) % m;
        let h = (n - 4) % m;
        let mut x = 1;
        for _ in 0..(p - 1) {
            x = (x * x) % m;
        }
        let y = (x * x) % m;
        let z = (x * y) % m;
        let mut r = (a * b) % m;
        r = (r * c) % m;
        r = (r * d) % m;
        r = (r * e) % m;
        r = (r * f) % m;
        r = (r * g) % m;
        r = (r * h) % m;
        r = (r * x) % m;
        r = (r * y) % m;
        r = (r * z) % m;
        r
    }
}