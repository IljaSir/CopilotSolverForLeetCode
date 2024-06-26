impl Solution {
    pub fn count_good_rectangles(rectangles: Vec<Vec<i32>>) -> i32 {
        
        let mut max = 0;
        let mut count = 0;
        for r in rectangles {
            let min = r[0].min(r[1]);
            if min > max {
                max = min;
                count = 1;
            } else if min == max {
                count += 1;
            }
        }
        count
    }
}