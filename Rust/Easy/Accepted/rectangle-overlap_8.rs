impl Solution {
    pub fn is_rectangle_overlap(rec1: Vec<i32>, rec2: Vec<i32>) -> bool {
        
        let (mut x1, mut y1, mut x2, mut y2) = (0, 0, 0, 0);
        if rec1[0] < rec2[0] {
            x1 = rec2[0];
        } else {
            x1 = rec1[0];
        }
        if rec1[1] < rec2[1] {
            y1 = rec2[1];
        } else {
            y1 = rec1[1];
        }
        if rec1[2] < rec2[2] {
            x2 = rec1[2];
        } else {
            x2 = rec2[2];
        }
        if rec1[3] < rec2[3] {
            y2 = rec1[3];
        } else {
            y2 = rec2[3];
        }
        x2 > x1 && y2 > y1
    }
}