impl Solution {
    pub fn min_domino_rotations(tops: Vec<i32>, bottoms: Vec<i32>) -> i32 {
        
        let n = tops.len();
        let (mut a, mut b, mut c, mut d) = (0, 0, 0, 0);
        let (mut x, mut y) = (tops[0], bottoms[0]);
        for i in 0..n {
            if tops[i] != x && bottoms[i] != x {
                a = -1;
            }
            if tops[i] != y && bottoms[i] != y {
                b = -1;
            }
            if tops[i] == x {
                c += 1;
            }
            if bottoms[i] == x {
                d += 1;
            }
            if tops[i] == y {
                b += 1;
            }
            if bottoms[i] == y {
                a += 1;
            }
        }
        if a == n || b == n {
            return 0;
        }
        if a == -1 && b == -1 {
            return -1;
        }
        if a == -1 {
            return n as i32 - b;
        }
        if b == -1 {
            return n as i32 - a;
        }
        return std::cmp::min(n as i32 - a, n as i32 - b);
    }
}