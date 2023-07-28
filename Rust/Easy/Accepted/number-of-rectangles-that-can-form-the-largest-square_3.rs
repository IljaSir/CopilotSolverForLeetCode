impl Solution {
    pub fn count_good_rectangles(rectangles: Vec<Vec<i32>>) -> i32 {
        
        let mut max = 0;
        let mut count = 0;
        for r in rectangles {
            let m = r[0].min(r[1]);
            if m > max {
                max = m;
                count = 1;
            } else if m == max {
                count += 1;
            }
        }
        count
    }
}