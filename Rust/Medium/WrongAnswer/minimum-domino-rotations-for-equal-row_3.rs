impl Solution {
    pub fn min_domino_rotations(tops: Vec<i32>, bottoms: Vec<i32>) -> i32 {
        
        let n = tops.len();
        let mut count = vec![0; 7];
        let mut top = vec![0; 7];
        let mut bottom = vec![0; 7];
        for i in 0..n {
            let t = tops[i];
            let b = bottoms[i];
            count[t as usize] += 1;
            count[b as usize] += 1;
            top[t as usize] += 1;
            bottom[b as usize] += 1;
        }
        for i in 1..7 {
            if count[i] == n {
                return std::cmp::min(top[i], bottom[i]) as i32;
            }
        }
        -1
    }
}