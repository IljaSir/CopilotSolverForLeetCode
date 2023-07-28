impl Solution {
    pub fn min_domino_rotations(tops: Vec<i32>, bottoms: Vec<i32>) -> i32 {
        
        let n = tops.len();
        let mut count = vec![0; 7];
        let mut same = vec![0; 7];
        for i in 0..n {
            count[tops[i] as usize] += 1;
            count[bottoms[i] as usize] += 1;
            if tops[i] == bottoms[i] {
                same[tops[i] as usize] += 1;
            }
        }
        let mut res = n as i32;
        for i in 1..7 {
            if count[i] >= n as i32 {
                res = res.min(n as i32 - same[i]);
            }
        }
        if res == n as i32 {
            -1
        } else {
            res
        }
    }
}