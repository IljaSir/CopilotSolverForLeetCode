impl Solution {
    pub fn count_good_rectangles(rectangles: Vec<Vec<i32>>) -> i32 {
        
        let mut max = 0;
        let mut cnt = 0;
        for r in rectangles {
            let l = r[0].min(r[1]);
            if l == max {
                cnt += 1;
            } else if l > max {
                max = l;
                cnt = 1;
            }
        }
        cnt
    }
}