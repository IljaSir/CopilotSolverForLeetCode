impl Solution {
    pub fn min_domino_rotations(tops: Vec<i32>, bottoms: Vec<i32>) -> i32 {
        
        let n = tops.len();
        let mut ans = n as i32;
        for i in 0..n {
            let mut top = 0;
            let mut bottom = 0;
            let mut ok = true;
            for j in 0..n {
                if tops[j] != tops[i] && bottoms[j] != tops[i] {
                    ok = false;
                    break;
                }
                if tops[j] != tops[i] {
                    top += 1;
                }
                if bottoms[j] != tops[i] {
                    bottom += 1;
                }
            }
            if ok {
                ans = ans.min(top.min(bottom));
            }
        }
        for i in 0..n {
            let mut top = 0;
            let mut bottom = 0;
            let mut ok = true;
            for j in 0..n {
                if tops[j] != bottoms[i] && bottoms[j] != bottoms[i] {
                    ok = false;
                    break;
                }
                if tops[j] != bottoms[i] {
                    top += 1;
                }
                if bottoms[j] != bottoms[i] {
                    bottom += 1;
                }
            }
            if ok {
                ans = ans.min(top.min(bottom));
            }
        }
        if ans == n as i32 {
            -1
        } else {
            ans
        }
    }
}