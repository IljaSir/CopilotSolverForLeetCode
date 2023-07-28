impl Solution {
    pub fn count_good_rectangles(rectangles: Vec<Vec<i32>>) -> i32 {
        
        let mut max = 0;
        let mut count = 0;
        for i in 0..rectangles.len() {
            let min = std::cmp::min(rectangles[i][0], rectangles[i][1]);
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