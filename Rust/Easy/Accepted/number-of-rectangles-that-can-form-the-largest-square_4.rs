impl Solution {
    pub fn count_good_rectangles(rectangles: Vec<Vec<i32>>) -> i32 {
        
        let mut max = 0;
        let mut count = 0;
        for r in rectangles {
            let side = r[0].min(r[1]);
            if side > max {
                max = side;
                count = 1;
            } else if side == max {
                count += 1;
            }
        }
        count
    }
}