impl Solution {
    pub fn count_palindromic_subsequence(s: String) -> i32 {
        
        let mut a = vec![0; 26];
        let mut b = vec![0; 26];
        let mut c = vec![0; 26];
        let mut d = vec![0; 26];
        let mut e = vec![0; 26];
        let mut f = vec![0; 26];
        let mut g = vec![0; 26];
        let mut h = vec![0; 26];
        let mut i = vec![0; 26];
        let mut j = vec![0; 26];
        let mut k = vec![0; 26];
        let mut l = vec![0; 26];
        let mut m = vec![0; 26];
        let mut n = vec![0; 26];
        let mut o = vec![0; 26];
        let mut p = vec![0; 26];
        let mut q = vec![0; 26];
        let mut r = vec![0; 26];
        let mut s = vec![0; 26];
        let mut t = vec![0; 26];
        let mut u = vec![0; 26];
        let mut v = vec![0; 26];
        let mut w = vec![0; 26];
        let mut x = vec![0; 26];
        let mut y = vec![0; 26];
        let mut z = vec![0; 26];
        let mut count = 0;
        for ch in s.chars() {
            match ch {
                'a' => {
                    for i in 0..26 {
                        count += a[i];
                        a[i] = 1;
                    }
                },
                'b' => {
                    for i in 0..26 {
                        count += b[i];
                        b[i] = a[i];
                    }
                },
                'c' => {
                    for i in 0..26 {
                        count += c[i];
                        c[i] = b[i];
                    }
                },
                'd' => {
                    for i in 0..26 {
                        count += d[i];
                        d[i] = c[i];
                    }
                },
                'e' => {
                    for i in 0..26 {
                        count += e[i];
                        e[i] = d[i];
                    }
                },
                '
    }
}