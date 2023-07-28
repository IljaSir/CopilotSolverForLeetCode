impl Solution {
    pub fn valid_square(p1: Vec<i32>, p2: Vec<i32>, p3: Vec<i32>, p4: Vec<i32>) -> bool {
        

        let mut sides = vec![0; 6];
        sides[0] = Self::distance(&p1, &p2);
        sides[1] = Self::distance(&p1, &p3);
        sides[2] = Self::distance(&p1, &p4);
        sides[3] = Self::distance(&p2, &p3);
        sides[4] = Self::distance(&p2, &p4);
        sides[5] = Self::distance(&p3, &p4);
        sides.sort_unstable();
        sides[0] > 0 && sides[0] == sides[1] && sides[0] == sides[2] && sides[0] == sides[3] && sides[4] == sides[5]
    }
}