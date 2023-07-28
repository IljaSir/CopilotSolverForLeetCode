impl Solution {
    pub fn min_domino_rotations(tops: Vec<i32>, bottoms: Vec<i32>) -> i32 {
        
        let mut res = -1;
        for i in 1..7 {
            let mut cnt = 0;
            let mut ok = true;
            for j in 0..tops.len() {
                if tops[j] != i && bottoms[j] != i {
                    ok = false;
                    break;
                }
                if tops[j] != i {
                    cnt += 1;
                }
            }
            if ok {
                res = if res == -1 {cnt} else {res.min(cnt)};
            }
            let mut cnt = 0;
            let mut ok = true;
            for j in 0..tops.len() {
                if tops[j] != i && bottoms[j] != i {
                    ok = false;
                    break;
                }
                if bottoms[j] != i {
                    cnt += 1;
                }
            }
            if ok {
                res = if res == -1 {cnt} else {res.min(cnt)};
            }
        }
        res
    }
}