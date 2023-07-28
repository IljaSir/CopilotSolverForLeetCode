impl Solution {
    pub fn valid_square(p1: Vec<i32>, p2: Vec<i32>, p3: Vec<i32>, p4: Vec<i32>) -> bool {
        

        let mut dists = vec![0; 6];
        dists[0] = Self::dist(&p1, &p2);
        dists[1] = Self::dist(&p1, &p3);
        dists[2] = Self::dist(&p1, &p4);
        dists[3] = Self::dist(&p2, &p3);
        dists[4] = Self::dist(&p2, &p4);
        dists[5] = Self::dist(&p3, &p4);
        dists.sort();
        dists[0] > 0 && dists[0] == dists[1] && dists[1] == dists[2] && dists[2] == dists[3] && dists[4] == dists[5]
    }
}