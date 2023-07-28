impl Solution {
    pub fn min_domino_rotations(tops: Vec<i32>, bottoms: Vec<i32>) -> i32 {
        
        let n = tops.len();
        let mut ans = -1;
        for i in 1..7 {
            let mut a = 0;
            let mut b = 0;
            let mut c = 0;
            let mut d = 0;
            for j in 0..n {
                if tops[j] == i {
                    a += 1;
                }
                if bottoms[j] == i {
                    b += 1;
                }
                if tops[j] == i || bottoms[j] == i {
                    c += 1;
                }
                if bottoms[j] == i || tops[j] == i {
                    d += 1;
                }
            }
            if a == n || b == n {
                ans = 0;
                break;
            }
            if c == n {
                ans = a.min(b);
                break;
            }
            if d == n {
                ans = a.min(b);
                break;
            }
        }
        ans
    }
}