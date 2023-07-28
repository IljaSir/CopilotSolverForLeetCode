impl Solution {
    pub fn min_domino_rotations(tops: Vec<i32>, bottoms: Vec<i32>) -> i32 {
        
        let n = tops.len();
        let mut a = vec![0; 7];
        let mut b = vec![0; 7];
        let mut same = vec![0; 7];
        for i in 0..n {
            a[tops[i] as usize] += 1;
            b[bottoms[i] as usize] += 1;
            if tops[i] == bottoms[i] {
                same[tops[i] as usize] += 1;
            }
        }
        for i in 1..7 {
            if a[i] + b[i] - same[i] == n {
                return (n as i32) - i32::max(a[i], b[i]);
            }
        }
        -1
    }
}