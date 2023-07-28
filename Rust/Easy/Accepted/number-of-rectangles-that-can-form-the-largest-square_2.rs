impl Solution {
    pub fn count_good_rectangles(rectangles: Vec<Vec<i32>>) -> i32 {
        
        let mut max_len = 0;
        let mut count = 0;
        for r in rectangles {
            let len = r[0].min(r[1]);
            if len > max_len {
                max_len = len;
                count = 1;
            } else if len == max_len {
                count += 1;
            }
        }
        count
    }
}