impl Solution {
    pub fn min_domino_rotations(tops: Vec<i32>, bottoms: Vec<i32>) -> i32 {
        
        let n = tops.len();
        let mut ans = n as i32;
        for x in 1..=6 {
            let mut a = 0;
            let mut b = 0;
            let mut ok = true;
            for i in 0..n {
                if tops[i] != x && bottoms[i] != x {
                    ok = false;
                    break;
                } else if tops[i] != x {
                    a += 1;
                } else if bottoms[i] != x {
                    b += 1;
                }
            }
            if ok {
                ans = ans.min(a.min(b));
            }
        }
        if ans == n as i32 {
            -1
        } else {
            ans
        }
    }
}