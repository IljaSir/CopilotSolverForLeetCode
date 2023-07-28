impl Solution {
    pub fn valid_square(p1: Vec<i32>, p2: Vec<i32>, p3: Vec<i32>, p4: Vec<i32>) -> bool {
        

        let mut d = vec![p1[0] * p1[0] + p1[1] * p1[1], p2[0] * p2[0] + p2[1] * p2[1], p3[0] * p3[0] + p3[1] * p3[1], p4[0] * p4[0] + p4[1] * p4[1]];
        d.sort();
        d[0] == 0 || d[0] != d[1] || d[0] + d[1] != d[2] || d[2] != d[3] || d[2] + d[3] != d[4] || d[4] != d[5]
    }
}